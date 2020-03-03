package spotify.songs.entities;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Song {

  private int id;
  private String name;
  private LocalDate releaseDate;
  private int secondsLength;
  private int artistId;

}
