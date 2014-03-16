package erm.service.comment;

import erm.model.domain.Comment;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

/**
 * @version 1.0
 * @author danieljones
 */
@WebService(endpointInterface="erm.service.comment.CommentService")
public class CommentServiceImpl implements CommentService {

    @Override
    public Comment getComment(long id) {

        return new Comment("get comment", "danny jones");
        
    }

    @Override
    public List<Comment> getAllComments() {
        
        Comment c1 = new Comment("comment1", "danny");
        Comment c2 = new Comment("comment2", "jones");
        List<Comment> cList = new ArrayList<>();
        cList.add(c1);
        cList.add(c2);
        
        return cList;
        
    }

    @Override
    public boolean saveComment(Comment comment) {

        return true;
        
    }

    @Override
    public long createComment(Comment comment) {
        
        return 1L;
        
    }

    @Override
    public boolean deleteComment(long id) {
        
        return true;
        
    } 
    
}
