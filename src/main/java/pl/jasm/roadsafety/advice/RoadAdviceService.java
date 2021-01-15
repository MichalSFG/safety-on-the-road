package pl.jasm.roadsafety.advice;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoadAdviceService {

    List<RoadAdvice> findAll();

    Optional<RoadAdvice> findRoadAdviceById(Long id);

    void add(String url);

    void update(RoadAdvice advice);

    void delete(RoadAdvice advice);
}
