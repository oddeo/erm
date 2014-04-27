package erm.service.endpoint;

import erm.business.manager.EmployeeMgr;
import erm.business.manager.EmployeeMgrBean;
import erm.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @version 1.0
 * @author danieljones
 */
public class EmployeeResourceTest {
    
    public EmployeeResourceTest() {
    }
    
    @Before
    public void setUp() {       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEmployeesJson method, of class EmployeeResource.
     */
    @Test
    public void testGetEmployeesJsonReturnsEmployeesList() {
        System.out.println("GetEmployeesJsonReturnsEmployeesList");
        
        List<Employee> fakeList = new ArrayList<>();
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        when(manager.readAll()).thenReturn(fakeList);
        
        EmployeeResource instance = new EmployeeResource(manager);

        assertEquals(fakeList, instance.getEmployeesJson());

    }

    /**
     * Test of getEmployeesXml method, of class EmployeeResource.
     */
    @Test
    public void testGetEmployeesXmlReturnsEmployeesList() {
        System.out.println("GetEmployeesXmlReturnsEmployeesList");

        List<Employee> fakeList = new ArrayList<>();
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        when(manager.readAll()).thenReturn(fakeList);
        
        EmployeeResource instance = new EmployeeResource(manager);

        assertEquals(fakeList, instance.getEmployeesXml());
        
    }

    /**
     * Test of getEmployee method, of class EmployeeResource.
     */
    @Test
    public void testGetEmployeeReturnsOkResponseStatus() {
        System.out.println("GetEmployeeReturnsOkResponseStatus");
        
        int id = 0;
        String format = "xml";
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        ResponseBuilder response = Response.ok(manager.read(id)).type(MediaType.APPLICATION_XML);

        EmployeeResource instance = new EmployeeResource(manager);

        assertEquals(response.build().getStatus(), instance.getEmployee(id, format).getStatus());

    }
    
    /**
     * Test of getEmployee method, of class EmployeeResource.
     */
    @Test
    public void testGetEmployeeThrowsWebApplicationException() {
        System.out.println("GetEmployeeThrowsWebApplicationException");
        
        int id = 0;
        String format = "";
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        ResponseBuilder response = Response.ok(manager.read(id)).type(MediaType.APPLICATION_XML);
        EmployeeResource instance = new EmployeeResource(manager);
        
        try {
            
            instance.getEmployee(id, format);
            
        } catch(WebApplicationException ex) {
            
            assertEquals(WebApplicationException.class, ex.getClass());
            
        }

    }

    /**
     * Test of create method, of class EmployeeResource.
     */
    @Test
    public void testCreateEmployee() {
        System.out.println("CreateEmployee");
        
        Employee fakeEmployee = new Employee("first","last");
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        ResponseBuilder response = Response.ok(manager.create(fakeEmployee))
                .type(MediaType.APPLICATION_XML);
        
        EmployeeResource instance = new EmployeeResource(manager);

        assertEquals(response.build().getStatus(), instance.create(fakeEmployee).getStatus());

    }
    
    /**
     * Test of create method, of class EmployeeResource.
     */
    @Test
    public void testCreateInvalidEmployeeReturnsBadRequestResponse() {
        System.out.println("CreateInvalidEmployeeReturnsBadRequestResponse");
        
        Employee fakeEmployee = new Employee();
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST).
                                    type(MediaType.TEXT_PLAIN);
        
        EmployeeResource instance = new EmployeeResource(manager);

        assertEquals(response.build().getStatus(), instance.create(fakeEmployee).getStatus());

    }

    /**
     * Test of update method, of class EmployeeResource.
     */
    @Test
    public void testUpdateEmployee() {
        System.out.println("UpdateEmployee");
        
        Employee fakeEmployee = new Employee("first","last");
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        ResponseBuilder response = Response.ok(manager.create(fakeEmployee))
                .type(MediaType.APPLICATION_XML);
        
        EmployeeResource instance = new EmployeeResource(manager);

        assertEquals(response.build().getStatus(), instance.update(fakeEmployee).getStatus());        
        
    }
    
    /**
     * Test of update method, of class EmployeeResource.
     */    
    @Test
    public void testUpdateInvalidEmployeeReturnsBadRequestResponse() {
        System.out.println("UpdateInvalidEmployeeReturnsBadRequestResponse");
        
        Employee fakeEmployee = new Employee();
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST).
                                    type(MediaType.TEXT_PLAIN);
        
        EmployeeResource instance = new EmployeeResource(manager);

        assertEquals(response.build().getStatus(), instance.update(fakeEmployee).getStatus());

    }

    /**
     * Test of delete method, of class EmployeeResource.
     */
    @Test
    public void testDeleteEmployee() {
        System.out.println("DeleteEmployee");
        
        int id = 0;
        Employee fakeEmployee = new Employee("first","last");
        EmployeeMgr manager = mock(EmployeeMgrBean.class);
        when(manager.read(id)).thenReturn(fakeEmployee);

        EmployeeResource instance = new EmployeeResource(manager);
        
        instance.delete(id);

        verify(manager).delete(fakeEmployee);
    }
    
}
