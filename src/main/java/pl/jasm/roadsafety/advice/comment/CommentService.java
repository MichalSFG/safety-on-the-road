package pl.jasm.roadsafety.advice.comment;

import org.springframework.stereotype.Service;
import pl.jasm.roadsafety.advice.RoadAdvice;

import java.util.List;

@Service
public interface CommentService {

    void add(Comment comment);

    List<Comment> findRoadAdviceComments(RoadAdvice roadAdvice);

    List<Comment> getOriginalRoadAdviceComments(RoadAdvice advice);

    void  delete(Comment comment);
}
