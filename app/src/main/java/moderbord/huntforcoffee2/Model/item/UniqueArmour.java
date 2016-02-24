package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2015-12-20.
 */

public class UniqueArmour extends Armour {

    public UniqueArmour(int quantity, String className, String name, String description, int gearLvl,
                        int gearExp, int gearExpToLvl, String gearSlot, String armClass, String armStrong, String armWeak, int armDef) {
        super(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, armClass, armStrong,
                armWeak, armDef);
        this.className = "UniqueArmour";
        this.name = Constants.ARMOUR_WARDEN;
        this.description = "This is the armour for complete nerds who's programming until 8 AM";
        this.armClass = Constants.ARMOUR_CLASS_HEAVY;
        this.armDef = 132;
        this.armWeak = Constants.GEAR_TYPE_MAGIC;
        this.gearSlot = Constants.GEAR_SLOT_CHEST;
        this.armStrong = Constants.GEAR_TYPE_PHYSICAL;
    }

    @Override
    public String equip() {
        return "The Warden armour fits your nerdy face super well. It really brings out " +
                "the blue in your eyes";
    }
}
