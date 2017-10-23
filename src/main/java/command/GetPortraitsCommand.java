package command;

import database.GameFacade;

public class GetPortraitsCommand implements Command {
    @Override
    public CommandResult execute() {
        CommandResult result = new CommandResult();
        try{
            String[] portraits = GameFacade.get().getPortraitList();
            result.addValue("portraits", portraits);
        }catch(Exception e){
            result.addValue("message", "COULDN'T GET PORTRAITS");
        }
        return result;
    }
}
