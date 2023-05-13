package platform.codingnomads.co.springdata.example.mybatis.oneandmany.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Album {

    private Long id;

    private String name;

    private String year;

    private Artist artist;

    private List<Song> songs;

    public Album(String name, String year, Artist artist, List<Song> songs) {
        this.name = name;
        this.year = year;
        this.artist = artist;
        this.songs = songs;
    }
}
