package platform.codingnomads.co.corespring.examples.autowiredannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private VideoCard videoCard;

    @Autowired
    public void setVideoCard(@Qualifier("geforce") VideoCard videoCard){
        this.videoCard = videoCard;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }
}