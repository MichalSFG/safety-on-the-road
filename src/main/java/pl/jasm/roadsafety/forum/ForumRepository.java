package pl.jasm.roadsafety.forum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jasm.roadsafety.forum.subject.ForumSubject;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<ForumTopic, Long> {

    List<ForumTopic> findForumTopicsByForumSubject(ForumSubject forumSubject);

}
