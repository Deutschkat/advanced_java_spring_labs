package platform.codingnomads.co.springweb.resttemplate.PATCH;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.ResponseObjectUser;

import java.util.Objects;

@SpringBootApplication
public class PatchMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PatchMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            //create an empty user

            User user = new User(630, "[yanzhe0513]", "[Yanzhe]", "[Li]", "1682396216000", "1682396216000");

            //be sure to use a valid task id
            user.setId(630);

            //set fields you want to change. All other fields are null and will not be updated
            user.setFirst_name("I Patched This");
            user.setLast_name("For my GitHub example");

            //send the PATCH request using the URL, the Task created above and the ResponseObject Class
            ResponseObjectUser objectResponse = restTemplate
                    .patchForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + user.getId(), user, ResponseObjectUser.class);

            System.out.println(Objects.requireNonNull(objectResponse));

            HttpEntity<User> httpEntity = new HttpEntity<>(user);
            ResponseEntity<ResponseObjectUser> response = restTemplate
                    .exchange("http://demo.codingnomads.co:8080/tasks_api/users/" + user.getId(), HttpMethod.PATCH, httpEntity, ResponseObjectUser.class);

            System.out.println(Objects.requireNonNull(response));
        };
    }
}
