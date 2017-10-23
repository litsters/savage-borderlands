package model.character;

import database.dao.CharacterDao;
import database.fileStructure.PathMaster;
import security.Encryption;

import java.io.File;
import java.security.NoSuchAlgorithmException;

public class Character{
    private String name;
    private String klass;
    private String portrait;
    private String passwordHash;

    private String currentAuthcode;

    public Character(){
        name = null;
        klass = null;
        portrait = null;
        passwordHash = null;
        currentAuthcode = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidInputException {
        if(!isValidName(name)) throw new InvalidInputException("Invalid name");
        this.name = name;
    }

    public boolean isValidName(String name){
        if(name == null || name.length() == 0) return false;
        if(CharacterDao.get().getCharacter(name) != null) return false;
        else return true;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) throws InvalidInputException {
        if(!isValidClass(klass)) throw new InvalidInputException("Invalid class");
        this.klass = klass;
    }

    public boolean isValidClass(String klass){
        if(klass == null || klass.length() == 0) return false;
        else return true;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) throws InvalidInputException {
        if(!isValidPortrait(portrait)) throw new InvalidInputException("Invalid portrait");
        this.portrait = portrait;
    }

    public boolean isValidPortrait(String portrait){
        if(portrait == null || portrait.length() == 0) return false;
        // Verify that file exists
        File verification = new File(PathMaster.getPortraitRoot() + portrait);
        if(!verification.exists()) return false;
        return true;
    }

    public void setPassword(String password) throws InvalidInputException {
        if(!isValidPassword(password)) throw new InvalidInputException("Invalid password");
        try{
            passwordHash = Encryption.get().hashPassword(password);
        }catch(NoSuchAlgorithmException e){
            passwordHash = password;
        }
    }

    public boolean isValidPassword(String password){
        if(password == null || password.length() == 0) return false;
        else return true;
    }

    public boolean correctPassword(String passwordAttempt){
        try{
            passwordAttempt = Encryption.get().hashPassword(passwordAttempt);
        }catch(NoSuchAlgorithmException e){

        }
        return passwordAttempt.matches(passwordHash);
    }

    public String getCurrentAuthcode() {
        return currentAuthcode;
    }

    public void setCurrentAuthcode(String currentAuthcode) {
        this.currentAuthcode = currentAuthcode;
    }

    @Override
    public int hashCode(){ return name.hashCode();}

    @Override
    public String toString(){
        return " Name: " + name.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Character)) return false;
        Character other = (Character)o;
        if(!other.name.matches(this.name)) return false;
        return true;
    }
}
