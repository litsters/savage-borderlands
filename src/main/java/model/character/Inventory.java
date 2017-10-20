package model.character;

import model.item.Gun;
import model.item.MeleeWeapon;

import java.util.*;

public class Inventory {
    private Map<String, Gun> guns;
    private Map<String, MeleeWeapon> meleeWeapons;

    public Inventory(){
        guns = new HashMap<>();
        meleeWeapons = new HashMap<>();
    }

    public void addGun(Gun gun){
        if(gun != null) guns.put(gun.getId(), gun);
    }

    public Gun getGun(String id){
        return guns.get(id);
    }

    public Gun[] getAllGuns(){
        return guns.values().toArray(new Gun[]{});
    }

    public void addMeleeWeapon(MeleeWeapon weapon){
        if(weapon != null) meleeWeapons.put(weapon.getId(), weapon);
    }

    public MeleeWeapon getMeleeWeapon(String id){
        return meleeWeapons.get(id);
    }

    public MeleeWeapon[] getAllMeleeWeapons(){
        return meleeWeapons.values().toArray(new MeleeWeapon[]{});
    }
}
