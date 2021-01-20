package pl.jasm.roadsafety.forum.topicComment;

import org.springframework.stereotype.Repository;
import pl.jasm.roadsafety.forum.ForumTopic;

import java.util.List;

@Repository
public class TopicCommentServiceImpl implements TopicCommentService {

    private final TopicCommentRepository topicCommentRepository;

    public TopicCommentServiceImpl(TopicCommentRepository topicCommentRepository) {
        this.topicCommentRepository = topicCommentRepository;
    }

    @Override
    public void add(TopicComment comment) {
        topicCommentRepository.save(comment);
    }

    @Override
    public List<TopicComment> findTopicCommentsByForumTopic(ForumTopic topic) {
        return topicCommentRepository.findTopicCommentsByForumTopic(topic);
    }
}
