package persistence;

public class MissingPersistedObjectException extends Exception{
    public MissingPersistedObjectException(){super();}
    public MissingPersistedObjectException(String message){super(message);}
}
