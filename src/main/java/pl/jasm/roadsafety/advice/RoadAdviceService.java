package pl.jasm.roadsafety.advice;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoadAdviceService {

    List<RoadAdvice> findAll();

    void add(String url);
}
