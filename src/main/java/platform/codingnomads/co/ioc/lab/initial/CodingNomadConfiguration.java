package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.lab.initial")
public class CodingNomadConfiguration {

    @Bean
    public Framework framework() {
        return Framework.builder().name("Spring Boot").version("2.5").build();
    }

    @Bean
    public IDE ide(){
        return IDE.builder().name("IntelliJ IDEA").version("2021.1").build();
    }

    @Bean
    public JDK jdk(){
        return JDK.builder().name("OpenJDK").version("11").build();
    }

    @Bean
    public DevOS devOS(){
        DevOS devOS = new DevOS();
        devOS.setOsName("Windows");
        return devOS;
    }

    @Bean
    public DevMonitor devMonitor(){
        DevMonitor monitor = new DevMonitor();
        monitor.setDevMonitor("HP Monitor");
        return monitor;
    }
}
