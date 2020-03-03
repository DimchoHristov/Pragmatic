package spotify.artists.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistModel {

  private int id;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private String genre;
}
