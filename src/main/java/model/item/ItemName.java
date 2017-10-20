package model.item;

import model.character.InvalidInputException;

public class ItemName {
    private String value;

    public static boolean isValid(String value){
        if(value == null || value.length() == 0) return false;
        else return true;
    }

    public ItemName(String value) throws InvalidInputException{
        if(isValid(value)) this.value = value;
        else throw new InvalidInputException("Invalid item name: " + value);
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
        if(!(o instanceof ItemName)) return false;
        ItemName other = (ItemName)o;
        return other.value.matches(this.value);
    }
}
