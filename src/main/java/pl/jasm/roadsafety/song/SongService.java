package pl.jasm.roadsafety.song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface SongService {

    Optional<Song> findSong(Long id);

    Page<Song> findAll(Pageable pageable);

    Song add(SongDto dto);
}
