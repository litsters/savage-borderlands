package database.dao;

import model.game.Game;
import model.character.Character;

public class CharacterDao {
    private static CharacterDao SINGLETON = null;
    public static CharacterDao get(){
        if(SINGLETON == null) SINGLETON = new CharacterDao();
        return SINGLETON;
    }
    private CharacterDao(){}

    public Character getCharacter(String name){
        return Game.get().getCharacter(name);
    }

    public Character[] getAllCharacters(){
        return Game.get().getAllCharacters();
    }

    public void addCharacter(Character character){
        Game.get().addCharacter(character);
    }
}
