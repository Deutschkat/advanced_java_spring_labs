package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DesktopComputer {

    @Autowired
    private VideoCard videoCard;

    private final DisplayDevice displayDevice;

    @Autowired
    public DesktopComputer(DisplayDevice displayDevice, VideoCard videoCard){
        this.displayDevice = displayDevice;
        this.videoCard= videoCard;
    }

    public void display(){
        displayDevice.display();
    }

}
