package names.unprotectednames;

import dataObjects.Name;
import dataObjects.UnprotectedName;
import names.NameDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by Vasia on 08/11/2014.
 */
@Path("/{accountId}/unprotectedNames")
public class UnprotectedNameDetailsResource {

    UnprotectedNameDetailsService unprotectedNameDetailsService;
    NameDetailsService nameDetailsService;
    private Validator validator;

    @Autowired
    public UnprotectedNameDetailsResource(UnprotectedNameDetailsService unprotectedNameDetailsService, NameDetailsService nameDetailsService,
                                          Validator validator) {
        this.unprotectedNameDetailsService = unprotectedNameDetailsService;
        this.nameDetailsService = nameDetailsService;
        this.validator = validator;
    }

    @GET
    @Path("/{nameId}")
    @Produces("application/json")
    public Response getUnprotectedNameDetails(@PathParam("nameId") int id, @PathParam("accountId") int accountId) {
        try{
            UnprotectedName unprotectedNameDetails = unprotectedNameDetailsService.getDetails(id, accountId);
            return Response.ok(unprotectedNameDetails).build();
        }catch (SQLException |InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{nameId}")
    public Response removeUnprotectedName(@PathParam("nameId") int nameId, @PathParam("accountId") int accountId,
                                          @QueryParam("clientFirstName") String confirmedClientFirstName) {
        try {
            Name name = nameDetailsService.getName(nameId);
            if(name.getFirstName().toUpperCase().equals(confirmedClientFirstName)){
                if(unprotectedNameDetailsService.getDetails(nameId, accountId) != null) {
                    unprotectedNameDetailsService.removeUnprotectedName(nameId, accountId);
                    return Response.noContent().entity(name.getFirstName() + " has been successfully deleted").build();
                }
                return Response.status(Response.Status.BAD_REQUEST).entity(name.getFirstName() + " " + name.getOtherNames()
                        + " does not exist and therefore can not be deleted").build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Did not delete unprotected name because the first name " +
                    "was not spelt correctly in CAPITALS").build();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
