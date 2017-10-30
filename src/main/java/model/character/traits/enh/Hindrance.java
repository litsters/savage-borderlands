package model.character.traits.enh;

public class Hindrance {
    private QualityLevel level;
    private String name;
    private String details;

    public Hindrance(){
        this.level = null;
        this.name = null;
        this.details = null;
    }

    public QualityLevel getLevel() {
        return level;
    }

    public void setLevel(QualityLevel level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
