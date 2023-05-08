package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifecycleCallbackDemo {

    public static void main(String[] args) {
        SpringApplication.run(LifecycleCallbackDemo.class);
    }

    @Bean
    public CommandLineRunner runStuff(PrintEntityRepository printEntityRepository) {
        return (args) -> {
            PrintEntity entity1 = new PrintEntity();
            entity1.setName("Entity 1");
            printEntityRepository.save(entity1);

            PrintEntity entity2 = new PrintEntity();
            entity2.setName("Entity 2");
            printEntityRepository.save(entity2);
        };
    }
}
