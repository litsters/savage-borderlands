package server;

import clientCommunication.IPlayerSocket;
import model.Account;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;

import java.io.IOException;

public class ClientSocket implements WebSocketListener, IPlayerSocket{
    private Session client;
    private Account model;

    public ClientSocket(){
        client = null;
        model = null;
    }

    @Override
    public void onWebSocketBinary(byte[] bytes, int i, int i1) {

    }

    @Override
    public void onWebSocketText(String s) {

    }

    @Override
    public void onWebSocketClose(int i, String s) {
        this.client = null;
    }

    @Override
    public void onWebSocketConnect(Session session) {
        this.client = session;
    }

    @Override
    public void onWebSocketError(Throwable throwable) {

    }

    @Override
    public void sendMessage(String message) {
        try{
            client.getRemote().sendString(message);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void connect(Account account) {
        this.model = account;
    }
}
