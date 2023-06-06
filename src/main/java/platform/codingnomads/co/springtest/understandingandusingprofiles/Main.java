package platform.codingnomads.co.springtest.understandingandusingprofiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("understanding_and_using_profiles")
//Can use different profiles for different classes.
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
