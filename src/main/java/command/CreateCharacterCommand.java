package command;

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
        // TODO Make this actually do something
        CommandResult result = new CommandResult();
        result.addValue("message", "success");
        return result;
    }
}
