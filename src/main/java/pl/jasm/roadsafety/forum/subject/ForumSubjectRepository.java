package pl.jasm.roadsafety.forum.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumSubjectRepository extends JpaRepository<ForumSubject, Long> {
}
