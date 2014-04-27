package erm.service.endpoint;

import erm.business.manager.CommentMgr;
import erm.business.manager.CommentMgrBean;
import erm.domain.Comment;
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
public class CommentResourceTest {
    
    public CommentResourceTest() {
    }
    
    @Before
    public void setUp() {       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCommentsJson method, of class CommentResource.
     */
    @Test
    public void testGetCommentsJsonReturnsCommentsList() {
        System.out.println("GetCommentsJsonReturnsCommentsList");
        
        List<Comment> fakeList = new ArrayList<>();
        CommentMgr manager = mock(CommentMgrBean.class);
        when(manager.readAll()).thenReturn(fakeList);
        
        CommentResource instance = new CommentResource(manager);

        assertEquals(fakeList, instance.getCommentsJson());

    }

    /**
     * Test of getCommentsXml method, of class CommentResource.
     */
    @Test
    public void testGetCommentsXmlReturnsCommentsList() {
        System.out.println("GetCommentsXmlReturnsCommentsList");

        List<Comment> fakeList = new ArrayList<>();
        CommentMgr manager = mock(CommentMgrBean.class);
        when(manager.readAll()).thenReturn(fakeList);
        
        CommentResource instance = new CommentResource(manager);

        assertEquals(fakeList, instance.getCommentsXml());
        
    }

    /**
     * Test of getComment method, of class CommentResource.
     */
    @Test
    public void testGetCommentReturnsOkResponseStatus() {
        System.out.println("GetCommentReturnsOkResponseStatus");
        
        int id = 0;
        String format = "xml";
        CommentMgr manager = mock(CommentMgrBean.class);
        ResponseBuilder response = Response.ok(manager.read(id)).type(MediaType.APPLICATION_XML);

        CommentResource instance = new CommentResource(manager);

        assertEquals(response.build().getStatus(), instance.getComment(id, format).getStatus());

    }
    
    /**
     * Test of getComment method, of class CommentResource.
     */
    @Test
    public void testGetCommentThrowsWebApplicationException() {
        System.out.println("GetCommentThrowsWebApplicationException");
        
        int id = 0;
        String format = "";
        CommentMgr manager = mock(CommentMgrBean.class);
        ResponseBuilder response = Response.ok(manager.read(id)).type(MediaType.APPLICATION_XML);
        CommentResource instance = new CommentResource(manager);
        
        try {
            
            instance.getComment(id, format);
            
        } catch(WebApplicationException ex) {
            
            assertEquals(WebApplicationException.class, ex.getClass());
            
        }

    }

    /**
     * Test of create method, of class CommentResource.
     */
    @Test
    public void testCreateComment() {
        System.out.println("CreateComment");
        
        Comment fakeComment = new Comment("test",1,1);
        CommentMgr manager = mock(CommentMgrBean.class);
        ResponseBuilder response = Response.ok(manager.create(fakeComment))
                .type(MediaType.APPLICATION_XML);
        
        CommentResource instance = new CommentResource(manager);

        assertEquals(response.build().getStatus(), instance.create(fakeComment).getStatus());

    }
    
    /**
     * Test of create method, of class CommentResource.
     */
    @Test
    public void testCreateInvalidCommentReturnsBadRequestResponse() {
        System.out.println("CreateInvalidCommentReturnsBadRequestResponse");
        
        Comment fakeComment = new Comment();
        CommentMgr manager = mock(CommentMgrBean.class);
        ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST).
                                    type(MediaType.TEXT_PLAIN);
        
        CommentResource instance = new CommentResource(manager);

        assertEquals(response.build().getStatus(), instance.create(fakeComment).getStatus());

    }

    /**
     * Test of update method, of class CommentResource.
     */
    @Test
    public void testUpdateComment() {
        System.out.println("UpdateComment");
        
        Comment fakeComment = new Comment("test",1,1);
        CommentMgr manager = mock(CommentMgrBean.class);
        ResponseBuilder response = Response.ok(manager.create(fakeComment))
                .type(MediaType.APPLICATION_XML);
        
        CommentResource instance = new CommentResource(manager);

        assertEquals(response.build().getStatus(), instance.update(fakeComment).getStatus());        
        
    }
    
    /**
     * Test of update method, of class CommentResource.
     */    
    @Test
    public void testUpdateInvalidCommentReturnsBadRequestResponse() {
        System.out.println("UpdateInvalidCommentReturnsBadRequestResponse");
        
        Comment fakeComment = new Comment();
        CommentMgr manager = mock(CommentMgrBean.class);
        ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST).
                                    type(MediaType.TEXT_PLAIN);
        
        CommentResource instance = new CommentResource(manager);

        assertEquals(response.build().getStatus(), instance.update(fakeComment).getStatus());

    }

    /**
     * Test of delete method, of class CommentResource.
     */
    @Test
    public void testDeleteComment() {
        System.out.println("DeleteComment");
        
        int id = 0;
        Comment fakeComment = new Comment("test",1,1);
        CommentMgr manager = mock(CommentMgrBean.class);
        when(manager.read(id)).thenReturn(fakeComment);

        CommentResource instance = new CommentResource(manager);
        
        instance.delete(id);

        verify(manager).delete(fakeComment);
    }
    
}
