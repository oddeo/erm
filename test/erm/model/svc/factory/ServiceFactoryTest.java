/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erm.model.svc.factory;

import erm.model.svc.IService;
import erm.model.svc.comment.CommentServiceImpl;
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
public class ServiceFactoryTest {
    
    public ServiceFactoryTest() {
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
     * Test of getService method, of class ServiceFactory.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetService() throws Exception {
        System.out.println("getService");
        String serviceName = "ICommentService";
        ServiceFactory instance = ServiceFactory.getInstance();
        
        IService expResult = new CommentServiceImpl();
        IService result = instance.getService(serviceName);
        assertEquals(expResult.getClass(), result.getClass());

    }
    
}
