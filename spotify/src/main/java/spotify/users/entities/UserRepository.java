package spotify.users.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spotify.users.entities.mapper.UserRowMapper;

@Repository
public class UserRepository {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public UserRepository(final NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void create(final User user) {
    final String sql = "INSERT INTO users (first_name, last_name, email, birth_date, paid) "
        + "VALUES (:first_name, :last_name, :email, :birth_date, :paid)";

    final Map<String, Object> params = new HashMap<>();
    params.put("first_name", user.getFirstName());
    params.put("last_name", user.getLastName());
    params.put("email", user.getEmail());
    params.put("birth_date", user.getBirthDate());
    params.put("paid", user.isPaid());

    jdbcTemplate.update(sql, params);
  }

  public void delete(final int id) {
    final String sql = "DELETE FROM users WHERE id = " + id;

    jdbcTemplate.update(sql, new HashMap<>());
  }

  public User get(final int id) {
    final String sql = "SELECT * FROM users WHERE id = " + id;
    try {
      return jdbcTemplate.queryForObject(sql, new HashMap<>(), new UserRowMapper());
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  public void update(final User user) {
    final String sql = "UPDATE users "
        + "SET first_name = :first_name,"
        + "last_name = :last_name,"
        + "email = :email,"
        + "birth_date = :birth_date,"
        + "paid = :paid "
        + "WHERE id = :id";

    final Map<String, Object> params = new HashMap<>();
    params.put("id", user.getId());
    params.put("first_name", user.getFirstName());
    params.put("last_name", user.getLastName());
    params.put("email", user.getEmail());
    params.put("birth_date", user.getBirthDate());
    params.put("paid", user.isPaid());

    jdbcTemplate.update(sql, params);
  }

  public List<User> findAll() {
    String sql = "SELECT * FROM users";

    return jdbcTemplate.query(sql, new UserRowMapper());
  }

}
