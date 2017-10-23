package security;

import java.util.UUID;

public class AuthcodeGenerator {
    private static AuthcodeGenerator SINGLETON = null;
    public static AuthcodeGenerator get(){
        if(SINGLETON == null) SINGLETON = new AuthcodeGenerator();
        return SINGLETON;
    }
    private AuthcodeGenerator(){}

    public String generateAuthcode(){
        return UUID.randomUUID().toString();
    }
}
