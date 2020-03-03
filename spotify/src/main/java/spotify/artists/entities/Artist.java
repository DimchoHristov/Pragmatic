package spotify.artists.entities;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Artist {

  private int id;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private String genre;
}
