package command;

import model.Account;

public interface ACommand {
    public void execute(Account account);
}
