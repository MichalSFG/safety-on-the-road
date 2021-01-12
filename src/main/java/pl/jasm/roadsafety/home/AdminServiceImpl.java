package pl.jasm.roadsafety.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.jasm.roadsafety.song.Song;
import pl.jasm.roadsafety.song.SongDto;
import pl.jasm.roadsafety.song.SongRepository;

@Repository
public class AdminServiceImpl implements AdminService {

    private final SongRepository songRepository;

    public AdminServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Page<Song> findAllSongs(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public void add(String url) {
        String api = "https://getvideo.p.rapidapi.com/?rapidapi-key=e074a51343msh7118a0a29cea5dcp1906bdjsnd2a1bd495bab&url=" + url;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SongDto> forEntity = restTemplate.getForEntity(api, SongDto.class);
        SongDto dto = forEntity.getBody();

        Song song = new Song();
        assert dto != null;
        song.setTitle(dto.getSongTitle());
        song.setUploader(dto.getSongUploader());
        song.setUrl(dto.getUrlAddress());
        song.setViewsNumber(dto.getViews());
        song.prePersist();
        songRepository.save(song);
    }

}
