package platform.codingnomads.co.springweb.resttemplate.POST.postForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;

@SpringBootApplication
public class PostForObjectMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForObjectMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

        User newUser = User.builder()
                .id(707)
                .email("imustbreakyou@gmail.com")
                .first_name("Dolph")
                .last_name("Lundgren")
                .created_at("2023-05-18T20:57:38.329Z")
                .updated_at("2023-05-18T20:57:38.329Z")
                .build();

        ResponseObjectUser userReturnedByServerAfterPost = restTemplate
                .postForObject("http://demo.codingnomads.co:8080/tasks_api/users", newUser, ResponseObjectUser.class);

        if (userReturnedByServerAfterPost != null) {
            System.out.println(userReturnedByServerAfterPost.toString());
        }
    };

    }
}

