package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {

    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    @Autowired
    private DevMonitor devMonitor;

    private DevOS devOS;

    @Autowired
    public void setDevOS(DevOS devOS){
        this.devOS = devOS;
    }


    public String createAwesomeSoftware(){
        return MessageFormat
                .format("This coding nomad is creating awesome software using, " +
                        " IDE : ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion()) + "\n Developer Monitor: " + devMonitor.getDevMonitor() +
                "\n Developer OS: " + devOS.getOsName();
    }
}
