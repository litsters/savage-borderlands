package model.character.traits.skills;

import model.character.traits.attributes.DiceLevel;

import java.util.HashMap;
import java.util.Map;

public class Skills {
    private Map<Skill, DiceLevel> skills;

    public Skills(){
        skills = new HashMap<>();
    }

    public void addSkill(Skill skill, DiceLevel diceLevel){
        skills.put(skill, diceLevel);
    }

    public DiceLevel getSkillLevel(Skill skill){
        return skills.get(skill);
    }

    public boolean hasSkill(Skill skill){
        if(skills.get(skill) == null) return false;
        else return true;
    }
}
