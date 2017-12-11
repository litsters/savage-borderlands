package gameResources;

import model.character.traits.enh.Edge;

public class EdgesJson {
    private Edge[] background_edges;
    private Edge[] combat_edges;
    private Edge[] leadership_edges;
    private Edge[] power_edges;
    private Edge[] professional_edges;
    private Edge[] social_edges;
    private Edge[] weird_edges;
    private Edge[] wild_card_edges;
    private Edge[] legendary_edges;

    public EdgesJson(){

    }

    public Edge[] getBackground_edges() {
        return background_edges;
    }

    public Edge[] getCombat_edges() {
        return combat_edges;
    }

    public Edge[] getLeadership_edges() {
        return leadership_edges;
    }

    public Edge[] getPower_edges() {
        return power_edges;
    }

    public Edge[] getProfessional_edges() {
        return professional_edges;
    }

    public Edge[] getSocial_edges() {
        return social_edges;
    }

    public Edge[] getWeird_edges() {
        return weird_edges;
    }

    public Edge[] getWild_card_edges() {
        return wild_card_edges;
    }

    public Edge[] getLegendary_edges() {
        return legendary_edges;
    }
}
