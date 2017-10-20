package model.player;

import database.dao.PlayerDao;
import model.character.InvalidInputException;

public class Username {
    private static final int MIN_LENGTH = 4;
    private static final int MAX_LENGTH = 16;

    private String value;

    public Username(String value) throws InvalidInputException{
        if(isValid(value)) this.value = value;
        else throw new InvalidInputException("Invalid username: " + value);
    }

    public static boolean isValid(String value){
        if(value == null) return false;
        if(value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) return false;
        return true;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString(){return value;}

    @Override
    public int hashCode(){return value.hashCode();}

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Username)) return false;
        Username other = (Username)o;
        return other.value.matches(this.value);
    }
}
