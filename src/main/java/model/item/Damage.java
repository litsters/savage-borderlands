package model.item;

import model.character.InvalidInputException;

public class Damage {
    private static final int MIN_DAMAGE = 0;
    private static final int MAX_DAMAGE = 100;

    private int value;

    public Damage(int value) throws InvalidInputException{
        if(isValid(value)) this.value = value;
        else throw new InvalidInputException("Invalid damage: " + value);
    }

    public static boolean isValid(int value){
        if(value < MIN_DAMAGE || value > MAX_DAMAGE) return false;
        else return true;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }

    @Override
    public int hashCode(){
        return value;
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Damage)) return false;
        Damage other = (Damage)o;
        return other.value == this.value;
    }
}
