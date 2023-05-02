package platform.codingnomads.co.corespring.examples.profileannotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("deploy")
public class DeployedPojo {
    public DeployedPojo(){
        System.out.println("New Pojo is ready!");
    }
}
