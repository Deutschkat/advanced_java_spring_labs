package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dog {

    private int id;
    private String breed;
    private String name;

}
