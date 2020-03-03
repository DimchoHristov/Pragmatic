package spotify.users.entities.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import spotify.users.entities.User;

public class UserRowMapper implements RowMapper<User> {

  @Override
  public User mapRow(ResultSet rs, int i) throws SQLException {
    final User user = new User();

    user.setId(rs.getInt("id"));
    user.setFirstName(rs.getString("first_name"));
    user.setLastName(rs.getString("last_name"));
    user.setBirthDate(rs.getDate("birth_date").toLocalDate());
    user.setEmail(rs.getString("email"));
    user.setPaid(rs.getBoolean("paid"));

    return user;
  }
}
