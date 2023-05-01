package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class KatBeanNameAware implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("KatBeanNameAware: Bean name is set to " + name);
        System.out.println("Be excellent to each other!");
    }
}
