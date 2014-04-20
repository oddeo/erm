package erm.service.endpoint;

import erm.business.manager.AuthorMgr;
import erm.domain.Author;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

/**
 * @version 1.0
 * @author danieljones
 */
@Produces("text/*")
@Path("/authors")
@RequestScoped
public class AuthorResource {
    
    @Inject AuthorMgr mgr;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(".json")
    public List<Author> getAuthorsJson() {
        
        List<Author> el = mgr.readAll();
        
        return el;
        
    } 
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    @Path(".xml")
    public List<Author> getAuthorsXml() {
        
        List<Author> el = mgr.readAll();
        
        return el;
        
    }
    
    @GET
    @Path("{id: \\d+}")
    /**
     * Only accepts id with digits between 0 and 9
     * Uses the ?format= querystring param to allow consumer to defined content type
     * accepts xml or json as param values
     * if anything else is passed then the method returns a 406 status code (not acceptable)
     */
    public Response getEmployee(@PathParam("id") int id,
            @QueryParam("format") String format) { 
        
        ResponseBuilder builder = null;
        
        if(format == null || "xml".equalsIgnoreCase(format)) {
            
           builder = Response.ok(mgr.read(id)).type(MediaType.APPLICATION_XML);
            
        } else if ("json".equalsIgnoreCase(format)) {
            
           builder = Response.ok(mgr.read(id)).type(MediaType.APPLICATION_JSON);             
            
        } else {
            
            throw new WebApplicationException(Status.UNSUPPORTED_MEDIA_TYPE);
            
        }
        
        return builder.build();  
        
    }    
    
    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_XML})
    //@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response create(Author author) {
        
        String msg;
        if(author.getFirstName() == null || 
            author.getLastName() == null) {
            
            msg = "Author not passed in request";   
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();
            
        } else {
            
            Author result = mgr.create(author);
            msg = "New author created: '" + result;
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }
    
    @PUT  
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response update(Author author) {
        
        String msg;
        if(author.getFirstName() == null || 
            author.getLastName() == null) {
            
            msg = "Author not passed in request";   
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();
            
        } else {
            
            Author result = mgr.update(author);
            msg = "Employee updated: '" + author;
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }
    
    @DELETE
    @Path("/delete/{id: \\d+}")
    public void delete(@PathParam("id") int id) {
            
        Author result = mgr.read(id);
        mgr.delete(result);
        
    }    
    
}
