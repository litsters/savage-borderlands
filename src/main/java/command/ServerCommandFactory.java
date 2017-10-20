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
            default:
                throw new NoSuchCommandException("Unrecognized command: " + commandData.getType());
        }
    }
}
