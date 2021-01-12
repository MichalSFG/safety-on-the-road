package pl.jasm.roadsafety.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class RoadAdviceServiceImpl implements RoadAdviceService {

    private final RoadAdviceRepository roadAdviceRepository;

    public RoadAdviceServiceImpl(RoadAdviceRepository roadAdviceRepository) {
        this.roadAdviceRepository = roadAdviceRepository;
    }

    @Override
    public List<RoadAdvice> findAll() {
        return roadAdviceRepository.findAll();
    }

    @Override
    public void add(String url) {
        String api = "https://getvideo.p.rapidapi.com/?rapidapi-key=e074a51343msh7118a0a29cea5dcp1906bdjsnd2a1bd495bab&url=" + url;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RoadAdviceDto> forEntity = restTemplate.getForEntity(api, RoadAdviceDto.class);
        RoadAdviceDto dto = forEntity.getBody();

        RoadAdvice advice = new RoadAdvice();
        assert dto != null;
        advice.setTitle(dto.getAdviceName());
        advice.setUploader(dto.getAdviceUploader());
        advice.setUrl(dto.getAdviceUrl());
        advice.setDescription(dto.getAdviceDesc());
        advice.setUploadDate(dto.getAdviceUploadDate());
        advice.prePersist();
        try {
            roadAdviceRepository.save(advice);
        } catch (DataIntegrityViolationException e) {
            advice.setDescription("too long or no description");
            roadAdviceRepository.save(advice);
        }
    }
}
