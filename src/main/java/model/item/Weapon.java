package model.item;

public class Weapon extends Item {
    private Damage damage;

    public Weapon(Rarity rarity, ItemName name, Damage damage) {
        super(rarity, name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage.getValue();
    }

    @Override
    public String toString(){
        String inherited = super.toString();
        return inherited + " Damage: " + getDamage();
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }
}
