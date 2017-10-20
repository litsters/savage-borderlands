package model.character;

import model.item.UniqueObject;

public class Character extends UniqueObject {
    private CharacterName name;
    private Inventory inventory;

    public Character(CharacterName name){
        super();
        this.name = name;
        this.inventory = new Inventory();
    }

    public CharacterName getName() {
        return name;
    }

    @Override
    public int hashCode(){ return super.hashCode();}

    @Override
    public String toString(){
        return super.toString() + " Name: " + name.toString();
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
}
