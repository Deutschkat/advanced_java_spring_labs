package platform.codingnomads.co.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper, AlbumMapper albumMapper) {
        return (args) -> {
            //notice the setter names have changed to match Java naming conventions
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtistName("Bon Iver");
            song1.setSongLength(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtistName("Gus Dapperton");
            song2.setSongLength(279);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);


            Song song3 = songMapper.getSongById(1L);
            System.out.println(song3.toString());

            System.out.println("My stuff is here: ");
            System.out.println();

            Album album1 = new Album("Zeit", "Rammstein", 2021);
            Album album2 = new Album("Costello Music", "The Fratellis", 2006);

            albumMapper.insertNewAlbum(album1);
            albumMapper.insertNewAlbum(album2);


            //1
            ArrayList<Album> getAlbumsByName = albumMapper.getAlbumsByName("Zeit");
            getAlbumsByName.forEach(System.out::println);

            System.out.println();

            //2

            ArrayList<Album> getAlbumByArtist = albumMapper.getAlbumsByArtist("The Fratellis");
            getAlbumByArtist.forEach(System.out::println);

            System.out.println();


            //3
            albumMapper.deleteAlbumById(album2.getId());

            //4
            ArrayList<Album> updateAlbum = albumMapper.updateAlbum(album2);
            updateAlbum.forEach(System.out::println);




        };
    }
}
