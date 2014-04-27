package erm.business.manager;

import erm.domain.Employee;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.naming.Context;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author danieljones
 */
@DataSourceDefinition(
  name="java:jdbc/ERM", 
  className="com.mysql.jdbc.jdbc2.optional.MysqlDataSource", 
  user="root",
  password="admin",
  databaseName="ERM",
  serverName="localhost",
  portNumber=3306)
public class EmployeeMgrBeanTest {
    
    public EmployeeMgrBeanTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /*  --- Could not get this working
    @Test
    public void testReturnOneEmployeeFromDb() {
        
        try {
            
          EJBContainer ec = EJBContainer.createEJBContainer();
          Context ctx = ec.getContext();
          EmployeeMgr manager = (EmployeeMgr)
          ctx.lookup( "java:global/classes/EmployeeMgrBean!acme.business.EmployeeMgr");
          Assert.assertNotNull(manager.read(1));
          ec.close();
          
        } catch (NamingException ex) {
            
          Assert.fail("Failed to find customer with id: 1"); 
          
        }
        
    }
    */

    /**
     * Test of create method, of class EmployeeMgrBean.
     */
    @Test
    public void testCreateEmployee() throws Exception {
        System.out.println("CreateEmployee");
        
        Employee fakeEmployee = new Employee("first","last");        
        EntityManager em = mock(EntityManager.class);
        
        EmployeeMgr instance = new EmployeeMgrBean(em);       

        Assert.assertEquals(fakeEmployee, instance.create(fakeEmployee));
        verify(em).persist(fakeEmployee);        

    }

    /**
     * Test of read method, of class EmployeeMgrBean.
     */
    @Test
    public void testReadEmployee() throws Exception {
        System.out.println("ReadEmployee");
        
        int id = 0;
        Employee fakeEmployee = new Employee("first","last");        
        EntityManager em = mock(EntityManager.class);
        when(em.find(Employee.class, id)).thenReturn(fakeEmployee);
        EmployeeMgr instance = new EmployeeMgrBean(em);       

        Assert.assertEquals(fakeEmployee, instance.read(id));        

    }

    /**
     * Test of update method, of class EmployeeMgrBean.
     */
    @Test
    public void testUpdateEmployee() throws Exception {
        System.out.println("UpdateEmployee");
        
        Employee fakeEmployee = new Employee("first","last");        
        EntityManager em = mock(EntityManager.class);
        when(em.merge(fakeEmployee)).thenReturn(fakeEmployee);
        EmployeeMgr instance = new EmployeeMgrBean(em);       

        Assert.assertEquals(fakeEmployee, instance.update(fakeEmployee));
  
    }

    /**
     * Test of delete method, of class EmployeeMgrBean.
     */
    @Test
    public void testDeleteEmployee() throws Exception {
        System.out.println("DeleteEmployee");
        
        Employee fakeEmployee = new Employee("first","last");        
        EntityManager em = mock(EntityManager.class);
        when(em.merge(fakeEmployee)).thenReturn(fakeEmployee);
        EmployeeMgr instance = new EmployeeMgrBean(em);       

        instance.delete(fakeEmployee);
        
        verify(em).remove(fakeEmployee);
    }
    
}
