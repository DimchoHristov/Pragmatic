package spotify.songs.service;

import spotify.songs.models.SongModel;

public interface SongService {

  void createSong(SongModel model);

  void deleteSong(int id);

  SongModel getSong(int id);

  void updateSong(SongModel model);

}
