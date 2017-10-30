package model.character.traits.attributes;

import model.character.InvalidInputException;

public class DiceLevel {
    private int index;
    int bonus;

    public DiceLevel(int index) throws InvalidInputException {
        if(!validIndex(index)) throw new InvalidInputException("Invalid value for attribute");
        else this.index = index;
        bonus = 0;
    }

    public boolean validIndex(int index){
        if(index % 2 != 0 || index > 12) return false;
        else return true;
    }

    public void setBonus(int bonus){
        this.bonus = bonus;
    }

    @Override
    public String toString(){
        if(bonus == 0){
            return "d" + index;
        } else {
            return "d" + index + "+" + bonus;
        }
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof DiceLevel)) return false;
        DiceLevel other = (DiceLevel)o;
        return (this.index == other.index && this.bonus == other.bonus);
    }

    @Override
    public int hashCode(){
        return index + bonus;
    }
}
