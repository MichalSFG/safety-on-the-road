package pl.jasm.roadsafety.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import pl.jasm.roadsafety.song.Song;
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
}
