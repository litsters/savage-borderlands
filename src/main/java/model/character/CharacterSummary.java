package model.character;

public class CharacterSummary {
    private String name;
    private String klass;
    private String portrait;

    public CharacterSummary(Character character){
        this.name = character.getName();
        this.klass = character.getKlass();
        this.portrait = character.getPortrait();
    }

    public String getName() {
        return name;
    }

    public String getKlass() {
        return klass;
    }

    public String getPortrait() {
        return portrait;
    }
}
