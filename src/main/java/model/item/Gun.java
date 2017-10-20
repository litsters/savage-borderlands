package model.item;

public class Gun extends Weapon {
    private Range range;

    public Gun(Rarity rarity, ItemName name, Damage damage, Range range) {
        super(rarity, name, damage);
        this.range = range;
    }

    public Range getRange() {
        return range;
    }

    @Override
    public String toString(){
        String inherited = super.toString();
        return inherited + " Range: " + range.getValue();
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
