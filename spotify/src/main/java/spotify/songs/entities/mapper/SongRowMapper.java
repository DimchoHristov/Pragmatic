package spotify.songs.entities.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import spotify.songs.entities.Song;

public class SongRowMapper implements RowMapper<Song> {

  @Override
  public Song mapRow(ResultSet rs, int i) throws SQLException {
    final Song song = new Song();

    song.setId(rs.getInt("id"));
    song.setName(rs.getString("name"));
    song.setReleaseDate(rs.getDate("release_date").toLocalDate());
    song.setSecondsLength(rs.getInt("seconds_length"));
    song.setArtistId(rs.getInt("artist_id"));

    return song;
  }
}
