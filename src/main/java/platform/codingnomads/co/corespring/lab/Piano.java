package platform.codingnomads.co.corespring.lab;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Piano {
    private String brand;

    public String purchase(){
        return "Purchasing " + brand + " piano.";
    }
}
