package pl.jasm.roadsafety.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.jasm.roadsafety.song.Song;

@Service
public interface AdminService {

    Page<Song> findAllSongs(Pageable pageable);

    void add(String url);

}
