/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package erm.model.svc.comment;

import erm.model.domain.Author;
import erm.model.domain.Comment;
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
public class CommentServiceImplTest {
    
    public CommentServiceImplTest() {
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
     * Test of getComment method, of class CommentServiceImpl.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        long id = 1L;
        CommentServiceImpl instance = new CommentServiceImpl();
        Comment expResult = new Comment("test comment", new Author("danny","jones","djones"));
        Comment result = instance.getComment(id);
        
        assertEquals(expResult.getClass(), result.getClass());

    }

    /**
     * Test of getAllComments method, of class CommentServiceImpl.
     */
    @Test
    public void testGetAllComments() {
        System.out.println("getAllComments");
        CommentServiceImpl instance = new CommentServiceImpl();
        List<Comment> expResult = new ArrayList<>();
        Comment comment = new Comment("test comment", new Author("danny","jones","djones"));
        expResult.add(comment);
        
        List<Comment> result = instance.getAllComments();
        assertEquals(expResult.getClass(), result.getClass());
    }

    /**
     * Test of saveComment method, of class CommentServiceImpl.
     */
    @Test
    public void testSaveComment() {
        System.out.println("saveComment");
        Comment comment = new Comment("test comment", new Author("danny","jones","djones"));
        CommentServiceImpl instance = new CommentServiceImpl();
        
        boolean expResult = true;
        boolean result = instance.saveComment(comment);
        assertEquals(expResult, result);

    }

    /**
     * Test of createComment method, of class CommentServiceImpl.
     */
    @Test
    public void testCreateComment() {
        System.out.println("createComment");
        Comment comment = new Comment("test comment", new Author("danny","jones","djones"));
        CommentServiceImpl instance = new CommentServiceImpl();
        
        long expResult = 1L;
        long result = instance.createComment(comment);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteComment method, of class CommentServiceImpl.
     */
    @Test
    public void testDeleteComment() {
        System.out.println("deleteComment");
        long id = 1L;
        CommentServiceImpl instance = new CommentServiceImpl();
        
        boolean expResult = true;
        boolean result = instance.deleteComment(id);
        assertEquals(expResult, result);

    }
    
}
