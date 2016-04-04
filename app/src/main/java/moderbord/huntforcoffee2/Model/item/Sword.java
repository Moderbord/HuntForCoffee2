package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-04-03.
 */
public class Sword extends Weapon{

    public Sword(int quantity, String className, String name, String description, int gearLvl, int gearExp, int gearExpToLvl, String gearSlot, String wepType, String dmgType, boolean twoHanded, int minDmg, int maxDmg) {
        super(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, wepType, dmgType, twoHanded, minDmg, maxDmg);
        this.className = C.WEAPON_TYPE_SWORD;
        this.gearSlot = C.GEAR_SLOT_MAIN_WEP;
        this.wepType = C.WEAPON_TYPE_SWORD;
        this.dmgType = C.GEAR_TYPE_PIERCING;
        this.twoHanded = false;
        this.minDmg = 5;
        this.maxDmg = 10;
    }
}
