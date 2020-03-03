package spotify.songs.entities;

import static spotify.constants.Constants.UUID_SIZE;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import spotify.artists.entities.Artist;

@Data
@Entity
@Table(name = "songs")
public class Song {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "id", length = UUID_SIZE)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "release_date", nullable = false)
  private LocalDate releaseDate;

  @Column(name = "seconds_length")
  private int secondsLength;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "artist_id", nullable = false,
      foreignKey = @ForeignKey(name = "fk_songs_artists"))
  private Artist artist;

}
