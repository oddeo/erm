package erm.business.manager;

import erm.domain.Comment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @version 1.0
 * @author danieljones
 */
@Stateless
public class CommentMgrBean implements CommentMgr {
    
    @PersistenceContext(unitName="ERMPU")
    EntityManager em;
    
    public CommentMgrBean(){}
    public CommentMgrBean(EntityManager em) {
        
        this.em = em;
        
    }

    @Override
    public Comment create(Comment comment) {
        
        em.persist(comment);

        return comment;    
        
    }

    @Override
    public Comment read(int id) {
        
        return em.find(Comment.class, id);        
        
    }

    @Override
    public List<Comment> readAll() {
        
        TypedQuery<Comment> query =
              em.createQuery("SELECT i FROM Comment i", Comment.class);
          List<Comment> results = query.getResultList();
        return results;        
        
    }

    @Override
    public Comment update(Comment comment) {
        
        return em.merge(comment);        
    }

    @Override
    public void delete(Comment comment) {
        
        em.remove(comment);        
        
    }
    
}
