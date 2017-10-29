package command;

public class DummyCommand implements Command {
    @Override
    public CommandResult execute() {
        CommandResult result = new CommandResult();
        result.addValue("message", "success");
        return result;
    }
}
