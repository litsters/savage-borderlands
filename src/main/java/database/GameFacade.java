package database;

import database.dao.CharacterDao;
import database.dao.PortraitDao;
import model.character.CharacterSummary;
import model.character.InvalidInputException;
import model.character.Character;
import security.AuthcodeGenerator;

import java.util.ArrayList;
import java.util.List;

public class GameFacade {
    private static GameFacade SINGLETON = null;
    public static GameFacade get(){
        if(SINGLETON == null) SINGLETON = new GameFacade();
        return SINGLETON;
    }

    private GameFacade(){}

    public void addCharacter(String name, String klass, String portrait, String password) throws InvalidInputException{
        Character character = new Character();
        character.setName(name);
        character.setKlass(klass);
        character.setPortrait(portrait);
        character.setPassword(password);
        CharacterDao.get().addCharacter(character);
    }

    public CharacterSummary[] getCharacterList(){
        List<CharacterSummary> characterSummaries = new ArrayList<>();
        Character[] characters = CharacterDao.get().getAllCharacters();
        for(Character c : characters){
            CharacterSummary summary = new CharacterSummary(c);
            characterSummaries.add(summary);
        }
        return characterSummaries.toArray(new CharacterSummary[]{});
    }

    public String[] getPortraitList(){
        return PortraitDao.get().getPortraits();
    }

    public String login(String name, String passwordAttempt){
        Character character = CharacterDao.get().getCharacter(name);
        if(character == null) return null;
        if(!character.correctPassword(passwordAttempt)) return null;
        else {
            String authCode = AuthcodeGenerator.get().generateAuthcode();
            character.setCurrentAuthcode(authCode);
            CharacterDao.get().addCharacter(character);
            return authCode;
        }
    }
}
