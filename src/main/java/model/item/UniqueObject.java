package model.item;

public class UniqueObject {
    private String id;

    public UniqueObject(){
        this.id = IdGenerator.get().generateId();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Id: " + id;
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof UniqueObject)) return false;
        UniqueObject other = (UniqueObject)o;
        return other.id.matches(this.id);
    }

    @Override
    public int hashCode(){
        return id.hashCode();
    }
}
