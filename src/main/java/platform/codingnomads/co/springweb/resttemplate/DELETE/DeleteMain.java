package platform.codingnomads.co.springweb.resttemplate.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.DELETE.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PUT.User;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.ResponseObjectUser;

@SpringBootApplication
public class DeleteMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DeleteMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            User newUser = User.builder()
                    .id(888)
                    .first_name("Jack")
                    .last_name("The Ripper")
                    //be sure to enter a valid user id
                    .email("jacktheripper@gmail.com")
                    .created_at("1682396216007")
                    .updated_at("1682396216009")
                    .build();

            //POST new task to server
            ResponseObjectUser responseObject = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/users/", newUser, ResponseObjectUser.class);

            //confirm data was returned & avoid NullPointerExceptions
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The server encountered this error while creating the user:" + responseObject.getError().getMessage());
            } else {
                newUser = responseObject.getData();
            }

            System.out.println("The user was successfully created");
            System.out.println(newUser);

            //delete the newTask using the ID the server returned
            restTemplate.delete("http://demo.codingnomads.co:8080/tasks_api/users/" + newUser.getId());
            System.out.println("The user was also successfully deleted");

            //try to GET, verify record was deleted
            try {
                restTemplate.getForEntity(
                        "http://demo.codingnomads.co:8080/tasks_api/tasks/" + newUser.getId(), ResponseObject.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }

            //delete using exchange()
            HttpEntity<User> httpEntity = new HttpEntity<>(newUser);
            try {
                restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/users/"
                        + newUser.getId(), HttpMethod.DELETE, httpEntity, ResponseObjectUser.class);
            } catch (HttpClientErrorException e) {
                System.out.println(e.getMessage());
            }
        };
    }
}
