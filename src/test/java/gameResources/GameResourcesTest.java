package gameResources;

import model.character.traits.enh.Hindrance;
import model.character.traits.enh.Power;
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

    @Test
    public void getEdges() throws Exception{
        EdgesJson edges = GameResources.get().getEdges();
        assertTrue(edges != null);
        assertTrue(edges.getBackground_edges() != null);
        assertTrue(edges.getCombat_edges() != null);
        assertTrue(edges.getLeadership_edges() != null);
        assertTrue(edges.getLegendary_edges() != null);
        assertTrue(edges.getPower_edges() != null);
        assertTrue(edges.getProfessional_edges() != null);
        assertTrue(edges.getSocial_edges() != null);
        assertTrue(edges.getWeird_edges() != null);
        assertTrue(edges.getWild_card_edges() != null);
    }

    @Test
    public void getPowers() throws Exception{
        Power[] powers = GameResources.get().getPowers();
        assertTrue(powers != null);
        assertTrue(powers.length > 0);
    }

}