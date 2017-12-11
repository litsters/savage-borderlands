package model.character;

import security.Encryption;

import java.security.NoSuchAlgorithmException;

public class CharacterAuthentication {
    private String passwordHash;
    private String authcode;

    public CharacterAuthentication(){
        passwordHash = null;
        authcode = null;
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

    public static boolean isValidPassword(String password){
        if(password == null || password.length() == 0) return false;
        else return true;
    }

    public void setPassword(String password)throws InvalidInputException{
        if(!isValidPassword(password)) throw new InvalidInputException("Invalid password: " + password);
        try{
            passwordHash = Encryption.get().hashPassword(password);
        }catch(NoSuchAlgorithmException e){
            passwordHash = password;
        }
    }

    public boolean authenticate(String passwordAttempt){
        try{
            passwordAttempt = Encryption.get().hashPassword(passwordAttempt);
        }catch(NoSuchAlgorithmException e){
            // Do nothing
        }
        return passwordAttempt.matches(this.passwordHash);
    }
}
