package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/music-store.xml"})
public class MusicStoreConfiguration {

    @Bean
    public Guitar guitar(){
        return new Guitar("Fender");
    }

    @Bean
    public Drumset drumset(){
        return new Drumset("Ludwig");
    }
}
