package model.player;

import model.item.UniqueObject;
import model.character.Character;

import java.util.HashMap;
import java.util.Map;

public class Player extends UniqueObject {
    private Username username;
    private Password password;

    private Map<String, Character> characters;

    public Player(Username username, Password password){
        super();
        this.username = username;
        this.password = password;
        this.characters = new HashMap<>();
    }

    public Username getUsername() {
        return username;
    }

    public void addCharacter(Character character){
        characters.put(character.getId(), character);
    }

    public Character getCharacter(String id){
        return characters.get(id);
    }

    public Character[] getAllCharacters(){
        return characters.values().toArray(new Character[]{});
    }

    public boolean correctPassword(String attempt){
        if(this.password.getValue().matches(attempt)) return true;
        else return false;
    }

    @Override
    public String toString(){
        return super.toString() + " Username: " + username.getValue();
    }

    @Override
    public int hashCode(){ return super.hashCode();}

    @Override
    public boolean equals(Object o){ return super.equals(o);}
}
