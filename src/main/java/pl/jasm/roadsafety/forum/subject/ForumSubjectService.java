package pl.jasm.roadsafety.forum.subject;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ForumSubjectService {

    void add(ForumSubject subject);

    List<ForumSubject> findAll();

    Optional<ForumSubject> findById(Long id);
}
