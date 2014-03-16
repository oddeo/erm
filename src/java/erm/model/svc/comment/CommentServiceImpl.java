package erm.model.svc.comment;

import erm.model.domain.Author;
import erm.model.domain.Comment;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author danieljones
 */
public class CommentServiceImpl implements ICommentService {

    @Override
    public Comment getComment(long id) {

        return new Comment("I am a comment", new Author("danny","jones","djones"));
        
    }

    @Override
    public List<Comment> getAllComments() {
        
        Comment c1 = new Comment("comment1", new Author("danny","jones","djones"));
        Comment c2 = new Comment("comment2", new Author("danny","jones","djones"));
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
