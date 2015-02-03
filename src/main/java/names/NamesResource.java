package names;

import account.client.ClientAccountsService;
import account.protectedname.ProtectedNameAccountsService;
import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import dataObjects.Client;
import dataObjects.Name;
import dataObjects.ProtectedName;
import dataObjects.UnprotectedName;
import io.dropwizard.hibernate.UnitOfWork;
import names.clients.AccountClientsService;
import names.clients.ClientDetailsService;
import names.protectednames.AccountProtectedNamesService;
import names.protectednames.ProtectedNameDetailsService;
import names.unprotectednames.AccountUnprotectedNamesService;
import names.unprotectednames.UnprotectedNameDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Vasia on 08/11/2014.
 */
@Path("/names")
public class NamesResource {

    private NamesService namesService;
    private NameDetailsService nameDetailsService;
    private AccountUnprotectedNamesService accountUnprotectedNamesService;
    private UnprotectedNameDetailsService unprotectedNameDetailsService;
    private AccountProtectedNamesService accountProtectedNamesService;
    private AccountClientsService accountClientsService;
    private ProtectedNameAccountsService protectedNameAccountsService;
    private ProtectedNameDetailsService protectedNameDetailsService;
    private ClientAccountsService clientAccountsService;
    private ClientDetailsService clientDetailsService;
    private Validator validator;

    @Autowired
    public NamesResource(NamesService namesService, NameDetailsService nameDetailsService, AccountUnprotectedNamesService accountUnprotectedNamesService,
                         UnprotectedNameDetailsService unprotectedNameDetailsService, AccountProtectedNamesService accountProtectedNamesService, AccountClientsService accountClientsService,
                         ProtectedNameAccountsService protectedNameAccountsService, ProtectedNameDetailsService protectedNameDetailsService,
                         ClientAccountsService clientAccountsService, ClientDetailsService clientDetailsService, Validator validator) {
        this.namesService = namesService;
        this.nameDetailsService = nameDetailsService;
        this.accountUnprotectedNamesService = accountUnprotectedNamesService;
        this.unprotectedNameDetailsService = unprotectedNameDetailsService;
        this.accountProtectedNamesService = accountProtectedNamesService;
        this.accountClientsService = accountClientsService;
        this.protectedNameAccountsService = protectedNameAccountsService;
        this.protectedNameDetailsService = protectedNameDetailsService;
        this.clientAccountsService = clientAccountsService;
        this.clientDetailsService = clientDetailsService;
        this.validator = validator;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response getAllNames() {
        try{
            return Response.ok(namesService.getAllNames()).build();
        }catch (SQLException |InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response createName(Name name) {
        try {
            List<Name> existingNames = nameDetailsService.searchNames(name.getFirstName(), name.getOtherNames(), name.getCompany(), name.getMobileNumber());
                if(existingNames.size() == 0){
                    Set<ConstraintViolation<Name>> constraintViolations = validator.validate(name);
                    if(constraintViolations.size() == 0){
                        return Response.status(Response.Status.CREATED).entity(namesService.createName(name)).build();
                    }
                    List<String> validationErrors = constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
                    return Response.status(Response.Status.BAD_REQUEST).entity(validationErrors).build();
            }
            return Response.status(Response.Status.CONFLICT).entity(existingNames).build();
        } catch (SQLException |InstantiationException|IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Path("/unprotected/account/{accountId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response getAllAccountUnprotectedNames(@PathParam("accountId") int accountId) {
        try{
            return Response.ok(accountUnprotectedNamesService.getUnprotectedNames(accountId)).build();
        }catch (SQLException |InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Path("/protected/account/{accountId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response getAllAccountProtectedNames(@PathParam("accountId") int accountId) {
        try{
            return Response.ok(accountProtectedNamesService.getProtectedNames(accountId)).build();
        }catch (SQLException |InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @Path("/client/account/{accountId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response getAllAccountClients(@PathParam("accountId") int accountId) {
        try{
            return Response.ok(accountClientsService.getClients(accountId)).build();
        }catch (SQLException |InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/unprotected")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response createUnprotectedName(UnprotectedName unprotectedName) {
        try {
            int nameId = unprotectedName.getNameId();
            int accountId = unprotectedName.getAccountId();
            if(unprotectedNameDetailsService.getDetails(nameId, accountId) == null) {
                if (!isProtectedClient(nameId)) {
                    return Response.status(Response.Status.CREATED).entity(accountUnprotectedNamesService.createUnprotectedName(unprotectedName)).build();
                }
                return Response.status(Response.Status.CONFLICT).entity("Name is already protected or a client to someone else").build();
            }
            return Response.status(Response.Status.CONFLICT).entity("unprotected name already exists").build();
        } catch (SQLException |InstantiationException|IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/protected")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response createProtectedName(ProtectedName protectedName) {
        try {
            int nameId = protectedName.getNameId();
            int accountId = protectedName.getAccountId();
            if(protectedNameDetailsService.getDetails(nameId, accountId) != null) {
                if (!isProtectedClient(nameId)) {
                    Set<ConstraintViolation<ProtectedName>> constraintViolations = validator.validate(protectedName);
                    if (constraintViolations.size() == 0) {
                        return Response.status(Response.Status.CREATED).entity(accountProtectedNamesService.createProtectedName(accountId, protectedName)).build();
                    }
                    return Response.status(Response.Status.BAD_REQUEST).entity(constraintViolations).build();
                }
                return Response.status(Response.Status.CONFLICT).entity("Name is already protected or a client to someone else").build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("protected name already exists").build();
        } catch (SQLException |InstantiationException|IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/client")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    @ExceptionMetered
    public Response createClient(Client client) {
        try {
            int nameId = client.getNameId();
            int accountId = client.getAccountId();
            if(clientDetailsService.getDetails(nameId, accountId) != null) {
                if (!isClient(nameId)) {
                    Set<ConstraintViolation<Client>> constraintViolations = validator.validate(client);
                    if (constraintViolations.size() == 0) {
                        return Response.status(Response.Status.CREATED).entity(accountClientsService.createClient(accountId, client)).build();
                    }
                    return Response.status(Response.Status.BAD_REQUEST).entity(constraintViolations).build();
                }
                return Response.status(Response.Status.CONFLICT).entity("Name is already a client to someone else").build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("client already exists").build();
        } catch (SQLException |InstantiationException|IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private boolean isProtectedClient(int nameId) throws SQLException, InstantiationException, IllegalAccessException {
        return (protectedNameAccountsService.getProtectedNameAccounts(nameId).size() > 0
                || isClient(nameId));
    }

    private boolean isClient(int nameId) throws SQLException, InstantiationException, IllegalAccessException {
        return clientAccountsService.getClientNameAccounts(nameId).size() > 0;
    }
}
