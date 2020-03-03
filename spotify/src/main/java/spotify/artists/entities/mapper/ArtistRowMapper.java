package spotify.artists.entities.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import spotify.artists.entities.Artist;

public class ArtistRowMapper implements RowMapper<Artist> {

  @Override
  public Artist mapRow(ResultSet rs, int i) throws SQLException {
    final Artist artist = new Artist();

    artist.setId(rs.getInt("id"));
    artist.setFirstName(rs.getString("first_name"));
    artist.setLastName(rs.getString("last_name"));
    artist.setBirthDate(rs.getDate("birth_date").toLocalDate());
    artist.setGenre(rs.getString("genre"));

    return artist;
  }
}
