package erm.business.manager;

import erm.domain.Author;
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
public class AuthorMgrBean implements AuthorMgr {
    
    @PersistenceContext(unitName="ERMPU")
    EntityManager em;
    
    
    public AuthorMgrBean(){}
    public AuthorMgrBean(EntityManager em) {
        
        this.em = em;
        
    }

    @Override
    public Author create(Author author) {
        
        em.persist(author);
        
        return author;
        
    }

    @Override
    public Author read(int id) {
        
        return em.find(Author.class, id);
        
    }

    @Override
    public List<Author> readAll() {
        
        TypedQuery<Author> query =
              em.createQuery("SELECT a FROM Author a", Author.class);
          List<Author> results = query.getResultList();
        return results;         
        
    }

    @Override
    public Author update(Author author) {
        
        return em.merge(author);
        
    }

    @Override
    public void delete(Author author) {
        
        em.remove(author);
        
    }
    
}
