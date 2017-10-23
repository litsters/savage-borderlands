package model.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.character.Character;

public class Game {
    private static Game SINGLETON = null;
    public static Game get(){
        if(SINGLETON == null) SINGLETON = new Game();
        return SINGLETON;
    }

    private Map<String, Character> characters;

    private Game(){
        characters = new HashMap<>();
    }

    public void addCharacter(Character character){
        characters.put(character.getName(), character);
    }

    public Character getCharacter(String name){
        return characters.get(name);
    }

    public Character[] getAllCharacters(){
        List<Character> characters = new ArrayList<>();
        characters.addAll(this.characters.values());
        return characters.toArray(new Character[]{});
    }
}
