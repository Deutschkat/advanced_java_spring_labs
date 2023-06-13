package platform.codingnomads.co.springtest.usingtestresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = UsingTestRestTemplateMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoffeePreferenceControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testPostCoffeePreference() throws Exception {

        //build new CoffeePreference to post
        CoffeePreference preferenceToPost = CoffeePreference.builder()
                .type("Black")
                .size(CoffeePreference.Size.LARGE)
                .sugar(false)
                .iced(true)
                .intensity(9)
                .build();

        //send POST request using TestRestTemplate
        ResponseEntity<CoffeePreference> postedCoffeePreference =
                testRestTemplate.postForEntity("/coffee", preferenceToPost, CoffeePreference.class);

        //confirm Location header is correct
        String locationHeader = Objects.requireNonNull(postedCoffeePreference.getHeaders().getLocation()).toString();
        assertThat(locationHeader).isEqualTo("http://www.url.com/new/location");

        //confirm ID was assigned
        assertThat(Objects.requireNonNull(postedCoffeePreference.getBody()).getId()).isNotNull();
    }
    @Test
    public void testGetCoffeePreference() throws Exception {
        // Create a CoffeePreference to retrieve
        CoffeePreference coffeePreference = CoffeePreference.builder()
                .type("Espresso")
                .size(CoffeePreference.Size.SMALL)
                .sugar(true)
                .iced(false)
                .intensity(8)
                .build();

        // Insert the CoffeePreference
        CoffeePreference insertedPreference = testRestTemplate.postForObject("/coffee", coffeePreference, CoffeePreference.class);

        // Send GET request to retrieve the CoffeePreference
        ResponseEntity<CoffeePreference> response = testRestTemplate.getForEntity("/coffee/{id}", CoffeePreference.class, insertedPreference.getId());

        // Assert that the response is successful
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Verify attribute values
        CoffeePreference retrievedPreference = response.getBody();
        assertThat(retrievedPreference).isNotNull();
        assertThat(retrievedPreference.getType()).isEqualTo(insertedPreference.getType());
        assertThat(retrievedPreference.isSugar()).isEqualTo(insertedPreference.isSugar());
        assertThat(retrievedPreference.isIced()).isEqualTo(insertedPreference.isIced());
        assertThat(retrievedPreference.getSize()).isEqualTo(insertedPreference.getSize());
        assertThat(retrievedPreference.getIntensity()).isEqualTo(insertedPreference.getIntensity());
    }
}
