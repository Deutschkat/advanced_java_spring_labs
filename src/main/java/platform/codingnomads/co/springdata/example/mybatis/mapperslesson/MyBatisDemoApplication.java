package platform.codingnomads.co.springdata.example.mybatis.mapperslesson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class MyBatisDemoApplication {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "songs_table.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper) {
        return (args) -> {
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbum_name("Bon Iver");
            song1.setArtist_name("Bon Iver");
            song1.setSong_length(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbum_name("Orca");
            song2.setArtist_name("Gus Dapperton");
            song2.setSong_length(279);

            Song song3 = new Song();
            song3.setName("Bananas and Blow");
            song3.setAlbum_name("White Pepper");
            song3.setArtist_name("Ween");
            song3.setSong_length(214);

            Song song4 = new Song();
            song4.setName("Zick Zack");
            song4.setAlbum_name("Zeit");
            song4.setArtist_name("Rammstein");
            song4.setSong_length(244);

            Song song5 = new Song();
            song5.setName("Chelsea Dagger");
            song5.setAlbum_name("The Best Of The Fratellis");
            song5.setArtist_name("The Fratellis");
            song5.setSong_length(215);

            Song song6 = new Song();
            song6.setName("Scooby Snacks");
            song6.setAlbum_name("Come Find Yourself");
            song6.setArtist_name("Fun Lovin' Criminals");
            song6.setSong_length(184);

            Song song7 = new Song();
            song7.setName("Wasted");
            song7.setAlbum_name("For Crying Out Loud");
            song7.setArtist_name("Kasabian");
            song7.setSong_length(247);

            Song song8 = new Song();
            song8.setName("Confetti");
            song8.setAlbum_name("Between Us");
            song8.setArtist_name("Little Mix");
            song8.setSong_length(185);


            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);
            songMapper.insertNewSong(song3);
            songMapper.insertNewSong(song4);
            songMapper.insertNewSong(song5);
            songMapper.insertNewSong(song6);
            songMapper.insertNewSong(song7);
            songMapper.insertNewSong(song8);


            System.out.println("This is where I started using methods that were unused: ");
            System.out.println();

            //1
            ArrayList<Song> songsByName = songMapper.getSongsByName("Confetti");
            songsByName.forEach(System.out::println);

            System.out.println();
            //2
            System.out.println(song5.toString());
            System.out.println("Time to change album:");
            songMapper.updateAlbumNameByName("Chelsea Dagger", "Costello Music");
            System.out.println(song5.toString());

            System.out.println();

            //3
            System.out.println(song2);
            songMapper.deleteSongByName("Post Humorous");
            System.out.println();

            //4
            ArrayList<Song> getSongsByAlbumAndArtist = songMapper.getSongsByAlbumAndArtist("Rammstein", "Zeit");
            getSongsByAlbumAndArtist.forEach(System.out::println);
            System.out.println();

            //5
            ArrayList<Song> getSongsByArtist = songMapper.getSongsByArtist("Kasabian");
            getSongsByArtist.forEach(System.out::println);
            System.out.println();

            //6
            songMapper.updateSong(song1);
            song1.setArtist_name("Billy Squier");
            song1.setName("Everybody Wants You");
            song1.setAlbum_name("Absolute Hits");
            song1.setSong_length(228);
            System.out.println(song1);
            System.out.println();

            //7
            songMapper.deleteSongById(song3.getId());

            System.out.println();

            //8
            songMapper.deleteSongsByAlbumAndArtist("Ween", "White Pepper");






            System.out.println();
            System.out.println("Here is where I finished and it is the old code: ");

            Song song9 = songMapper.getSongById(1L);

            ArrayList<Song> longSongs = songMapper.getSongsWithLengthGreaterThan(250);

            longSongs.forEach(System.out::println);

            System.out.println(song3.toString());
        };
    }
}
