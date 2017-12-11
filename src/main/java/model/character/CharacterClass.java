package model.character;

public class CharacterClass {
    private String value;

    public CharacterClass(){
        this.value = null;
    }

    public void setValue(String value) throws InvalidInputException{
        if(!isValidClass(value)){
            throw new InvalidInputException("Invalid class");
        }else this.value = value;
    }

    public String getValue(){return value;}

    public static boolean isValidClass(String klass){
        if(klass == null || klass.length() == 0) return false;
        else return true;
    }
}
