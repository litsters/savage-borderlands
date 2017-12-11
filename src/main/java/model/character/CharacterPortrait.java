package model.character;

import database.fileStructure.PathMaster;

import java.io.File;

public class CharacterPortrait {
    private String value;

    public CharacterPortrait(){
        this.value = null;
    }

    public static boolean isValid(String portrait){
        if(portrait == null || portrait.length() == 0) return false;
        // Verify that file exists
        File verification = new File(PathMaster.getPortraitRoot() + portrait);
        if(!verification.exists()) return false;
        return true;
    }

    public void setValue(String value) throws InvalidInputException{
        if(!isValid(value)) throw new InvalidInputException("Invalid portrait: " + value);
        else this.value = value;
    }

    public String getValue(){return value;}
}
