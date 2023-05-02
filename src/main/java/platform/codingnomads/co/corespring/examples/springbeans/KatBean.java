package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class KatBean {

    private Address address;

    private Language language;

    public KatBean() {
        this.address = address;
        this.language = language;

    }
}
