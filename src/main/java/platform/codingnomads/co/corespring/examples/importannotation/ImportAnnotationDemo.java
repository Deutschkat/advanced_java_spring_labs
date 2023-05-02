package platform.codingnomads.co.corespring.examples.importannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import platform.codingnomads.co.corespring.examples.springbeans.KatBean;

public class ImportAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ImportAnnotationConfig.class, KatConfiguration.class);
        ctx.refresh();
        final SpringDeveloper springDeveloper = ctx.getBean(SpringDeveloper.class);
        final Framework framework = ctx.getBean(Framework.class);
        final Framework katBean = ctx.getBean("katBean", Framework.class);
        ctx.close();
    }
}
