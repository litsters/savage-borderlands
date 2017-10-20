package model.player;

import model.character.InvalidInputException;

public class Password {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 32;

    public static boolean isValid(String value){
        if(value == null) return false;
        if(value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) return false;
        return true;
    }

    private String value;

    public Password(String value)throws InvalidInputException{
        if(isValid(value)) this.value = value;
        else throw new InvalidInputException("Invalid password: " + value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public int hashCode(){
        return value.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Password)) return false;
        Password other = (Password)o;
        return other.value.matches(this.value);
    }
}
