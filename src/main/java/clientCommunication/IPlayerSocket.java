package clientCommunication;

import model.Account;

public interface IPlayerSocket {
    public void sendMessage(String message);
    public void connect(Account account);
}
