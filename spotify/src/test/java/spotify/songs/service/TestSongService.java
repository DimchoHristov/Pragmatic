package spotify.songs.service;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spotify.artists.models.ArtistModel;
import spotify.artists.service.ArtistService;
import spotify.songs.models.SongModel;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestSongService {

  @Autowired
  private SongService songService;

  @Autowired
  private ArtistService artistService;

  @Test
  public void testCRUDSong() {
    final ArtistModel artistModel = new ArtistModel(0, "Tupac", "Shakur", LocalDate.of(1970, 6, 15),
        "rap");

    artistService.createArtist(artistModel);

    final SongModel model = new SongModel(0, "Gangsta Party", LocalDate.of(1993, 5, 5), 240, 1);

    songService.createSong(model);

    final SongModel created = songService.getSong(1);

    assertEquals(model.getName(), created.getName());
    assertEquals(model.getArtistId(), created.getArtistId());
    assertEquals(model.getLengthInSeconds(), created.getLengthInSeconds());
    assertEquals(model.getReleaseDate(), created.getReleaseDate());

    created.setName("Dear mama");

    songService.updateSong(created);

    final SongModel updated = songService.getSong(1);

    assertEquals(created.getName(), updated.getName());

    songService.deleteSong(1);

    assertNull(songService.getSong(1));
  }
}
