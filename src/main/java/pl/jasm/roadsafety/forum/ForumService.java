package pl.jasm.roadsafety.forum;

import org.springframework.stereotype.Service;
import pl.jasm.roadsafety.forum.subject.ForumSubject;

import java.util.List;

@Service
public interface ForumService {

    List<ForumTopic> findAll();

    List<ForumTopic> findAllByForumSubject(ForumSubject forumSubject);

    void add(ForumTopic forumTopic);
}
