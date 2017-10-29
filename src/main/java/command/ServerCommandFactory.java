package command;

public class ServerCommandFactory implements CommandFactory {
    private static CommandFactory SINGLETON = null;
    public static CommandFactory get(){
        if(SINGLETON == null) SINGLETON = new ServerCommandFactory();
        return SINGLETON;
    }
    private ServerCommandFactory(){}

    @Override
    public Command generateCommand(CommandData commandData) throws NoSuchCommandException, MissingFieldException{
        switch(commandData.getType()){
            case GET_CHARACTER_LIST:
                return new GetCharacterListCommand();
            case CREATE_CHARACTER:
                String name = commandData.getValue("name");
                String klass = commandData.getValue("klass");
                String portrait = commandData.getValue("portrait");
                String password = commandData.getValue("password");
                return new CreateCharacterCommand(name, klass, portrait, password);
            case GET_PORTRAITS:
                return new GetPortraitsCommand();
            case LOGIN:
                name = commandData.getValue("name");
                String passwordAttempt = commandData.getValue("passwordAttempt");
                return new LoginCommand(name, passwordAttempt);
            case DUMMY:
                return new DummyCommand();
            default:
                throw new NoSuchCommandException("Unrecognized command: " + commandData.getType());
        }
    }
}
