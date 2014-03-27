/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erm.model.svc.roster;

import erm.model.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danieljones
 */
public class RosterServiceImplTest {
    
    public RosterServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEmployee method, of class RosterServiceImpl.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        long id = 0L;
        RosterServiceImpl instance = new RosterServiceImpl();
        Employee expResult = new Employee();
        Employee result = instance.getEmployee(id);
        assertEquals(expResult.getClass(), result.getClass());

    }

    /**
     * Test of getMyRoster method, of class RosterServiceImpl.
     */
    @Test
    public void testGetMyRoster() {
        System.out.println("getMyRoster");
        long leaderId = 0L;
        RosterServiceImpl instance = new RosterServiceImpl();
        List<Employee> expResult = new ArrayList<>();
        List<Employee> result = instance.getMyRoster(leaderId);
        assertEquals(expResult.getClass(), result.getClass());
        
    }

    /**
     * Test of setManager method, of class RosterServiceImpl.
     */
    @Test
    public void testSetManager() {
        System.out.println("setManager");
        Employee employee = new Employee("first", "last", "test manager");
        RosterServiceImpl instance = new RosterServiceImpl();
        boolean expResult = true;
        boolean result = instance.saveEmployee(employee);
        assertEquals(expResult, result);

    }

    /**
     * Test of createEmployee method, of class RosterServiceImpl.
     */
    @Test
    public void testCreateEmployee() {
        System.out.println("createEmployee");
        Employee employee = new Employee("first", "last", "test manager");
        RosterServiceImpl instance = new RosterServiceImpl();
        long expResult = 1L;
        long result = instance.createEmployee(employee);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteEmployee method, of class RosterServiceImpl.
     */
    @Test
    public void testDeleteEmployee() {
        System.out.println("deleteEmployee");
        long id = 1L;
        RosterServiceImpl instance = new RosterServiceImpl();
        boolean expResult = true;
        boolean result = instance.deleteEmployee(id);
        assertEquals(expResult, result);

    }
    
}
