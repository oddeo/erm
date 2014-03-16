package erm.model.svc.comment;

import erm.model.domain.Comment;
import erm.model.svc.IService;
import java.util.List;

/**
 * @version 1.0
 * @author danieljones
 */
public interface ICommentService extends IService {
    
	/** NAME constant is looked up during call to getService from ServiceFactory */	
	public final String NAME = "ICommentService";
    
    public Comment getComment(long id);
    public List<Comment> getAllComments();
    public boolean saveComment(Comment comment);
    public long createComment(Comment comment);
    public boolean deleteComment(long id);
    
}
