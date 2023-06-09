package platform.codingnomads.co.ioc.examples.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

    private Processor processor;
    private OS os;

    private Mouse mouse;

    private Keyboard keyboard;

    // these fields are being injected from the ApplicationContext
    // if a class contains only one constructor (as this one does), the use of @Autowired is optional
    // if a class contains two or more constructors, @Autowired is required for constructor injection to take place

    @Autowired
    public void setMouse(Mouse mouse){
        this.mouse = mouse;
    }

    public Laptop(Processor processor, OS os, Keyboard keyboard) {
        this.processor = processor;
        this.os = os;
        this.keyboard = keyboard;
    }

    public String printLaptopConfiguration() {
        return "processor: " + processor.getCore() + " core " + processor.getName() +
                "\nOS: " + os.getName()
                + "\nkeyboard: " + keyboard.getKeyboard()
        +       "\nmouse: " + mouse.getMouse();
    }
}
