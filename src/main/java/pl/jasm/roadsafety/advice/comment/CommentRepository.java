package pl.jasm.roadsafety.advice.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jasm.roadsafety.advice.RoadAdvice;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByRoadAdvice(RoadAdvice roadAdvice);

}
