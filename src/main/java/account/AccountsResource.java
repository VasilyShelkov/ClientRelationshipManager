package account;

import account.unprotectedname.UnprotectedNameAccountsService;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import dataObjects.Account;
import io.dropwizard.hibernate.UnitOfWork;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Vasia on 08/11/2014.
 */
@Path("/accounts")
public class AccountsResource {

    private AccountService accountService;
    private AccountDetailService accountDetailService;
    private UnprotectedNameAccountsService unprotectedNameAccountsService;
    private Validator validator;

    @Autowired
    public AccountsResource(AccountService accService, AccountDetailService accDetailsService, UnprotectedNameAccountsService accUnprotectedNamesService,
                            Validator validator) {
        this.accountService = accService;
        this.accountDetailService = accDetailsService;
        this.unprotectedNameAccountsService = accUnprotectedNamesService;
        this.validator = validator;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response getAllAccounts() {
        try{
            return Response.ok(accountService.getAllAccounts()).build();
        }catch (SQLException|InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response createAccount(Account account) {
        try {
            Account accountDetails = accountDetailService.getAccountDetails(account.getUserName());
            if (accountDetails == null){
                Set<ConstraintViolation<Account>> constraintViolations = validator.validate( account );
                if(constraintViolations.size() == 0){
                    return Response.status(Response.Status.CREATED).entity(accountService.createAccount(account)).build();
                }
                return Response.status(Response.Status.BAD_REQUEST).entity(constraintViolations).build();
            }
            return Response.status(Response.Status.CONFLICT).entity(AccountMessages.ACCOUNT_ALREADY_EXISTS).build();
        } catch (SQLException |InstantiationException|IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Path("/{nameId}/Unprotected")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response getUnprotectedNameAccounts(@PathParam("nameId") int id) {
        try{
            return Response.ok(unprotectedNameAccountsService.getUnprotectedNameAccounts(id)).build();
        }catch (SQLException |InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
