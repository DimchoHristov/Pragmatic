package spotify.artists.service.impl;

import org.springframework.stereotype.Service;
import spotify.artists.entities.Artist;
import spotify.artists.entities.ArtistRepository;
import spotify.artists.models.ArtistModel;
import spotify.artists.service.ArtistService;
import spotify.artists.service.converters.ArtistConverter;

@Service
public class ArtistServiceImpl implements ArtistService {

  private final ArtistRepository artistRepository;
  private final ArtistConverter artistConverter;

  public ArtistServiceImpl(final ArtistRepository artistRepository,
      final ArtistConverter artistConverter) {
    this.artistRepository = artistRepository;
    this.artistConverter = artistConverter;
  }

  public void createArtist(final ArtistModel model) {
    final Artist artist = artistConverter.convertToEntity(model);

    artistRepository.create(artist);
  }

  public void deleteArtist(final int id) {
    artistRepository.delete(id);
  }

  public ArtistModel getArtist(final int id) {
    final Artist artist = artistRepository.get(id);

    return artistConverter.convertToModel(artist);
  }

  public void updateArtist(final ArtistModel model) {
    final Artist artist = artistConverter.convertToEntity(model);

    artistRepository.update(artist);
  }
}
