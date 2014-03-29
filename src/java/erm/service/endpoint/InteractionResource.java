package erm.service.endpoint;

import erm.model.business.manager.InteractionManager;
import erm.model.domain.Interaction;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * Interaction Resource Aggregates Domain Objects into a logical DTO
 * @version 1.0
 * @author danieljones
 */
@Path("/interactions")
public class InteractionResource {
    
    // static interaction manager
    InteractionManager iMgr = InteractionManager.getInstance();
    
    @GET
    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response getEmployee(@PathParam("id") int id) {
        
        ResponseBuilder builder = Response.ok(iMgr.getInteraction(id)); //id
        
        return builder.build();
    }
    
    @GET
    @Produces("application/xml")
    public Response getAllInteractions() {
        
        List<Interaction> interactions = iMgr.getAllInteractions();
        GenericEntity entity = new GenericEntity<List<Interaction>>(interactions){};
        ResponseBuilder builder = Response.ok(entity);
        
        return builder.build();
        
    }
    
    
}
