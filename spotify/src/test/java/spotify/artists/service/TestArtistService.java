package spotify.artists.service;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestArtistService {

  @Autowired
  private ArtistService artistService;

  @Test
  public void testCRUDArtist(){
    final ArtistModel model = new ArtistModel(0, "Tupac", "Shakur", LocalDate.of(1970, 6, 15), "rap");

    artistService.createArtist(model);

    final ArtistModel created = artistService.getArtist(1);

    assertEquals(model.getFirstName(), created.getFirstName());
    assertEquals(model.getLastName(), created.getLastName());
    assertEquals(model.getGenre(), created.getGenre());
    assertEquals(model.getBirthDate(), created.getBirthDate());

    created.setBirthDate(LocalDate.now());

    artistService.updateArtist(created);

    final ArtistModel updated = artistService.getArtist(1);

    assertEquals(LocalDate.now(), updated.getBirthDate());

    artistService.deleteArtist(1);

    assertNull(artistService.getArtist(1));
  }

}
