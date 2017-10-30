package model.character.traits.attributes;

import model.character.InvalidInputException;

public class Attributes {
    private DiceLevel agility;
    private DiceLevel smarts;
    private DiceLevel spirit;
    private DiceLevel strength;
    private DiceLevel vigor;

    public Attributes(int agility, int smarts, int spirit, int strength, int vigor) throws InvalidInputException {
        this.agility = new DiceLevel(agility);
        this.smarts = new DiceLevel(smarts);
        this.spirit = new DiceLevel(spirit);
        this.strength = new DiceLevel(strength);
        this.vigor = new DiceLevel(vigor);
    }

    public String getAgility(){
        return agility.toString();
    }

    public String getSmarts(){
        return smarts.toString();
    }

    public String getSpirit(){
        return spirit.toString();
    }

    public String getStrength(){
        return strength.toString();
    }

    public String getVigor(){
        return vigor.toString();
    }
}
