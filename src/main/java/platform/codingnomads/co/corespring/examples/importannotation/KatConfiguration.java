package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration("katConfiguration")
public class KatConfiguration {

    @Primary
    @Bean(name = "katBean")
    public Framework katBean() {
        System.out.println("Kat bean.");
        return new Framework();
    }
}