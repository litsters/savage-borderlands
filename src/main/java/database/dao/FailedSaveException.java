package database.dao;

public class FailedSaveException extends Exception {
    public FailedSaveException(){super();}
    public FailedSaveException(String message){super(message);}
}
