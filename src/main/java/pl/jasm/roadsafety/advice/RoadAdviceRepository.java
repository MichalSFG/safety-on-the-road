package pl.jasm.roadsafety.advice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadAdviceRepository extends JpaRepository<RoadAdvice, Long> {

}
