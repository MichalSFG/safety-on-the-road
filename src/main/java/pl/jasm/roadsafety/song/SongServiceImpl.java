package pl.jasm.roadsafety.song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Optional<Song> findSong(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return songRepository.findAll(pageable);
    }

    @Override
    public Song add(SongDto dto) {
        Song song = new Song();
        song.setTitle(dto.getSongTitle());
        song.setUploader(dto.getSongUploader());
        song.setUrl(dto.getUrlAddress());
        song.setViewsNumber(dto.getViews());
        song.prePersist();
        songRepository.save(song);
        return song;
    }
}
