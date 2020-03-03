package spotify.artists.service;

import spotify.artists.models.ArtistModel;

public interface ArtistService {

  void createArtist(ArtistModel model);

  void deleteArtist(int id);

  ArtistModel getArtist(int id);

  void updateArtist(ArtistModel model);
}
