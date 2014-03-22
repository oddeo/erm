/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erm.model.svc.task;

import erm.model.domain.Author;
import erm.model.domain.Task;
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
public class TaskServiceImplTest {
    
    public TaskServiceImplTest() {
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
     * Test of getTask method, of class TaskServiceImpl.
     */
    @Test
    public void testGetTask() {
        System.out.println("getTask");
        long id = 1L;
        TaskServiceImpl instance = new TaskServiceImpl();
        Task expResult = new Task("test task", new Author("danny","jones","djones"));
        Task result = instance.getTask(id);
        assertEquals(expResult.getClass(), result.getClass());

    }

    /**
     * Test of getAllTasks method, of class TaskServiceImpl.
     */
    @Test
    public void testGetAllTasks() {
        System.out.println("getAllTasks");
        TaskServiceImpl instance = new TaskServiceImpl();
        List<Task> expResult = new ArrayList<>();
        Task task = new Task("test task", new Author("danny","jones","djones"));
        expResult.add(task);
        
        List<Task> result = instance.getAllTasks();
        assertEquals(expResult.getClass(), result.getClass());

    }

    /**
     * Test of saveTask method, of class TaskServiceImpl.
     */
    @Test
    public void testSaveTask() {
        System.out.println("saveTask");
        Task task = new Task("test task", new Author("danny","jones","djones"));
        TaskServiceImpl instance = new TaskServiceImpl();
        
        boolean expResult = true;
        boolean result = instance.saveTask(task);
        assertEquals(expResult, result);

    }

    /**
     * Test of createTask method, of class TaskServiceImpl.
     */
    @Test
    public void testCreateTask() {
        System.out.println("createTask");
        Task task = new Task("test task", new Author("danny","jones","djones"));
        TaskServiceImpl instance = new TaskServiceImpl();
        
        long expResult = 1L;
        long result = instance.createTask(task);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteTask method, of class TaskServiceImpl.
     */
    @Test
    public void testDeleteTask() {
        System.out.println("deleteTask");
        long id = 1L;
        TaskServiceImpl instance = new TaskServiceImpl();
        boolean expResult = true;
        
        boolean result = instance.deleteTask(id);
        assertEquals(expResult, result);

    }
    
}
