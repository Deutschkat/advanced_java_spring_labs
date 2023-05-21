package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }


    @RequestMapping(path = "/deutsch_tasks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getTasks() {
        List<String> deutschTasks = new ArrayList<>();
        deutschTasks.add("den Rasen maehen");
        deutschTasks.add("das Badezimmer putzen");
        deutschTasks.add("im Garten arbeiten");
        deutschTasks.add("das Abendessen machen");
        return deutschTasks;

    }

    @RequestMapping(path = "/dog", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dog getDog() {

        Dog dog = Dog.builder()
                .id(1)
                .name("Scooby")
                .breed("Great Dane")
                .build();

        return dog;
    }



}




