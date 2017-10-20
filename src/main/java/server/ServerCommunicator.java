package server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ServerCommunicator {
    private static final String DEFAULT_CONTEXT = "/";
    private static final String COMMAND_CONTEXT = "/command";
    private static final int DEFAULT_PORT_NUMBER = 8080;
    private static int PORT_NUMBER = DEFAULT_PORT_NUMBER;
    private static int MAX_WAITING_CONNECTIONS = 10;

    public static int getDefaultPortNumber(){return DEFAULT_PORT_NUMBER;}
    public static int getPortNumber(){ return PORT_NUMBER;}
    public static void setPortNumber(int portNumber){ PORT_NUMBER = portNumber;}

    private HttpServer server;

    private ServerCommunicator(){}

    private void run(){
        setupServer(PORT_NUMBER, MAX_WAITING_CONNECTIONS);
        setupContext();
        server.start();
    }

    private void setupServer(int portNumber, int maxWaitingConnections){
        try {
            server = HttpServer.create(new InetSocketAddress(portNumber),
                    maxWaitingConnections);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        server.setExecutor(null); // use the default executor
    }

    private void setupContext(){
        server.createContext(COMMAND_CONTEXT, new CommandHandler());
        server.createContext(DEFAULT_CONTEXT, new PageHandler());
    }

    public static void main(String[] args) {
        if(args.length == 1){
            try{
                int portNumber = Integer.parseInt(args[0]);
                ServerCommunicator.setPortNumber(portNumber);
            }catch(NumberFormatException e){
                System.err.println(args[0] + " is not a number, using default port " + DEFAULT_PORT_NUMBER);
                ServerCommunicator.setPortNumber(DEFAULT_PORT_NUMBER);
            }
        }
        new ServerCommunicator().run();
    }
}
