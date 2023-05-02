package platform.codingnomads.co.corespring.examples.springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = KatBean.class)
public class SpringBeansDemoConfig {
    @Bean
    public Address address() {
        return new Address("Main Street", 1500);
    }

    @Bean
    public Language language() {
        return new Language("Java");
    }

    @Bean
    public KatBean springDeveloper(Address address, Language language) {
        return new KatBean();


    }
}
