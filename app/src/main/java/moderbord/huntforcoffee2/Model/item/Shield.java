package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-04-03.
 */
public class Shield extends Weapon {

    private String armClass, armStrong, armWeak;
    private int armDef;

    public Shield(int quantity, String className, String name, String description,
                  int gearLvl, int gearExp, int gearExpToLvl, String gearSlot,
                  String wepType, String dmgType, boolean twoHanded, int minDmg,
                  int maxDmg) {
        super(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl,
                gearSlot, wepType, dmgType, twoHanded, minDmg, maxDmg);
        this.className = C.WEAPON_TYPE_SHIELD;
        this.gearSlot = C.GEAR_SLOT_OFF_WEP;
        this.wepType = C.WEAPON_TYPE_SHIELD;
        this.twoHanded = false;
        this.minDmg = 0;
        this.maxDmg = 0;
        this.armClass = C.ARMOUR_CLASS_MEDIUM;
        this.armStrong = C.GEAR_TYPE_PIERCING;
        this.armWeak = C.GEAR_TYPE_CRUSHING;
        this.armDef = 8;
    }

    @Override
    public String itemInformation(){
        return "Name: " + this.name + "\nType: " + this.armClass + "\nSlot: " + this.gearSlot
                + "\nDefence " + this.armDef + "\nStrong: " + this.armStrong + "\nWeak: " + this.armWeak
                + "\n\nLevel: " + this.gearLvl + "\nExp: " + this.gearExp + "\n\n" +
                this.description;
    }

    public String getArmClass() {
        return armClass;
    }

    public void setArmClass(String armClass) {
        this.armClass = armClass;
    }

    public String getArmStrong() {
        return armStrong;
    }

    public void setArmStrong(String armStrong) {
        this.armStrong = armStrong;
    }

    public String getArmWeak() {
        return armWeak;
    }

    public void setArmWeak(String armWeak) {
        this.armWeak = armWeak;
    }

    public int getArmDef() {
        return armDef;
    }

    public void setArmDef(int armDef) {
        this.armDef = armDef;
    }
}
