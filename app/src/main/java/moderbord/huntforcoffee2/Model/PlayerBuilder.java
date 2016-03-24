package moderbord.huntforcoffee2.Model;

import moderbord.huntforcoffee2.Model.item.Armour;
import moderbord.huntforcoffee2.Model.item.Weapon;

public class PlayerBuilder {    // Redundant?
    private String eName;
    private String eGender = null;
    private String eClass = null;
    private String eRace = null;
    private String eFaction = null;
    private int eLevel = 0;
    private int ePhysique = 0;
    private int eIntellect = 0;
    private int eAgility = 0;
    private int eQuickness = 0;
    private int eCharisma = 0;
    private int eLuck = 0;
    private int eLi = 0;
    private int eMaxHealth = 0;
    private int eHealth = 0;
    private int eMaxMana = 0;
    private int eMana = 0;
    private int eMaxFatigue = 0;
    private int eFatigue = 0;
    private int eLu = 0;
    private int eMinLu = 0;
    private int eExperience = 0;
    private int eExpToLvl = 0;
    private Weapon backWep = new Weapon();
    private Weapon mainWep = new Weapon();
    private Weapon offWep = new Weapon();
    private Armour armHead = new Armour();
    private Armour armShoulders = new Armour();
    private Armour armChest = new Armour();
    private Armour armGloves = new Armour();
    private Armour armLegs = new Armour();
    private Armour armFeet = new Armour();
    private Resistance resistance = new Resistance();
    private Inventory inventory = new Inventory();

    public PlayerBuilder seteName(String eName) {
        this.eName = eName;
        return this;
    }

    public PlayerBuilder seteGender(String eGender) {
        this.eGender = eGender;
        return this;
    }

    public PlayerBuilder seteClass(String eClass) {
        this.eClass = eClass;
        return this;
    }

    public PlayerBuilder seteRace(String eRace) {
        this.eRace = eRace;
        return this;
    }

    public PlayerBuilder seteFaction(String eFaction) {
        this.eFaction = eFaction;
        return this;
    }

    public PlayerBuilder seteLevel(int eLevel) {
        this.eLevel = eLevel;
        return this;
    }

    public PlayerBuilder setePhysique(int ePhysique) {
        this.ePhysique = ePhysique;
        return this;
    }

    public PlayerBuilder seteIntellect(int eIntellect) {
        this.eIntellect = eIntellect;
        return this;
    }

    public PlayerBuilder seteAgility(int eAgility) {
        this.eAgility = eAgility;
        return this;
    }

    public PlayerBuilder seteQuickness(int eQuickness) {
        this.eQuickness = eQuickness;
        return this;
    }

    public PlayerBuilder seteCharisma(int eCharisma) {
        this.eCharisma = eCharisma;
        return this;
    }

    public PlayerBuilder seteLuck(int eLuck) {
        this.eLuck = eLuck;
        return this;
    }

    public PlayerBuilder seteLi(int eLi) {
        this.eLi = eLi;
        return this;
    }

    public PlayerBuilder seteMaxHealth(int eMaxHealth) {
        this.eMaxHealth = eMaxHealth;
        return this;
    }

    public PlayerBuilder seteHealth(int eHealth) {
        this.eHealth = eHealth;
        return this;
    }

    public PlayerBuilder seteMaxMana(int eMaxMana) {
        this.eMaxMana = eMaxMana;
        return this;
    }

    public PlayerBuilder seteMana(int eMana) {
        this.eMana = eMana;
        return this;
    }

    public PlayerBuilder seteMaxFatigue(int eMaxFatigue) {
        this.eMaxFatigue = eMaxFatigue;
        return this;
    }

    public PlayerBuilder seteFatigue(int eFatigue) {
        this.eFatigue = eFatigue;
        return this;
    }

    public PlayerBuilder seteLu(int eLu) {
        this.eLu = eLu;
        return this;
    }

    public PlayerBuilder seteMinLu(int eMinLu) {
        this.eMinLu = eMinLu;
        return this;
    }

    public PlayerBuilder seteExperience(int eExperience) {
        this.eExperience = eExperience;
        return this;
    }

    public PlayerBuilder seteExpToLvl(int eExpToLvl) {
        this.eExpToLvl = eExpToLvl;
        return this;
    }

    public PlayerBuilder setBackWep(Weapon backWep) {
        this.backWep = backWep;
        return this;
    }

    public PlayerBuilder setMainWep(Weapon mainWep) {
        this.mainWep = mainWep;
        return this;
    }

    public PlayerBuilder setOffWep(Weapon offWep) {
        this.offWep = offWep;
        return this;
    }

    public PlayerBuilder setArmHead(Armour armHead) {
        this.armHead = armHead;
        return this;
    }

    public PlayerBuilder setArmShoulders(Armour armShoulders) {
        this.armShoulders = armShoulders;
        return this;
    }

    public PlayerBuilder setArmChest(Armour armChest) {
        this.armChest = armChest;
        return this;
    }

    public PlayerBuilder setArmGloves(Armour armGloves) {
        this.armGloves = armGloves;
        return this;
    }

    public PlayerBuilder setArmLegs(Armour armLegs) {
        this.armLegs = armLegs;
        return this;
    }

    public PlayerBuilder setArmFeet(Armour armFeet) {
        this.armFeet = armFeet;
        return this;
    }

    public PlayerBuilder setResistance(Resistance resistance) {
        this.resistance = resistance;
        return this;
    }

    public PlayerBuilder setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }

    /*
    public Player createPlayer() {
        return new Player(eName, eGender, eClass, eRace, eFaction, eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl, backWep, mainWep, offWep, armHead, armShoulders, armChest, armGloves, armLegs, armFeet, resistance, inventory);
    }
    */

}