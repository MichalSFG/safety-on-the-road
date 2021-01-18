package pl.jasm.roadsafety.forum.subject;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ForumSubjectServiceImpl implements ForumSubjectService {

    private final ForumSubjectRepository forumSubjectRepository;

    public ForumSubjectServiceImpl(ForumSubjectRepository forumSubjectRepository) {
        this.forumSubjectRepository = forumSubjectRepository;
    }

    @Override
    public void add(ForumSubject subject) {
        forumSubjectRepository.save(subject);
    }

    @Override
    public List<ForumSubject> findAll() {
        return forumSubjectRepository.findAll();
    }

    @Override
    public Optional<ForumSubject> findById(Long id) {
        return forumSubjectRepository.findById(id);
    }
}
