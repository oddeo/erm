package erm.business.manager;

import erm.domain.Comment;
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
public class CommentMgrBeanTest {
    
    public CommentMgrBeanTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class CommentMgrBean.
     */
    @Test
    public void testCreateComment() throws Exception {
        System.out.println("CreateComment");
        
        Comment fakeComment = new Comment("test",1,1);        
        EntityManager em = mock(EntityManager.class);
        
        CommentMgr instance = new CommentMgrBean(em);       

        Assert.assertEquals(fakeComment, instance.create(fakeComment));
        verify(em).persist(fakeComment);        

    }

    /**
     * Test of read method, of class CommentMgrBean.
     */
    @Test
    public void testReadComment() throws Exception {
        System.out.println("ReadComment");
        
        int id = 0;
        Comment fakeComment = new Comment("test",1,1);        
        EntityManager em = mock(EntityManager.class);
        when(em.find(Comment.class, id)).thenReturn(fakeComment);
        CommentMgr instance = new CommentMgrBean(em);       

        Assert.assertEquals(fakeComment, instance.read(id));        

    }

    /**
     * Test of update method, of class CommentMgrBean.
     */
    @Test
    public void testUpdateComment() throws Exception {
        System.out.println("UpdateComment");
        
        Comment fakeComment = new Comment("test",1,1);        
        EntityManager em = mock(EntityManager.class);
        when(em.merge(fakeComment)).thenReturn(fakeComment);
        CommentMgr instance = new CommentMgrBean(em);       

        Assert.assertEquals(fakeComment, instance.update(fakeComment));
  
    }

    /**
     * Test of delete method, of class CommentMgrBean.
     */
    @Test
    public void testDeleteComment() throws Exception {
        System.out.println("DeleteComment");
        
        Comment fakeComment = new Comment("test",1,1);        
        EntityManager em = mock(EntityManager.class);
        when(em.merge(fakeComment)).thenReturn(fakeComment);
        CommentMgr instance = new CommentMgrBean(em);       

        instance.delete(fakeComment);
        
        verify(em).remove(fakeComment);
    }
    
}
