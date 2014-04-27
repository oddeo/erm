package erm.service.endpoint;

import erm.business.manager.AuthorMgr;
import erm.business.manager.AuthorMgrBean;
import erm.domain.Author;
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
public class AuthorResourceTest {
    
    public AuthorResourceTest() {
    }
    
    @Before
    public void setUp() {       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAuthorsJson method, of class AuthorResource.
     */
    @Test
    public void testGetAuthorsJsonReturnsAuthorsList() {
        System.out.println("GetAuthorsJsonReturnsAuthorsList");
        
        List<Author> fakeList = new ArrayList<>();
        AuthorMgr manager = mock(AuthorMgrBean.class);
        when(manager.readAll()).thenReturn(fakeList);
        
        AuthorResource instance = new AuthorResource(manager);

        assertEquals(fakeList, instance.getAuthorsJson());

    }

    /**
     * Test of getAuthorsXml method, of class AuthorResource.
     */
    @Test
    public void testGetAuthorsXmlReturnsAuthorsList() {
        System.out.println("GetAuthorsXmlReturnsAuthorsList");

        List<Author> fakeList = new ArrayList<>();
        AuthorMgr manager = mock(AuthorMgrBean.class);
        when(manager.readAll()).thenReturn(fakeList);
        
        AuthorResource instance = new AuthorResource(manager);

        assertEquals(fakeList, instance.getAuthorsXml());
        
    }

    /**
     * Test of getAuthor method, of class AuthorResource.
     */
    @Test
    public void testGetAuthorReturnsOkResponseStatus() {
        System.out.println("GetAuthorReturnsOkResponseStatus");
        
        int id = 0;
        String format = "xml";
        AuthorMgr manager = mock(AuthorMgrBean.class);
        ResponseBuilder response = Response.ok(manager.read(id)).type(MediaType.APPLICATION_XML);

        AuthorResource instance = new AuthorResource(manager);

        assertEquals(response.build().getStatus(), instance.getAuthor(id, format).getStatus());

    }
    
    /**
     * Test of getAuthor method, of class AuthorResource.
     */
    @Test
    public void testGetAuthorThrowsWebApplicationException() {
        System.out.println("GetAuthorThrowsWebApplicationException");
        
        int id = 0;
        String format = "";
        AuthorMgr manager = mock(AuthorMgrBean.class);
        ResponseBuilder response = Response.ok(manager.read(id)).type(MediaType.APPLICATION_XML);
        AuthorResource instance = new AuthorResource(manager);
        
        try {
            
            instance.getAuthor(id, format);
            
        } catch(WebApplicationException ex) {
            
            assertEquals(WebApplicationException.class, ex.getClass());
            
        }

    }

    /**
     * Test of create method, of class AuthorResource.
     */
    @Test
    public void testCreateAuthor() {
        System.out.println("CreateAuthor");
        
        Author fakeAuthor = new Author("first","last");
        AuthorMgr manager = mock(AuthorMgrBean.class);
        ResponseBuilder response = Response.ok(manager.create(fakeAuthor))
                .type(MediaType.APPLICATION_XML);
        
        AuthorResource instance = new AuthorResource(manager);

        assertEquals(response.build().getStatus(), instance.create(fakeAuthor).getStatus());

    }
    
    /**
     * Test of create method, of class AuthorResource.
     */
    @Test
    public void testCreateInvalidAuthorReturnsBadRequestResponse() {
        System.out.println("CreateInvalidAuthorReturnsBadRequestResponse");
        
        Author fakeAuthor = new Author();
        AuthorMgr manager = mock(AuthorMgrBean.class);
        ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST).
                                    type(MediaType.TEXT_PLAIN);
        
        AuthorResource instance = new AuthorResource(manager);

        assertEquals(response.build().getStatus(), instance.create(fakeAuthor).getStatus());

    }

    /**
     * Test of update method, of class AuthorResource.
     */
    @Test
    public void testUpdateAuthor() {
        System.out.println("UpdateAuthor");
        
        Author fakeAuthor = new Author("first","last");
        AuthorMgr manager = mock(AuthorMgrBean.class);
        ResponseBuilder response = Response.ok(manager.create(fakeAuthor))
                .type(MediaType.APPLICATION_XML);
        
        AuthorResource instance = new AuthorResource(manager);

        assertEquals(response.build().getStatus(), instance.update(fakeAuthor).getStatus());        
        
    }
    
    /**
     * Test of update method, of class AuthorResource.
     */    
    @Test
    public void testUpdateInvalidAuthorReturnsBadRequestResponse() {
        System.out.println("UpdateInvalidAuthorReturnsBadRequestResponse");
        
        Author fakeAuthor = new Author();
        AuthorMgr manager = mock(AuthorMgrBean.class);
        ResponseBuilder response = Response.status(Response.Status.BAD_REQUEST).
                                    type(MediaType.TEXT_PLAIN);
        
        AuthorResource instance = new AuthorResource(manager);

        assertEquals(response.build().getStatus(), instance.update(fakeAuthor).getStatus());

    }

    /**
     * Test of delete method, of class AuthorResource.
     */
    @Test
    public void testDeleteAuthor() {
        System.out.println("DeleteAuthor");
        
        int id = 0;
        Author fakeAuthor = new Author("first","last");
        AuthorMgr manager = mock(AuthorMgrBean.class);
        when(manager.read(id)).thenReturn(fakeAuthor);

        AuthorResource instance = new AuthorResource(manager);
        
        instance.delete(id);

        verify(manager).delete(fakeAuthor);
    }
    
}
