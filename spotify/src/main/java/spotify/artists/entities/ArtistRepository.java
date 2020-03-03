package spotify.artists.entities;

import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spotify.artists.entities.mapper.ArtistRowMapper;

@Repository
public class ArtistRepository {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public ArtistRepository(final NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void create(final Artist artist) {
    final String sql = "INSERT INTO artists (first_name, last_name, birth_date, genre) "
        + "VALUES (:first_name, :last_name, :birth_date, :genre)";

    final Map<String, Object> params = new HashMap<>();
    params.put("first_name", artist.getFirstName());
    params.put("last_name", artist.getLastName());
    params.put("birth_date", artist.getBirthDate());
    params.put("genre", artist.getGenre());

    jdbcTemplate.update(sql, params);
  }

  public void delete(final int id) {
    final String sql = "DELETE FROM artists WHERE id = " + id;

    jdbcTemplate.update(sql, new HashMap<>());
  }

  public Artist get(final int id) {
    final String sql = "SELECT * FROM artists WHERE id = " + id;

    try {
      return jdbcTemplate.queryForObject(sql, new HashMap<>(), new ArtistRowMapper());
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  public void update(final Artist artist) {
    final String sql = "UPDATE artists "
        + "SET first_name = :first_name,"
        + "last_name = :last_name,"
        + "birth_date = :birth_date,"
        + "genre = :genre "
        + "WHERE id = :id";

    final Map<String, Object> params = new HashMap<>();
    params.put("id", artist.getId());
    params.put("first_name", artist.getFirstName());
    params.put("last_name", artist.getLastName());
    params.put("birth_date", artist.getBirthDate());
    params.put("genre", artist.getGenre());

    jdbcTemplate.update(sql, params);
  }

}
