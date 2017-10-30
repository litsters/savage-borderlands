package gameResources;

import model.character.traits.enh.Hindrance;
import model.character.traits.skills.Skill;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameResourcesTest {
    @Test
    public void getSkills() throws Exception {
        Skill[] skills = GameResources.get().getSkills();
        assertTrue(skills != null);
        assertTrue(skills.length > 0);
    }

    @Test
    public void getHindrances() throws Exception {
        Hindrance[] hindrances = GameResources.get().getHindrances();
        assertTrue(hindrances != null);
        assertTrue(hindrances.length > 0);
    }

}