package gameResources;

import model.character.traits.enh.Hindrance;

public class HindranceJson {
    private Hindrance[] hindrances;

    public HindranceJson(){
        hindrances = null;
    }

    public Hindrance[] getHindrances() {
        return hindrances;
    }

    public void setHindrances(Hindrance[] hindrances) {
        this.hindrances = hindrances;
    }
}
