package gameResources;

import model.character.traits.enh.Hindrance;
import model.character.traits.skills.Skill;

public class GameResources {
    private static GameResources SINGLETON = null;
    public static GameResources get(){
        if(SINGLETON == null) SINGLETON = new GameResources();
        return SINGLETON;
    }

    private SkillJson skillJson;
    private HindranceJson hindranceJson;

    private GameResources(){
        skillJson = ResourceLoader.get().loadSkills();
        hindranceJson = ResourceLoader.get().loadHindrances();
    }

    public Skill[] getSkills() {
        return skillJson.getSkills();
    }

    public Hindrance[] getHindrances(){
        return hindranceJson.getHindrances();
    }
}
