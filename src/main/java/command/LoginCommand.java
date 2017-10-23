package command;

import database.GameFacade;

public class LoginCommand implements Command{
    private String name;
    private String passwordAttempt;

    public LoginCommand(String name, String passwordAttempt){
        this.name = name;
        this.passwordAttempt = passwordAttempt;
    }

    @Override
    public CommandResult execute() {
        CommandResult result = new CommandResult();
        try{
            String authCode = GameFacade.get().login(name, passwordAttempt);
            if(authCode == null) result.addValue("message", "WRONG NAME OR PASSWORD");
            else result.addValue("authcode", authCode);
        }catch(Exception e){
            result.addValue("message", "SOMETHING WENT WRONG");
        }
        return result;
    }
}
