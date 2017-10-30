package gameResources;

import model.character.traits.skills.Skill;

public class SkillJson {
    private Skill[] skills;

    public SkillJson(){
        skills = null;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }
}
