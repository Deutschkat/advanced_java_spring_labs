package platform.codingnomads.co.corespring.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Guitar {
    private String brand;

    public String purchase(){
        return "Purchasing a " + brand + " guitar.";
    }
}
