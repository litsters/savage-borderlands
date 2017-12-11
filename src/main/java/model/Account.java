package model;

import clientCommunication.IPlayerSocket;
import command.ACommand;
import model.character.Character;
import model.character.CharacterAuthentication;
import model.character.CharacterSummary;
import model.character.InvalidInputException;

import java.util.UUID;

public class Account {
    private Character character;
    private CharacterAuthentication authentication;
    private IPlayerSocket socket;

    public Account(Character character, String password) throws InvalidInputException{
        this.character = character;
        this.authentication = new CharacterAuthentication();
        this.authentication.setPassword(password);
        this.socket = null;
    }

    public String login(String passwordAttempt){
        if(this.authentication.authenticate(passwordAttempt)){
            String authcode = UUID.randomUUID().toString();
            this.authentication.setAuthcode(authcode);
            return authcode;
        }else return null;
    }

    public CharacterSummary getCharacterSummary(){
        return new CharacterSummary(character);
    }

    public void connect(IPlayerSocket socket){
        this.socket = socket;
        this.socket.connect(this);
    }

    public void disconnect(){
        this.socket = null;
    }

    public void executeCommand(ACommand command){
        command.execute(this);
    }
}
