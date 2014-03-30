package erm.service.endpoint;

import erm.model.business.manager.RosterManager;
import erm.model.domain.Employee;
import java.util.List;
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
public class EmployeeResource {
    
    //Static RosterManager
    RosterManager rMgr = RosterManager.getInstance();
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{id: \\d+}")
    /**
     * Only accepts id with digits between 0 and 9
     */
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
            
            long empId = rMgr.createEmployee(employee);
            msg = "New employee: '" + employee.getFirstName() + 
                  " " + employee.getLastName() +
                  "' created with manager: '" + employee.getManager() +
                  "' and id: '" + empId + "'";
            
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
            
            boolean result = rMgr.saveEmployee(employee);
            msg = "Employee: '" + employee.getFirstName() + 
                  " " + employee.getLastName() +
                    "' updated? '" + result + "'";
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }
    
    @DELETE
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/delete/{id: \\d+}")
    public Response delete(@PathParam("id") int id) {
        
        String msg;
        if(id >= 0) {
            
            boolean result = rMgr.deleteEmployee(id);
            msg = "Employee deleted? '" + result + "'";
            
        } else {
            
            msg = "Employee not passed in request";
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(msg).
                    type(MediaType.TEXT_PLAIN).
                    build();
            
        }
        
        return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        
    }
    
}
