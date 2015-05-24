package names.protectednames;

import dataObjects.Name;
import dataObjects.ProtectedName;
import names.NameDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by Vasia on 08/11/2014.
 */

@Path("/{accountId}/protectedNames")
public class ProtectedNameDetailsResource {

    private ProtectedNameDetailsService protectedNameDetailsService;
    NameDetailsService nameDetailsService;

    @Autowired
    public ProtectedNameDetailsResource(ProtectedNameDetailsService protectedNameDetailsService, NameDetailsService nameDetailsService) {
        this.protectedNameDetailsService = protectedNameDetailsService;
        this.nameDetailsService = nameDetailsService;
    }

    @GET
    @Path("/{nameId}")
    @Produces("application/json")
    public Response getProtectedNameDetails(@PathParam("nameId") int id, @PathParam("accountId") int accountId) {
        try{
            ProtectedName protectedNameAccountsDetails = protectedNameDetailsService.getDetails(id, accountId);
            return Response.ok(protectedNameAccountsDetails).build();
        }catch (SQLException |InstantiationException|IllegalAccessException e){
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{nameId}")
    public Response removeProtectedName(@PathParam("nameId") int nameId, @PathParam("accountId") int accountId,
                                        @QueryParam("clientFirstName") String confirmedClientFirstName) {
        try {
            Name name = nameDetailsService.getName(nameId);
            if(name.getFirstName().toUpperCase().equals(confirmedClientFirstName)){
                if(protectedNameDetailsService.getDetails(nameId, accountId) != null) {
                    protectedNameDetailsService.removeUnprotectedName(nameId, accountId);
                    return Response.status(Response.Status.OK).entity(name.getFirstName() + " has been successfully deleted").build();
                }
                return Response.status(Response.Status.BAD_REQUEST).entity(name.getFirstName() + " " + name.getOtherNames()
                        + " does not exist and therefore can not be deleted").build();
            }
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Did not delete protected name because the first name " +
                    "was not spelt correctly in CAPITALS").build();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
