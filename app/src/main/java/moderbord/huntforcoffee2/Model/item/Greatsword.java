package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-04-03.
 */
public class Greatsword extends Weapon {

    public Greatsword(int quantity, String className, String name, String description,
                      int gearLvl, int gearExp, int gearExpToLvl, String gearSlot,
                      String wepType, String dmgType, boolean twoHanded, int minDmg,
                      int maxDmg) {
        super(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl,
                gearSlot, wepType, dmgType, twoHanded, minDmg, maxDmg);
        this.className = C.WEAPON_TYPE_GREATSWORD;
        this.gearSlot = C.GEAR_SLOT_MAIN_WEP;
        this.wepType = C.WEAPON_TYPE_GREATSWORD;
        this.dmgType = C.GEAR_TYPE_CLEAVING; // TODO Add dmgSource physical and refactor from GEAR_TYPE
        this.twoHanded = true;
        this.minDmg = 8;
        this.maxDmg = 18;
    }
}
