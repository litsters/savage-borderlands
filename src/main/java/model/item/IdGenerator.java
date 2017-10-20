package model.item;

import java.util.UUID;

public class IdGenerator {
    private static IdGenerator SINGLETON = null;
    public static IdGenerator get(){
        if(SINGLETON == null) SINGLETON = new IdGenerator();
        return SINGLETON;
    }
    private IdGenerator(){}

    public String generateId(){
        return UUID.randomUUID().toString();
    }
}
