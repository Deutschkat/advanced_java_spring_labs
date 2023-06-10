package platform.codingnomads.co.springtest.usingmockmvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//tell Spring to start completely and indicate the location of the bootstrapping class
@SpringBootTest(classes = MockMvcMain.class)
//indicate that Spring should autoconfigure the MockMvc object
@AutoConfigureMockMvc
public class TestingWebServices {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloShouldReturnDefaultMessage() throws Exception {
        mockMvc
                .perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Back")));
    }

    @Test
    public void baseURLShouldReturnGreetingViewName() throws Exception {
        mockMvc
                .perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("greeting"))
                .andExpect(model().attribute("name", "Bobbert"));
    }

    @Test
    public void notFoundShouldReturn404() throws Exception {
        mockMvc
                .perform(get("/not-found"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void profileShouldReturnCorrectViewAndModel() throws Exception {
        mockMvc
                .perform(get("/profile"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("profile"))
                .andExpect(model().attribute("name", "Ozzy"))
                .andExpect(model().attribute("age", 70));
    }

    @Test
    public void redirectShouldRedirectToHello() throws Exception {
        mockMvc
                .perform(get("/redirect"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/hello"));
    }
}
