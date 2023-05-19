package platform.codingnomads.co.springweb.resttemplate.GET.getForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import platform.codingnomads.co.springweb.resttemplate.GET.models.QuoteTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GetForEntityDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForEntityDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            Map<String, String> params = new HashMap<>();
            params.put("type", "recreational");
            params.put("participants", "1");

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://www.boredapi.com/api/activity");

            params.forEach(builder :: queryParam);

            URI uri = builder.build().encode().toUri();

            ResponseEntity<BoredTemplate> getEntity = restTemplate.getForEntity(uri, BoredTemplate.class);

            if (getEntity.getStatusCode().is2xxSuccessful() && getEntity.getBody() != null) {
                BoredTemplate bored = getEntity.getBody();
                System.out.println(bored);
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            ResponseEntity<QuoteTemplate[]> responseEntity =
                    restTemplate.getForEntity("https://zenquotes.io/api/random", QuoteTemplate[].class);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                QuoteTemplate[] quoteTemplate = responseEntity.getBody();
                System.out.println(Arrays.toString(quoteTemplate));
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }
        };
    }
}
