package pl.jasm.roadsafety.advice.comment;

import org.springframework.stereotype.Repository;
import pl.jasm.roadsafety.advice.RoadAdvice;

import java.util.List;

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
        return commentRepository.findAllByRoadAdvice(roadAdvice);
    }
}
