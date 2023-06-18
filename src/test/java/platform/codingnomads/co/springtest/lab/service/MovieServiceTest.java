package platform.codingnomads.co.springtest.lab.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieServiceTest {

    @MockBean
    private MovieRepository movieRepository;
    @InjectMocks
    private MovieServiceImpl movieService;


    @Test
    public void testGetAllMovies() {
        List<Movie> expectedMovies = Arrays.asList(
                Movie.builder().name("Doomstar Requiem").rating(8.0).build(),
                Movie.builder().name("Sweeney Todd: The Demon Barber of Fleet Street").rating(9.5).build()
        );
        when(movieRepository.findAll()).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getAllMovies();

        assertEquals(expectedMovies, actualMovies);
    }

    @Test
    public void testGetMoviesByMinRating() {
        double minRating = 8.0;
        List<Movie> expectedMovies = Arrays.asList(
                Movie.builder().name("Doomstar Requiem").rating(8.0).build(),
                Movie.builder().name("Sweeney Todd: The Demon Barber of Fleet Street").rating(9.5).build()
        );
        when(movieRepository.findByRatingGreaterThanEqual(minRating)).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getMoviesWithMinRating(minRating);

        assertEquals(expectedMovies, actualMovies);
    }
}