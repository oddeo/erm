package erm.service.endpoint;

import erm.model.business.manager.EmployeeMgr;
import erm.model.business.manager.RosterManager;
import erm.model.domain.Employee;
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
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * RESTful call for employee resource
 * all GET methods in this service should return json or xml depending
 * on the application type sent in the header request
 * i.e. for json
 * curl --header "Accept: application/json" http://localhost:8080/erm/rest/employees
 * @version 1.0
 * @author danieljones
 */
@Path("/employees")
@RequestScoped
public class EmployeeResource {
    
    @Inject
    private EmployeeMgr mgr;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{id: \\d+}")
    /**
     * Only accepts id with digits between 0 and 9
     */
    public Response getEmployee(@PathParam("id") int id) {
        
        ResponseBuilder builder = Response.ok(mgr.read(id)); //id
        
        return builder.build();
    }
    
    @POST
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response create(Employee employee) {
        
        String msg;
        if((employee.getFirstName() == null || 
            employee.getLastName() == null) || 
            employee.getManager() == null) {
            
            msg = "Employee not passed in request";   
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();
            
        } else {
            
            Employee empl = mgr.create(employee);
            msg = "New employee created: '" + empl;
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }
    
    @PUT
    @Produces({MediaType.TEXT_PLAIN})    
    @Path("/update")
    public Response update(Employee employee) {
        
        String msg;
        if((employee.getFirstName() == null || 
            employee.getLastName() == null) || 
            employee.getManager() == null) {
            
            msg = "Employee not passed in request";   
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();
            
        } else {
            
            Employee empl = mgr.update(employee);
            msg = "Employee updated: '" + empl;
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }
    
    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/delete")
    public Response delete(@PathParam("id") int id) {
        
        String msg;
        if(id >= 0) {
            
            Employee empl = mgr.read(id);
            mgr.delete(empl);
            msg = "Employee deleted: '" + empl + "'";
            
        } else {
            
            msg = "Employee id not passed in request";
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }
    
}
