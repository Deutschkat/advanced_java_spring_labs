package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.lab.complete.CoreLabConfig;

@SpringBootApplication
public class CoreLabApplicationDemo {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(
                MusicStoreConfiguration.class);

        Guitar guitar = context.getBean(Guitar.class);
        System.out.println(guitar.purchase());

        Drumset drumset = context.getBean(Drumset.class);
        System.out.println(drumset.purchase());

        Piano piano = context.getBean(Piano.class);
        System.out.println(piano.purchase());

    }

}
