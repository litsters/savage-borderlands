package model.character;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 32;

    private String value;

    public CharacterName(){
        this.value = null;
    }

    public static boolean isValid(String value){
        if(value == null) return false;
        value = value.trim();
        if(value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) return false;
        Pattern p = Pattern.compile("[^a-z0-9\\s\\-\\']", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(value);
        return !m.find();
    }

    public void setValue(String value) throws InvalidInputException{
        if(!isValid(value)) throw new InvalidInputException("Invalid name: " + value);
        else this.value = value;
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
        if(!(o instanceof CharacterName)) return false;
        CharacterName other = (CharacterName)o;
        return other.value.matches(this.value);
    }
}
