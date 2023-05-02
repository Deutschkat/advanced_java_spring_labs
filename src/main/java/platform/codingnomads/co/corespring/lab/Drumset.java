package platform.codingnomads.co.corespring.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Drumset {
    private String manufacturer;

    public String purchase(){
        return "Purchasing " + manufacturer + " drum set.";

    }
}
