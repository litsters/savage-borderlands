package model.item;

import model.character.InvalidInputException;

public class Range {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;

    private int value;

    public Range(int value) throws InvalidInputException{
        if(isValid(value)) this.value = value;
        else throw new InvalidInputException("Invalid range: " + value);
    }

    public static boolean isValid(int value){
        if(value < MIN_RANGE || value > MAX_RANGE) return false;
        else return true;
    }

    public int getValue() {
        return value;
    }
}
