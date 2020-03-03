package spotify.users.entities;

import java.time.LocalDate;
import lombok.Data;

@Data
public class User {

  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private LocalDate birthDate;
  private boolean paid;
}
