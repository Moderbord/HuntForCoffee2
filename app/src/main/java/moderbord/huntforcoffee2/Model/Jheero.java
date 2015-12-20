package moderbord.huntforcoffee2.Model;

import android.util.Log;
import moderbord.huntforcoffee2.Model.item.Armour;
import moderbord.huntforcoffee2.Model.item.Consumable;
import moderbord.huntforcoffee2.Model.item.Gear;
import moderbord.huntforcoffee2.Model.item.Item;
import moderbord.huntforcoffee2.Model.item.Weapon;

/**
 * Created by Moderbord on 2015-12-20.
 */
public class Jheero extends Entity {

    public Jheero(String eName, String eGender, String eClass, String eRace, String eFaction, int eLevel, int ePhysique, int eIntellect, int eAgility, int eQuickness, int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth, int eMaxMana, int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience, int eExpToLvl, Weapon backWep, Weapon mainWep, Weapon offWep, Armour armHead, Armour armShoulders, Armour armChest, Armour armGloves, Armour armLegs, Armour armFeet, Resistance resistance, Inventory inventory) {
        super(eName, eGender, eClass, eRace, eFaction, eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl, backWep, mainWep, offWep, armHead, armShoulders, armChest, armGloves, armLegs, armFeet, resistance, inventory);
        this.eName = "Jheero";
        this.eGender = "Male";
        this.eClass = "Warrior";
        this.eLevel = 5;
    }


    public void consumeItem(Item i){
        if(i instanceof Consumable) {
            Log.d("Jheero", ((Consumable) i).consume());
            i.subtractItem(1);
            inventory.notifyDataSetChanged();
        } else {
            Log.d("Jheero", "Jheero is hungry!");
        }
    }

    public void equipGear(Gear g){
        if(g instanceof Weapon) {

            if(this.mainWep.getName() != null){     // Save current weapon to inventory
                this.getInventory().add((this).mainWep);
            }

            Log.d("Jheero", ((Weapon) g).equip());  // Equip new weapon
            this.mainWep = (Weapon)g;
            this.getInventory().remove(g);

        } else if(g instanceof Armour){

            if(this.armChest.getName() != null){    // Save current armour to inventory
                this.getInventory().add((this).armChest);
            }

            Log.d("Jheero", ((Armour) g).equip());  // Equip new armour
            this.armChest = (Armour)g;
            this.getInventory().remove(g);

        } else {
            Log.d("Jheero", "That's no weapon");
        }
    }


}