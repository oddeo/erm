package erm.service.endpoint;

import erm.model.business.exception.InvalidInteractionException;
import erm.model.business.manager.InteractionManager;
import erm.model.domain.Interaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * Interaction Resource Aggregates Domain Objects into a logical DTO
 *
 * @version 1.0
 * @author danieljones
 */
@Path("/interactions")
public class InteractionResource {

    // static interaction manager
    InteractionManager iMgr = InteractionManager.getInstance();

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{id: \\d+}")
    /**
     * Only accepts id with digits between 0 and 9
     */
    public Response getInteraction(@PathParam("id") int id) {

        ResponseBuilder builder = Response.ok(iMgr.getInteraction(id)); //id

        return builder.build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllInteractions() {

        List<Interaction> interactions = iMgr.getAllInteractions();
        GenericEntity entity = new GenericEntity<List<Interaction>>(interactions) {
        };
        ResponseBuilder builder = Response.ok(entity);

        return builder.build();

    }

    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Interaction interaction) {

        String msg = "";
        if (interaction.getComment() == null) {

            msg = "Interaction request is incomplete.  "
                    + "Item is null or missing required comment";
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();

        } else {
            try {

                long interactionId = iMgr.createInteraction(interaction);
                msg = "New interaction w comment: '" + interaction.getComment()
                        + "' and id: '" + interactionId + "'";

            } catch (InvalidInteractionException ex) {

                Logger.getLogger(InteractionResource.class.getName()).
                        log(Level.SEVERE, null, ex);

            }

        }

        return Response.ok(msg, MediaType.TEXT_PLAIN).build();

    }
    
    @PUT
    @Produces({MediaType.TEXT_PLAIN})    
    @Path("/update")
    public Response update(Interaction interaction) {
        
        String msg = "";
        if (interaction.getComment() == null) {

            msg = "Interaction request is incomplete.  "
                    + "Item is null or missing required comment";
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();
            
        } else {
            
            try {

                boolean result = iMgr.saveInteraction(interaction);
                msg = "Updated interaction w comment: '" + interaction.getComment()
                        + "' saved? '" + result + "'";

            } catch (InvalidInteractionException ex) {

                Logger.getLogger(InteractionResource.class.getName()).
                        log(Level.SEVERE, null, ex);

            }
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }
    
    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/delete/{id: \\d+}")
    public Response delete(@PathParam("id") int id) {
        
        String msg;
        if(id >= 0) {
            
            boolean result = iMgr.deleteInteraction(id);
            msg = "Interaction deleted? '" + result + "'";
            
        } else {
            
            msg = "Interaction not passed in request";
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }

}
