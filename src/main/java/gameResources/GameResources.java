package gameResources;

import model.character.traits.enh.Hindrance;
import model.character.traits.enh.Power;
import model.character.traits.skills.Skill;

public class GameResources {
    private static GameResources SINGLETON = null;
    public static GameResources get(){
        if(SINGLETON == null) SINGLETON = new GameResources();
        return SINGLETON;
    }

    private SkillJson skillJson;
    private HindranceJson hindranceJson;
    private EdgesJson edgesJson;
    private PowersJson powersJson;

    private GameResources(){
        skillJson = ResourceLoader.get().loadSkills();
        hindranceJson = ResourceLoader.get().loadHindrances();
        edgesJson = ResourceLoader.get().loadEdges();
        powersJson = ResourceLoader.get().loadPowers();
    }

    public Skill[] getSkills() {
        return skillJson.getSkills();
    }

    public Hindrance[] getHindrances(){
        return hindranceJson.getHindrances();
    }

    public EdgesJson getEdges(){ return edgesJson; }

    public Power[] getPowers(){return powersJson.getPowers();}
}
