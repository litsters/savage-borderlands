package database.dao;

public class NoSuchPlayerException extends Exception {
    public NoSuchPlayerException(){super();}
    public NoSuchPlayerException(String message){super(message);}
}
