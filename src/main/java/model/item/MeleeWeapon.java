package model.item;

public class MeleeWeapon extends Weapon {
    public MeleeWeapon(Rarity rarity, ItemName name, Damage damage) {
        super(rarity, name, damage);
    }

    @Override
    public String toString(){
        return super.toString() + " Range: Melee";
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
