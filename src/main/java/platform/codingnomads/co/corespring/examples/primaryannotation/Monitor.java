package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Monitor implements DisplayDevice{
    @Override
    public void display() {
        System.out.println("Monitor display");
    }
}
