package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.stereotype.Component;

@Component
public class Projector implements DisplayDevice{
    @Override
    public void display() {
        System.out.println("Projector display");
    }
}
