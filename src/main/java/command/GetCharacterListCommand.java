package command;

public class GetCharacterListCommand implements Command {
    @Override
    public CommandResult execute() {
        CommandResult result = new CommandResult();
        String[] mock = new String[]{"character1", "character2"};
        result.addValue("characters", mock);
        return result;
    }
}
