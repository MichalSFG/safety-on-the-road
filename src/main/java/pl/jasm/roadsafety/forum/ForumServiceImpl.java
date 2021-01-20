package pl.jasm.roadsafety.forum;

import org.springframework.stereotype.Repository;
import pl.jasm.roadsafety.forum.subject.ForumSubject;

import java.util.List;
import java.util.Optional;

@Repository
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;

    public ForumServiceImpl(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    @Override
    public List<ForumTopic> findAll() {
        return forumRepository.findAll();
    }

    @Override
    public List<ForumTopic> findAllByForumSubject(ForumSubject subject) {
        return forumRepository.findForumTopicsByForumSubject(subject);
    }

    @Override
    public Optional<ForumTopic> findTopicById(Long id) {
        return forumRepository.findById(id);
    }

    @Override
    public void add(ForumTopic forumTopic) {
        forumRepository.save(forumTopic);
    }

    @Override
    public void update(ForumTopic forumTopic) {
        forumRepository.save(forumTopic);
    }
}
