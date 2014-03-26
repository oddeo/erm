/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erm.model.business.manager;

import erm.model.business.exception.InvalidInteractionException;
import erm.model.domain.Author;
import erm.model.domain.Comment;
import erm.model.domain.Interaction;
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
public class InteractionManagerTest {
    
    public InteractionManagerTest() {
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
     * Test of getInteraction method, of class InteractionManager.
     */
    @Test
    public void testGetInteraction() {
        System.out.println("getInteraction");
        long id = 0L;
        InteractionManager instance = InteractionManager.getInstance();
        Interaction expResult = new Interaction();
        Interaction result = instance.getInteraction(id);
        assertEquals(expResult.getClass(), result.getClass());

    }

    /**
     * Test of getAllInteractions method, of class InteractionManager.
     */
    @Test
    public void testGetAllInteractions() {
        System.out.println("getAllInteractions");
        InteractionManager instance = InteractionManager.getInstance();
        List<Interaction> expResult = new ArrayList<>();
        List<Interaction> result = instance.getAllInteractions();
        assertEquals(expResult.getClass(), result.getClass());

    }

    /**
     * Test of saveInteraction method, of class InteractionManager.
     */
    @Test
    public void testSaveInteraction() {
        try {
            System.out.println("saveInteraction");
            InteractionManager instance = InteractionManager.getInstance();
            boolean expResult = true;
            Comment comment = new Comment("test comment", new Author("danny","jones","djones"));
            Task task = new Task("test task", new Author("danny","jones","djones"));
            List<Task> tasks = new ArrayList<>();
            tasks.add(task);
            
            Interaction interaction = new Interaction(comment, tasks);
            
            boolean result = instance.saveInteraction(interaction);
            
            assertEquals(expResult, result);
            
        } catch (InvalidInteractionException ex) {
            
            fail("Unexptected formatting exception: " + ex.getMessage());
        }

    }
    
    @Test
    public void testSaveInteractionRequiresComment() {
        
        String expResult = "Comment is required";
        
        try {
            System.out.println("saveInteractionRequiresComment");
            InteractionManager instance = InteractionManager.getInstance();
            
            // purposely excluding a comment to throw error
            Interaction interaction = new Interaction();
            
            boolean result = instance.saveInteraction(interaction);
            
            
        } catch (InvalidInteractionException ex) {
            
            assertEquals(expResult, ex.getMessage());
        }

    }

    /**
     * Test of createInteraction method, of class InteractionManager.
     */
    @Test
    public void testCreateInteraction() {
        try {
            System.out.println("createInteraction");
            
            Comment comment = new Comment("test comment", new Author("danny","jones","djones"));
            Task task = new Task("test task", new Author("danny","jones","djones"));
            List<Task> tasks = new ArrayList<>();
            tasks.add(task);
            
            Interaction interaction = new Interaction(comment, tasks);
            
            InteractionManager instance = InteractionManager.getInstance();
            
            long expResult = 1L;
            long result = instance.createInteraction(interaction);
            
            assertEquals(expResult, result);
            
        } catch (InvalidInteractionException ex) {
            
            fail("Unexptected formatting exception: " + ex.getMessage());
            
        }

    }
    
    @Test
    public void testCreateInteractionRequiresComment() {
        
        String expResult = "Comment is required";
        
        try {
            System.out.println("createInteractionRequiresComment");
            
            // excluding comment on purpose
            Interaction interaction = new Interaction();
            
            InteractionManager instance = InteractionManager.getInstance();
            
            long result = instance.createInteraction(interaction);
            
        } catch (InvalidInteractionException ex) {
            
            assertEquals(expResult, ex.getMessage());
            
        }

    }

    /**
     * Test of deleteInteraction method, of class InteractionManager.
     */
    @Test
    public void testDeleteInteraction() {
        System.out.println("deleteInteraction");
        
        Comment comment = new Comment("test comment", new Author("danny","jones","djones"));
        Task task = new Task("test task", new Author("danny","jones","djones"));
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        
        Interaction interaction = new Interaction(comment, tasks);        
        InteractionManager instance = InteractionManager.getInstance();
        
        long id = 1L;

        boolean expResult = true;
        
        boolean result = instance.deleteInteraction(id);
        assertEquals(expResult, result);

    }
    
}
