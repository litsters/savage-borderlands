package command;

import database.GameFacade;
import model.character.CharacterSummary;

public class GetCharacterListCommand implements Command {

    @Override
    public CommandResult execute() {
        CommandResult result = new CommandResult();
        CharacterSummary[] characters = GameFacade.get().getCharacterList();
        result.addValue("characters", characters);
        return result;
    }
}
