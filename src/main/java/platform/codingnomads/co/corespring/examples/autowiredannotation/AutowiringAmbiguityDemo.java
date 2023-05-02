package platform.codingnomads.co.corespring.examples.autowiredannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AutowiringAmbiguityDemo {

    private final Desktop desktopComputer;
    private final Laptop laptopComputer;

    @Autowired
    public AutowiringAmbiguityDemo(Desktop desktopComputer, Laptop laptopComputer) {
        this.desktopComputer = desktopComputer;
        this.laptopComputer = laptopComputer;
    }

    public static void main(String[] args) {
        SpringApplication.run(AutowiringAmbiguityDemo.class);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            System.out.println("Desktop Computer: " + desktopComputer);
            System.out.println("Laptop Computer Video Card: " + laptopComputer.getVideoCard());
        };
    }

    @Bean
    public Desktop desktopComputer() {
        return new Desktop(new Radeon());
    }

    @Bean
    public Laptop laptopComputer() {
        return new Laptop();
    }
}
