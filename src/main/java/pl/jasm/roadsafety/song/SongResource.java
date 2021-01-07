package pl.jasm.roadsafety.song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/song")
public class SongResource {

    private final SongService songService;

    public SongResource(SongService songService) {
        this.songService = songService;
    }

    @PostMapping("/add")
    public ResponseEntity<Song> addSong() {
        String api = "https://getvideo.p.rapidapi.com/?rapidapi-key=e074a51343msh7118a0a29cea5dcp1906bdjsnd2a1bd495bab&url=https://www.youtube.com/watch?v=Z3w5gVM_4y8";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SongDto> forEntity = restTemplate.getForEntity(api, SongDto.class);
        SongDto songDto = forEntity.getBody();
        Song song = songService.add(songDto);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Song> findSongById(@PathVariable Long id) {
        Optional<Song> song = songService.findSong(id);
        return song.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAllSongs(Pageable pageable) {
        Page<Song> songs = songService.findAll(pageable);
        return new ResponseEntity<>(songs.getContent(), HttpStatus.OK);
    }
}
