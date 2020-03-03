package spotify.songs.service.impl;

import org.springframework.stereotype.Service;
import spotify.songs.entities.Song;
import spotify.songs.entities.SongRepository;
import spotify.songs.models.SongModel;
import spotify.songs.service.SongService;
import spotify.songs.service.converters.SongConverter;

@Service
public class SongServiceImpl implements SongService {

  private final SongRepository songRepository;
  private final SongConverter songConverter;

  public SongServiceImpl(final SongRepository songRepository, final SongConverter songConverter) {
    this.songRepository = songRepository;
    this.songConverter = songConverter;
  }

  @Override
  public void createSong(final SongModel model) {
    final Song song = songConverter.convertToEntity(model);

    songRepository.create(song);
  }

  @Override
  public void deleteSong(final int id) {
    songRepository.delete(id);
  }

  @Override
  public SongModel getSong(final int id) {
    final Song song = songRepository.get(id);

    return songConverter.convertToModel(song);
  }

  @Override
  public void updateSong(final SongModel model) {
    final Song song = songConverter.convertToEntity(model);

    songRepository.update(song);
  }
}
