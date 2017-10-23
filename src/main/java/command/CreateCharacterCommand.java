package command;

import database.GameFacade;
import model.character.InvalidInputException;

public class CreateCharacterCommand implements Command {
    private String name;
    private String klass;
    private String portrait;
    private String password;

    public CreateCharacterCommand(String name, String klass, String portrait, String password){
        this.name = name;
        this.klass = klass;
        this.portrait = portrait;
        this.password = password;
    }

    @Override
    public CommandResult execute() {
        CommandResult result = new CommandResult();
        try{
            GameFacade.get().addCharacter(name, klass, portrait, password);
            result.addValue("message", "success");
        }catch(InvalidInputException e){
            result.addValue("message", e.getMessage());
        }

        return result;
    }
}
