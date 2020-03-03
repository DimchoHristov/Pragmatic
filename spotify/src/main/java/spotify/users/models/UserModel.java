package spotify.users.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate birthDate;
  private boolean paid;
}
