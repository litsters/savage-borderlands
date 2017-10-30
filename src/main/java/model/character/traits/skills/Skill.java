package model.character.traits.skills;

public class Skill {
    private String name;
    private String linkedAttribute;
    private String details;

    public Skill(){
        this.name = null;
        this.linkedAttribute = null;
        this.details = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkedAttribute() {
        return linkedAttribute;
    }

    public void setLinkedAttribute(String linkedAttribute) {
        this.linkedAttribute = linkedAttribute;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString(){
        return name + " (" + linkedAttribute + ")";
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Skill)) return false;
        Skill other = (Skill)o;
        return this.toString().matches(other.toString());
    }
}
