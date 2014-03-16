package erm.service.comment;

import erm.model.domain.Comment;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @version 1.0
 * @author danieljones
 */
@WebService
@SOAPBinding(style=Style.DOCUMENT)
public interface CommentService {
    
    @WebMethod public Comment getComment(long id);
    @WebMethod public List<Comment> getAllComments();
    @WebMethod public boolean saveComment(Comment comment);
    @WebMethod public long createComment(Comment comment);
    @WebMethod public boolean deleteComment(long id);
    
}
