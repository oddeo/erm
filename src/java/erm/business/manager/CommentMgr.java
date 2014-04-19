package erm.business.manager;

import erm.domain.Comment;
import java.util.List;

/**
 * @version 1.0
 * @author danieljones
 */
public interface CommentMgr {
    
    public Comment create (Comment comment);
    public Comment read(int id);
    public List<Comment> readAll();
    public Comment update(Comment comment);
    public void delete(Comment comment);    
    
}
