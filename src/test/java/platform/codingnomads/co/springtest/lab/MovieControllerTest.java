package platform.codingnomads.co.springtest.lab;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import platform.codingnomads.co.springtest.TestUtil;
import platform.codingnomads.co.springtest.lab.controller.MovieController;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = SpringTestLab.class)
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepository;

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    public void setup() {
        movieRepository.deleteAll();
    }

    @Test
    public void testGetAllMovieSuccess() throws Exception{
        Movie movie = Movie.builder().name("Sweeney Todd: The Demon Barber of Fleet Street").rating(9.5).build();
        movieRepository.save(movie);

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Sweeney Todd: The Demon Barber of Fleet Street")))
                .andExpect(jsonPath("$[0].rating", is(9.5)));
    }

    @Test
    public void testGetAllMoviesSuccessAlternative() throws Exception {
        Movie movie = Movie.builder().name("Sweeney Todd: The Demon Barber of Fleet Street").rating(9.5).build();
        movieRepository.save(movie);

        MvcResult mvcResult = mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andReturn();

        byte[] response = mvcResult.getResponse().getContentAsByteArray();
        List<Movie> actualMovies = TestUtil.convertJsonBytesToList(response, Movie.class);

        assertEquals(1, actualMovies.size());
        assertEquals("Sweeney Todd: The Demon Barber of Fleet Street", actualMovies.get(0).getName());
        assertEquals(9.5, actualMovies.get(0).getRating(), 0);
    }

    @Test
    public void testGetAllMoviesFailure() throws Exception {
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {
        Movie movie1 = Movie.builder().name("Sweeney Todd: The Demon Barber of Fleet Street").rating(9.5).build();
        Movie movie2 = Movie.builder().name("Doomstar Requiem").rating(8.0).build();
        List<Movie> movies = Arrays.asList(movie1, movie2);

        when(movieService.getAllMovies()).thenReturn(movies);

        mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Sweeney Todd: The Demon Barber of Fleet Street")))
                .andExpect(jsonPath("$[0].rating", is(9.5)))
                .andExpect(jsonPath("$[1].name", is("Doomstar Requiem")))
                .andExpect(jsonPath("$[1].rating", is(8.0)));
    }

    @Test
    public void testGetMoviesByRatingSuccess() throws Exception {
        Movie movie1 = Movie.builder().name("The Room").rating(3.7).build();
        Movie movie2 = Movie.builder().name("A Knight's Tale").rating(8.0).build();
        Movie movie3 = Movie.builder().name("Life of Brian").rating(9.0).build();
        movieRepository.saveAll(Arrays.asList(movie1, movie2, movie3));


        mockMvc.perform(get("/moviesByRating?rating=4.0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("A Knight's Tale")))
                .andExpect(jsonPath("$[0].rating", is(8.0)))
                .andExpect(jsonPath("$[1].name", is("Life of Brian")))
                .andExpect(jsonPath("$[1].rating", is(9.0)));
    }

    @Test
    public void testGetMoviesByRatingFailure() throws Exception {
        Movie movie = Movie.builder().name("The Room").rating(3.7).build();
        movieRepository.save(movie);

        mockMvc.perform(get("/moviesByRating?rating=9.0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(0)));
    }




}
