package platform.codingnomads.co.corespring.examples.springbeans;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBeansDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeansDemoConfig.class);
        KatBean springDeveloper = ctx.getBean(KatBean.class);
        System.out.println("Spring Developer Address: " + springDeveloper.getAddress().getStreetNumber() + " " +
                springDeveloper.getAddress().getStreet());
        System.out.println("Programming Language: " + springDeveloper.getLanguage().getName());
    }
}