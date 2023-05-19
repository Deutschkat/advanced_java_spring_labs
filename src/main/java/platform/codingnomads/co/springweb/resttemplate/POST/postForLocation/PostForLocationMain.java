package platform.codingnomads.co.springweb.resttemplate.POST.postForLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;
import platform.codingnomads.co.springweb.resttemplate.POST.postForObject.ResponseObjectUser;
import platform.codingnomads.co.springweb.resttemplate.POST.postForObject.User;

import java.net.URI;
import java.util.Objects;

@SpringBootApplication
public class PostForLocationMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForLocationMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            User newUser = User.builder()
                    .id(807)
                    .email("scottishman@gmail.com")
                    .first_name("Ewan")
                    .last_name("McGregor")
                    .created_at("2023-05-11T20:59:38.974")
                    .updated_at("2023-05-11T20:59:38.974")
                    .build();


            //use postForLocation() to get the URL for the new resource
            URI returnedLocation = restTemplate
                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/users", newUser, ResponseObjectUser.class);

            System.out.println(Objects.requireNonNull(returnedLocation));

            ResponseEntity<?> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser, ResponseObjectUser.class);

            System.out.println(responseEntity.getHeaders().get("Location"));
        };
    }
}
