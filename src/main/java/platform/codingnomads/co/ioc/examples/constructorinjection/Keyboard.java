package platform.codingnomads.co.ioc.examples.constructorinjection;

public class Keyboard {

    private String keyboard;

    public Keyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }
}
