package model.character;

public class Character{
    private CharacterName name;
    private CharacterClass klass;
    private CharacterPortrait portrait;
    private CharacterAuthentication authentication;

    public Character(){
        name = new CharacterName();
        klass = new CharacterClass();
        portrait = new CharacterPortrait();
        authentication = new CharacterAuthentication();
    }

    public String getName() {
        return name.getValue();
    }

    public void setName(String name) throws InvalidInputException {
        this.name.setValue(name);
    }

    public String getKlass() {
        return klass.getValue();
    }

    public void setKlass(String klass) throws InvalidInputException {
        this.klass.setValue(klass);
    }

    public String getPortrait() {
        return portrait.getValue();
    }

    public void setPortrait(String portrait) throws InvalidInputException {
        this.portrait.setValue(portrait);
    }

    public void setPassword(String password) throws InvalidInputException{
        this.authentication.setPassword(password);
    }

    public boolean isCorrectPassword(String password){
        return authentication.authenticate(password);
    }

    public String getAuthcode(){return authentication.getAuthcode();}

    public void setAuthcode(String authcode){authentication.setAuthcode(authcode);}

    @Override
    public int hashCode(){ return name.hashCode();}

    @Override
    public String toString(){
        return name.getValue();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Character)) return false;
        Character other = (Character)o;
        return other.getName().matches(this.getName());
    }
}
