package moderbord.huntforcoffee2.Model;

import com.google.gson.Gson;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class Entity {

    private String eName, eGender, eClass, eRace, eFaction;
    private int eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl;
    private Weapon backWep, mainWep, offWep;
    private Armour armHead, armShoulders, armChest, armGloves, armLegs, armFeet;
    private Resistance resistance;
    private Inventory inventory;

    public Entity(String eName, String eGender, String eClass, String eRace, String eFaction, int eLevel, int ePhysique, int eIntellect, int eAgility, int eQuickness, int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth, int eMaxMana, int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience, int eExpToLvl, Weapon backWep, Weapon mainWep, Weapon offWep, Armour armHead, Armour armShoulders, Armour armChest, Armour armGloves, Armour armLegs, Armour armFeet, Resistance resistance, Inventory inventory) {
        this.eName = eName;
        this.eGender = eGender;
        this.eClass = eClass;
        this.eRace = eRace;
        this.eFaction = eFaction;
        this.eLevel = eLevel;
        this.ePhysique = ePhysique;
        this.eIntellect = eIntellect;
        this.eAgility = eAgility;
        this.eQuickness = eQuickness;
        this.eCharisma = eCharisma;
        this.eLuck = eLuck;
        this.eLi = eLi;
        this.eMaxHealth = eMaxHealth;
        this.eHealth = eHealth;
        this.eMaxMana = eMaxMana;
        this.eMana = eMana;
        this.eMaxFatigue = eMaxFatigue;
        this.eFatigue = eFatigue;
        this.eLu = eLu;
        this.eMinLu = eMinLu;
        this.eExperience = eExperience;
        this.eExpToLvl = eExpToLvl;
        this.backWep = backWep;
        this.mainWep = mainWep;
        this.offWep = offWep;
        this.armHead = armHead;
        this.armShoulders = armShoulders;
        this.armChest = armChest;
        this.armGloves = armGloves;
        this.armLegs = armLegs;
        this.armFeet = armFeet;
        this.resistance = resistance;
        this.inventory = inventory;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String geteName() {
        return eName;
    }
}
