package spotify.songs.service.converters;

import org.springframework.stereotype.Component;
import spotify.songs.entities.Song;
import spotify.songs.models.SongModel;

@Component
public class SongConverter {

  public Song convertToEntity(final SongModel model) {
    if (model == null) {
      return null;
    }

    final Song song = new Song();
    song.setId(model.getId());
    song.setName(model.getName());
    song.setReleaseDate(model.getReleaseDate());
    song.setSecondsLength(model.getLengthInSeconds());
    song.setArtistId(model.getArtistId());

    return song;
  }

  public SongModel convertToModel(final Song song) {
    if (song == null) {
      return null;
    }

    final SongModel model = new SongModel();
    model.setId(song.getId());
    model.setName(song.getName());
    model.setReleaseDate(song.getReleaseDate());
    model.setLengthInSeconds(song.getSecondsLength());
    model.setArtistId(song.getArtistId());

    return model;
  }
}
