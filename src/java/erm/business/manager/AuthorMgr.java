package erm.business.manager;

import erm.domain.Author;
import java.util.List;

/**
 * @version 1.0
 * @author danieljones
 */
public interface AuthorMgr {
    
    public Author create(Author author);
    public Author read(int id);
    public List<Author> readAll();
    public Author update(Author author);
    public void delete(Author author);
    
}
