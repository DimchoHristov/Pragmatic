package spotify.songs.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spotify.artists.models.ArtistModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongModel {

  private String id;
  private String name;
  private LocalDate releaseDate;
  private int lengthInSeconds;
  private String artistId;

}
