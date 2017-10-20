package command;

public interface CommandFactory {
    public Command generateCommand(CommandData commandData) throws NoSuchCommandException, MissingFieldException;
}
