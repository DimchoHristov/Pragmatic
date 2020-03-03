package spotify.users.service;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spotify.users.entities.UserRepository;
import spotify.users.models.UserModel;
import spotify.users.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TestUserService {

  @Autowired
  private UserService userService;

  @Test
  public void testCRUDUser() {
    final UserModel model = new UserModel(0, "Kiril", "Ivanov", "k.i", LocalDate.now(), false);

    userService.createUser(model);

    final UserModel created = userService.getUser(1);

    assertEquals(model.getFirstName(), created.getFirstName());
    assertEquals(model.getLastName(), created.getLastName());
    assertEquals(model.getEmail(), created.getEmail());
    assertEquals(model.getBirthDate(), created.getBirthDate());
    assertEquals(model.isPaid(), created.isPaid());

    created.setLastName("Petrov");
    userService.updateUser(created);

    final UserModel updated = userService.getUser(1);
    assertEquals(created.getLastName(), updated.getLastName());

    userService.deleteUser(updated.getId());

    assertNull(userService.getUser(1));
  }

}
