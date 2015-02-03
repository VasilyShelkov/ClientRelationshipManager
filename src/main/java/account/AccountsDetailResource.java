package account;

import dataObjects.Account;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by Vasia on 08/11/2014.
 */
@Path("/{accountId}")
public class AccountsDetailResource {

    private AccountDetailService accountDetailService;
    private Validator validator;

    @Autowired
    public AccountsDetailResource(AccountDetailService accountDetailService, Validator validator) {
        this.accountDetailService = accountDetailService;
        this.validator = validator;
    }

    @GET
    @Produces("application/json")
    public Response getAccountDetails(@PathParam("accountId") int id) {
        try{
            Account accountDetails = accountDetailService.getAccountDetails(id);
            return Response.ok(accountDetails).build();
        }catch (SQLException |InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateAccount(@PathParam("accountId") int accountId, Account account) {
        try {
            Account accountDetails = accountDetailService.getAccountDetails(accountId);
            if (accountDetails != null){
                if(account.getUserName().equals(accountDetails.getUserName()) || accountDetailService.getAccountDetails(account.getUserName()) == null) {
                    Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account);
                    if (constraintViolations.size() == 0) {
                        return Response.ok(accountDetailService.updateAccount(accountDetails.getAccountID(), account)).build();
                    }
                    return Response.status(Response.Status.BAD_REQUEST).entity(constraintViolations).build();
                }
                return Response.status(Response.Status.CONFLICT).entity("Can not change " + accountDetails.getUserName() + "'s username to "
                        + account.getUserName() + " because a different account is already using that username").build();
            }else {
                return Response.noContent().entity(AccountMessages.ACCOUNT_CAN_NOT_BE_UPDATED).build();
            }
        } catch (SQLException |InstantiationException|IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Consumes("application/json")
    public Response deleteAccount(@QueryParam("username") String confirmedUsername, @PathParam("accountId") int id, Account account) {
        try {
            if(account.getUserName().toUpperCase().equals(confirmedUsername)){
                if(accountDetailService.getAccountDetails(id) != null) {
                    accountDetailService.deleteAccount(account);
                    return Response.ok(AccountMessages.ACCOUNT_DELETE_SUCCESS).build();
                }
                return Response.noContent().entity(account.getUserName() + " does not exist and therefore can not be deleted").build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(AccountMessages.ACCOUNT_DELETE_NOT_CORRECT).build();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
