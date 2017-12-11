package model.character.traits.enh;

public class Edge {
    private String name;
    private String[] requirements;
    private String details;

    public Edge(String name, String[] requirements, String details){
        this.name = name;
        this.requirements = requirements;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String[] getRequirements() {
        return requirements;
    }

    public String getDetails() {
        return details;
    }
}
