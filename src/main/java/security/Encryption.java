package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    private static Encryption SINGLETON = null;
    public static Encryption get(){
        if(SINGLETON == null) SINGLETON = new Encryption();
        return SINGLETON;
    }
    private Encryption(){}

    public String hashPassword(String password) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte bytes[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
