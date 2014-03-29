package erm.service.endpoint;

import erm.model.business.manager.RosterManager;
import erm.model.domain.Employee;
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
 * RESTful call for employee resource
 * @version 1.0
 * @author danieljones
 */
@Path("/employees")
public class EmployeeResource {
    
    //Static RosterManager
    RosterManager rMgr = RosterManager.getInstance();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{id}")
    public Response getEmployee(@PathParam("id") int id) {
        
        ResponseBuilder builder = Response.ok(rMgr.getEmployee(id)); //id
        
        return builder.build();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllEmployees() {
        
        List<Employee> employees = rMgr.getMyRoster(1L);
        GenericEntity entity = new GenericEntity<List<Employee>>(employees){};
        ResponseBuilder builder = Response.ok(entity);
        
        return builder.build();
        
    }
    
}
