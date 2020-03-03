package spotify.artists.service.impl;

import java.util.Optional;
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

  public ArtistModel createArtist(final ArtistModel model) {
    final Artist artist = artistConverter.convertToEntity(model);

    final Artist created = artistRepository.save(artist);

    return artistConverter.convertToModel(created);
  }

  public void deleteArtist(final String id) {
    final Optional<Artist> artistOpt = artistRepository.findById(id);

    if (!artistOpt.isPresent()) {
      return;
    }

    artistRepository.delete(artistOpt.get());
  }

  public ArtistModel getArtist(final String id) {
    final Optional<Artist> artistOpt = artistRepository.findById(id);

    return artistOpt.map(artistConverter::convertToModel).orElse(null);
  }

  public ArtistModel updateArtist(final ArtistModel model) {
    final Artist artist = artistConverter.convertToEntity(model);

    final Artist updated = artistRepository.save(artist);

    return artistConverter.convertToModel(updated);
  }
}
