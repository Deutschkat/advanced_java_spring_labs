package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Album {

    private Long id;

    private String name;

    private String artistName;

    private int yearReleased;

    public Album(String name, String artistName, int yearReleased) {
        this.name = name;
        this.artistName = artistName;
        this.yearReleased = yearReleased;
    }
}