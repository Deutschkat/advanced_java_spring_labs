package platform.codingnomads.co.corespring.examples.autowiredannotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Desktop {

    private final VideoCard videoCard;

    @Autowired
    public Desktop(@Qualifier("radeon") VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }
}

