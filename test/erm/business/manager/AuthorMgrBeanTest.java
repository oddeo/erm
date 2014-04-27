package erm.business.manager;

import erm.domain.Author;
import javax.persistence.EntityManager;
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
public class AuthorMgrBeanTest {
    
    public AuthorMgrBeanTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class EmployeeMgrBean.
     */
    @Test
    public void testCreateAuthor() throws Exception {
        System.out.println("CreateAuthor");
        
        Author fakeAuthor = new Author("first","last");        
        EntityManager em = mock(EntityManager.class);
        
        AuthorMgr instance = new AuthorMgrBean(em);       

        Assert.assertEquals(fakeAuthor, instance.create(fakeAuthor));
        verify(em).persist(fakeAuthor);        

    }

    /**
     * Test of read method, of class AuthorMgrBean.
     */
    @Test
    public void testReadAuthor() throws Exception {
        System.out.println("ReadAuthor");
        
        int id = 0;
        Author fakeAuthor = new Author("first","last");        
        EntityManager em = mock(EntityManager.class);
        when(em.find(Author.class, id)).thenReturn(fakeAuthor);
        AuthorMgr instance = new AuthorMgrBean(em);       

        Assert.assertEquals(fakeAuthor, instance.read(id));        

    }

    /**
     * Test of update method, of class AuthorMgrBean.
     */
    @Test
    public void testUpdateAuthor() throws Exception {
        System.out.println("UpdateAuthor");
        
        Author fakeAuthor = new Author("first","last");        
        EntityManager em = mock(EntityManager.class);
        when(em.merge(fakeAuthor)).thenReturn(fakeAuthor);
        AuthorMgr instance = new AuthorMgrBean(em);       

        Assert.assertEquals(fakeAuthor, instance.update(fakeAuthor));
  
    }

    /**
     * Test of delete method, of class AuthorMgrBean.
     */
    @Test
    public void testDeleteAuthor() throws Exception {
        System.out.println("DeleteAuthor");
        
        Author fakeAuthor = new Author("first","last");        
        EntityManager em = mock(EntityManager.class);
        when(em.merge(fakeAuthor)).thenReturn(fakeAuthor);
        AuthorMgr instance = new AuthorMgrBean(em);       

        instance.delete(fakeAuthor);
        
        verify(em).remove(fakeAuthor);
    }
    
}
