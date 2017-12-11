package server;

public class SocketServerCommunicator {
    public static final int DEFAULT_PORT = 8080;
    private static int PORT_NUMBER = DEFAULT_PORT;
    public static int getPortNumber(){return PORT_NUMBER;}
    public static void setPortNumber(int portNumber){PORT_NUMBER = portNumber;}

    public static void main(String[] args)throws Exception{
        if(args.length == 1){
            try{
                int portNumber = Integer.parseInt(args[0]);
                setPortNumber(portNumber);
            }catch(NumberFormatException e){
                System.err.println("Invalid port number, running on default 8080");
            }
        }

        JettyServer jettyServer = new JettyServer();
        jettyServer.start(PORT_NUMBER);
    }
}
