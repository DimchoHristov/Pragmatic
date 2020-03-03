package spotify.songs.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongModel {

  private int id;
  private String name;
  private LocalDate releaseDate;
  private int lengthInSeconds;
  private int artistId;

}
