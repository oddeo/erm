package erm.service.endpoint;

import erm.model.business.manager.EmployeeMgr;
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
@Produces("text/*")
@Path("/employees")
@RequestScoped
public class EmployeeResource {
    
    @Inject
    private EmployeeMgr mgr;
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path(".json")
    public List<Employee> getEmployeesJson() {
        
        List<Employee> el = mgr.readAll();
        
        return el;
        
    } 
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    @Path(".xml")
    public List<Employee> getEmployeesXml() {
        
        List<Employee> el = mgr.readAll();
        
        return el;
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    @Path("{id: \\d+}.xml")
    /**
     * Only accepts id with digits between 0 and 9
     */
    public Response getEmployeeXml(@PathParam("id") int id) {       
        
        return getResponse(id);
        
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id: \\d+}.json")
    /**
     * Only accepts id with digits between 0 and 9
     */
    public Response getEmployeeJson(@PathParam("id") int id) {
        
        return getResponse(id);
        
    }    
    
    @POST
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
    @Path("/update")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
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
    @Path("/delete/{id: \\d+}")
    public void delete(@PathParam("id") int id) {
            
        Employee empl = mgr.read(id);
        mgr.delete(empl);
        
    }
    
    private Response getResponse(int id) {
        
        ResponseBuilder builder = Response.ok(mgr.read(id)); 
        
        return builder.build();        
        
    }
    
}
