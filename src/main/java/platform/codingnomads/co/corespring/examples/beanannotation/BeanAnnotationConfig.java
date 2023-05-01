package platform.codingnomads.co.corespring.examples.beanannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAnnotationConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup", name = "friendly_bean_name")
    public SampleBean sampleBean() {
        return new SampleBean();
    }

    @Bean(initMethod = "init", destroyMethod = "cleanup", name = "casper_the_friendly_bean")
    public SampleBean anotherSampleBean(){ return new SampleBean();}

}
