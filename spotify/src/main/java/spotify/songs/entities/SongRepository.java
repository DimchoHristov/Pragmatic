package spotify.songs.entities;

import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spotify.songs.entities.mapper.SongRowMapper;

@Repository
public class SongRepository {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public SongRepository(final NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void create(final Song song) {
    final String sql = "INSERT INTO songs (name, release_date, seconds_length, artist_id) "
        + "VALUES (:name, :release_date, :seconds_length, :artist_id)";

    final Map<String, Object> params = new HashMap<>();
    params.put("name", song.getName());
    params.put("release_date", song.getReleaseDate());
    params.put("seconds_length", song.getSecondsLength());
    params.put("artist_id", song.getArtistId());

    jdbcTemplate.update(sql, params);
  }

  public void delete(final int id) {
    final String sql = "DELETE FROM songs WHERE id = " + id;

    jdbcTemplate.update(sql, new HashMap<>());
  }

  public Song get(final int id) {
    final String sql = "SELECT * FROM songs WHERE id = " + id;

    try {
      return jdbcTemplate.queryForObject(sql, new HashMap<>(), new SongRowMapper());
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  public void update(final Song song) {
    final String sql = "UPDATE songs "
        + "SET name = :name,"
        + "release_date = :release_date,"
        + "seconds_length = :seconds_length,"
        + "artist_id = :artist_id "
        + "WHERE id = :id";

    final Map<String, Object> params = new HashMap<>();
    params.put("id", song.getId());
    params.put("name", song.getName());
    params.put("release_date", song.getReleaseDate());
    params.put("seconds_length", song.getSecondsLength());
    params.put("artist_id", song.getArtistId());

    jdbcTemplate.update(sql, params);
  }
}
