package platform.codingnomads.co.corespring.examples.application_context.xml;

public class GitTool {
    private String name;
    private String description;

    public GitTool() {
        this.name = "Git";
        this.description = "A developer tool used for commits & system control.";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
