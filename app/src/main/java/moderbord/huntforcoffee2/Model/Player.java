package moderbord.huntforcoffee2.Model;

import android.util.Log;

import moderbord.huntforcoffee2.Model.item.Armour;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Model.item.Consumable;
import moderbord.huntforcoffee2.Model.item.Item;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class Player extends Entity {

    public Player(String eName, String eGender, String eClass, String eRace, String eFaction, int eLevel, int ePhysique, int eIntellect, int eAgility, int eQuickness, int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth, int eMaxMana, int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience, int eExpToLvl, Weapon backWep, Weapon mainWep, Weapon offWep, Armour armHead, Armour armShoulders, Armour armChest, Armour armGloves, Armour armLegs, Armour armFeet, Resistance resistance, Inventory inventory) {
        super(eName, eGender, eClass, eRace, eFaction, eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl, backWep, mainWep, offWep, armHead, armShoulders, armChest, armGloves, armLegs, armFeet, resistance, inventory);
    }

    public void consumeItem(Item i){
        if(i instanceof Consumable) {
            Log.d("Inventory", ((Consumable) i).consume());
            i.removeItem(1);
            inventory.notifyDataSetChanged();
        } else {
            Log.d("Player", "I am beaitafjoidf");
        }
    }

}
