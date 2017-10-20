package model.item;

public class Item extends UniqueObject {
    private Rarity rarity;
    private ItemName name;

    public Item(Rarity rarity, ItemName name){
        super();
        this.rarity = rarity;
        this.name = name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getName() {
        return name.getValue();
    }

    @Override
    public String toString(){
        String inherited = super.toString();
        return inherited + " Name: " + name.toString() + " Rarity: " + rarity;
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }
}
