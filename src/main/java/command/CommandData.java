package command;

public class CommandData {
    private CommandType type;

    public CommandData(CommandType type){
        this.type = type;
    }

    public CommandType getType() {
        return type;
    }
}
