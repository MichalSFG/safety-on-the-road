package pl.jasm.roadsafety.advice.comment;

import org.springframework.stereotype.Repository;
import pl.jasm.roadsafety.advice.RoadAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findRoadAdviceComments(RoadAdvice roadAdvice) {
        List<Comment> comments = commentRepository.findAllByRoadAdvice(roadAdvice);
        return comments.stream().peek(comment -> {
            String c = comment.getCreated();
            comment.setCreated(c.substring(8, 10) + "/" + c.substring(5, 7) + "/" + c.substring(0, 4) + " " + c.substring(11, 16));
        }).collect(Collectors.toList());
    }

    @Override
    public List<Comment> getOriginalRoadAdviceComments(RoadAdvice advice) {
        return commentRepository.findAllByRoadAdvice(advice);
    }

    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }
}
