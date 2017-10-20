package command;

public class NoSuchCommandException extends Exception {
    public NoSuchCommandException(){super();}
    public NoSuchCommandException(String message){super(message);}
}
