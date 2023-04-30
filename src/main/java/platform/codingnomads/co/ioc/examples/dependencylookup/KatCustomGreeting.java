package platform.codingnomads.co.ioc.examples.dependencylookup;

public class KatCustomGreeting implements GreetingProvider{
    @Override
    public String getGreeting(){
        return "Hi! My Name is Kat.";
    }
}
