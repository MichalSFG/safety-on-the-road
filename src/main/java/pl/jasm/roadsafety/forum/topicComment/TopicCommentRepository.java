package pl.jasm.roadsafety.forum.topicComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jasm.roadsafety.forum.ForumTopic;

import java.util.List;

@Repository
public interface TopicCommentRepository extends JpaRepository<TopicComment, Long> {

    List<TopicComment> findTopicCommentsByForumTopic(ForumTopic topic);

}
