package pl.jasm.roadsafety.forum.topicComment;

import org.springframework.stereotype.Service;
import pl.jasm.roadsafety.forum.ForumTopic;

import java.util.List;

@Service
public interface TopicCommentService {

    void add(TopicComment comment);

    List<TopicComment> findTopicCommentsByForumTopic(ForumTopic topic);
}
