package names;

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
    private ProtectedNameDetailsService protectedNameDetailsService;
    private ClientDetailsService clientDetailsService;
    private Validator validator;

    @Autowired
    public NamesResource(NamesService namesService, NameDetailsService nameDetailsService, AccountUnprotectedNamesService accountUnprotectedNamesService,
                         UnprotectedNameDetailsService unprotectedNameDetailsService, AccountProtectedNamesService accountProtectedNamesService, AccountClientsService accountClientsService,
                          ProtectedNameDetailsService protectedNameDetailsService, ClientDetailsService clientDetailsService, Validator validator) {
        this.namesService = namesService;
        this.nameDetailsService = nameDetailsService;
        this.accountUnprotectedNamesService = accountUnprotectedNamesService;
        this.unprotectedNameDetailsService = unprotectedNameDetailsService;
        this.accountProtectedNamesService = accountProtectedNamesService;
        this.accountClientsService = accountClientsService;
        this.protectedNameDetailsService = protectedNameDetailsService;
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
            if(nameDetailsService.getName(nameId) != null) {
                if (unprotectedNameDetailsService.getDetails(nameId, accountId) == null) {
                    if (!isProtectedClient(nameId)) {
                        return Response.status(Response.Status.CREATED).entity(accountUnprotectedNamesService.createUnprotectedName(unprotectedName)).build();
                    }
                    return Response.status(Response.Status.CONFLICT).entity("Name is already protected or a client to someone else").build();
                }
                return Response.status(Response.Status.CONFLICT).entity("unprotected name already exists").build();
            }
            return Response.status(Response.Status.NOT_FOUND).entity("name does not exist").build();
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
            if(nameDetailsService.getName(nameId) != null) {
                if (!isProtectedClient(nameId)) {
                    Set<ConstraintViolation<ProtectedName>> constraintViolations = validator.validate(protectedName);
                    if (constraintViolations.size() == 0) {
                        return Response.status(Response.Status.CREATED).entity(accountProtectedNamesService.createProtectedName(protectedName)).build();
                    }
                    return Response.status(Response.Status.BAD_REQUEST).entity(constraintViolations).build();
                }
                return Response.status(Response.Status.CONFLICT).entity("Name is already protected or a client to someone else").build();
            }
            return Response.status(Response.Status.NOT_FOUND).entity("name does not exist").build();
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
            if(nameDetailsService.getName(nameId) != null) {
                if (!isClient(nameId)) {
                    Set<ConstraintViolation<Client>> constraintViolations = validator.validate(client);
                    if (constraintViolations.size() == 0) {
                        return Response.status(Response.Status.CREATED).entity(accountClientsService.createClient(client)).build();
                    }
                    return Response.status(Response.Status.BAD_REQUEST).entity(constraintViolations).build();
                }
                return Response.status(Response.Status.CONFLICT).entity("Name is already a client to someone else").build();
            }
            return Response.status(Response.Status.NOT_FOUND).entity("name does not exist").build();
        } catch (SQLException |InstantiationException|IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private boolean isProtectedClient(int nameId) throws SQLException, InstantiationException, IllegalAccessException {
        return (protectedNameDetailsService.getDetails(nameId) != null
                || isClient(nameId));
    }

    private boolean isClient(int nameId) throws SQLException, InstantiationException, IllegalAccessException {
        return clientDetailsService.getDetails(nameId) != null;
    }
}
