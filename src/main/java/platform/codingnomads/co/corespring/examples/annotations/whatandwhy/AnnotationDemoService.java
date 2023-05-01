package platform.codingnomads.co.corespring.examples.annotations.whatandwhy;

public class AnnotationDemoService implements LegacyInfoProvider {

    @ModernInfo
    @SecondaryData
    @Override
    public String info() {
        return "legacy api fetching information";
    }


    @SecondaryData
    public String data(){
        return "primary data";
    }
}
