package platform.codingnomads.co.corespring.examples.beanannotation.jsr_250;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanAnnotationJSR_250_Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanAnnotation_JSR_250_Config.class);
        SampleBean sampleBean = ctx.getBean(SampleBean.class);
        ctx.close();
    }
}
