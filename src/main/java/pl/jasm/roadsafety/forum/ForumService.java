package pl.jasm.roadsafety.forum;

import org.springframework.stereotype.Service;
import pl.jasm.roadsafety.forum.subject.ForumSubject;

import java.util.List;
import java.util.Optional;

@Service
public interface ForumService {

    List<ForumTopic> findAll();

    List<ForumTopic> findAllByForumSubject(ForumSubject forumSubject);

    Optional<ForumTopic> findTopicById(Long id);

    void add(ForumTopic forumTopic);

    void update(ForumTopic forumTopic);
}
