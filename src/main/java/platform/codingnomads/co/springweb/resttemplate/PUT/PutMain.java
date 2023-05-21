package platform.codingnomads.co.springweb.resttemplate.PUT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.ResponseObjectUser;
import platform.codingnomads.co.springweb.resttemplate.PUT.models.Task;

@SpringBootApplication
public class PutMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PutMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            //use a valid user id
            int userId = 648;

            //request Task 5 from server
            ResponseObjectUser responseObject = restTemplate
                    .getForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + userId, ResponseObjectUser.class);


            //confirm data was retrieved & avoid NullPointerExceptions
            User userToUpdate;
            if (responseObject == null) {
                throw new Exception("The server did not return anything. Not even a ResponseObject!");
            } else if (responseObject.getData() == null) {
                throw new Exception("The user with ID " + userId + " could not be found");
            } else {
                userToUpdate = responseObject.getData();
            }

            //update the task information
            userToUpdate.setFirst_name("James");
            userToUpdate.setLast_name("Taylor");
            userToUpdate.setEmail("fireandrain@gmail.com");
            userToUpdate.setCreated_at("1683617432001");
            userToUpdate.setUpdated_at("1683617432002");

            //use put to update the resource on the server
            restTemplate.put("http://demo.codingnomads.co:8080/tasks_api/users/" + userToUpdate.getId(), userToUpdate);
            //get the task to verify update
            responseObject = restTemplate.getForObject(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userId, ResponseObjectUser.class);
            System.out.println(responseObject.toString());


            //create an HttpEntity wrapping the task to update
            HttpEntity<User> httpEntity = new HttpEntity<>(userToUpdate);
            //use exchange() to PUT the HttpEntity, and map the response to a ResponseEntity
            ResponseEntity<ResponseObjectUser> response = restTemplate.exchange(
                    "http://demo.codingnomads.co:8080/tasks_api/users/" + userToUpdate.getId(),
                    HttpMethod.PUT, httpEntity, ResponseObjectUser.class);
            System.out.println(response.toString());
        };
    }
}
