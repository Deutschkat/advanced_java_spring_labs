package platform.codingnomads.co.springtest.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringTestLab implements CommandLineRunner {

    @Autowired
    MovieRepository movieRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringTestLab.class);
    }

    @Override
    public void run(String... args) {
        if (movieRepository.findAll().isEmpty()) {
            movieRepository.saveAll(Arrays.asList(
                    Movie.builder().name("Sweeney Todd: The Demon Barber of Fleet Street").rating(9.5).build(),
                    Movie.builder().name("Doomstar Requiem").rating(8.0).build()
            ));
        }
    }
}
