package platform.codingnomads.co.aspectorientedprogramming.lab.service;

import org.springframework.stereotype.Service;
import platform.codingnomads.co.aspectorientedprogramming.lab.aspect.Printable;

@Service
public class GreetingService {

    @Printable
    public String greeting() {
        return "Hello Spring Developer!";
    }

    @Printable
    public String goodbye() {
        return "Goodbye Spring Developer!";
    }
}
