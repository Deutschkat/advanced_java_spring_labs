package platform.codingnomads.co.corespring.examples.application_context.xml;

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

    private final GitTool gitTool;

    @Autowired
    public CodingNomad(GitTool gitTool, JDK jdk, IDE ide, Framework framework){
        this.gitTool = gitTool;
        this.jdk = jdk;
        this.ide = ide;
        this.framework = framework;
    }

    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This coding nomad is creating awesome software using: " + gitTool.getName() + ", " + gitTool.getDescription() + " They are also using: " +
                                "IDE:({0}:{1}), JDK: ({2}:{3}), Framework:({4}:{5})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion()
                );
    }
}
