package moderbord.huntforcoffee2.Model;

import moderbord.huntforcoffee2.Model.item.Armour;
import moderbord.huntforcoffee2.Model.item.Weapon;

public class EntityBuilder {
    private String eName;
    private String eGender = null;
    private String eClass = null;
    private String eRace = null;
    private String eFaction = null;
    private String eAligment = null;
    private boolean isAlly = true;
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
    private CombatStats combatStats = new CombatStats();
    private Skillset skillset = new Skillset();
    private Resistance resistance = new Resistance();
    private Inventory inventory = new Inventory();

    public EntityBuilder seteName(String eName) {
        this.eName = eName;
        return this;
    }

    public EntityBuilder seteGender(String eGender) {
        this.eGender = eGender;
        return this;
    }

    public EntityBuilder seteClass(String eClass) {
        this.eClass = eClass;
        return this;
    }

    public EntityBuilder seteRace(String eRace) {
        this.eRace = eRace;
        return this;
    }

    public EntityBuilder seteFaction(String eFaction) {
        this.eFaction = eFaction;
        return this;
    }

    public EntityBuilder seteAligment(String eAligment) {
        this.eAligment = eAligment;
        return this;
    }

    public EntityBuilder seteAlly(boolean isAlly) {
        this.isAlly = isAlly;
        return this;
    }

    public EntityBuilder seteLevel(int eLevel) {
        this.eLevel = eLevel;
        return this;
    }

    public EntityBuilder setePhysique(int ePhysique) {
        this.ePhysique = ePhysique;
        return this;
    }

    public EntityBuilder seteIntellect(int eIntellect) {
        this.eIntellect = eIntellect;
        return this;
    }

    public EntityBuilder seteAgility(int eAgility) {
        this.eAgility = eAgility;
        return this;
    }

    public EntityBuilder seteQuickness(int eQuickness) {
        this.eQuickness = eQuickness;
        return this;
    }

    public EntityBuilder seteCharisma(int eCharisma) {
        this.eCharisma = eCharisma;
        return this;
    }

    public EntityBuilder seteLuck(int eLuck) {
        this.eLuck = eLuck;
        return this;
    }

    public EntityBuilder seteLi(int eLi) {
        this.eLi = eLi;
        return this;
    }

    public EntityBuilder seteMaxHealth(int eMaxHealth) {
        this.eMaxHealth = eMaxHealth;
        return this;
    }

    public EntityBuilder seteHealth(int eHealth) {
        this.eHealth = eHealth;
        return this;
    }

    public EntityBuilder seteMaxMana(int eMaxMana) {
        this.eMaxMana = eMaxMana;
        return this;
    }

    public EntityBuilder seteMana(int eMana) {
        this.eMana = eMana;
        return this;
    }

    public EntityBuilder seteMaxFatigue(int eMaxFatigue) {
        this.eMaxFatigue = eMaxFatigue;
        return this;
    }

    public EntityBuilder seteFatigue(int eFatigue) {
        this.eFatigue = eFatigue;
        return this;
    }

    public EntityBuilder seteLu(int eLu) {
        this.eLu = eLu;
        return this;
    }

    public EntityBuilder seteMinLu(int eMinLu) {
        this.eMinLu = eMinLu;
        return this;
    }

    public EntityBuilder seteExperience(int eExperience) {
        this.eExperience = eExperience;
        return this;
    }

    public EntityBuilder seteExpToLvl(int eExpToLvl) {
        this.eExpToLvl = eExpToLvl;
        return this;
    }

    public EntityBuilder setBackWep(Weapon backWep) {
        this.backWep = backWep;
        return this;
    }

    public EntityBuilder setMainWep(Weapon mainWep) {
        this.mainWep = mainWep;
        return this;
    }

    public EntityBuilder setOffWep(Weapon offWep) {
        this.offWep = offWep;
        return this;
    }

    public EntityBuilder setArmHead(Armour armHead) {
        this.armHead = armHead;
        return this;
    }

    public EntityBuilder setArmShoulders(Armour armShoulders) {
        this.armShoulders = armShoulders;
        return this;
    }

    public EntityBuilder setArmChest(Armour armChest) {
        this.armChest = armChest;
        return this;
    }

    public EntityBuilder setArmGloves(Armour armGloves) {
        this.armGloves = armGloves;
        return this;
    }

    public EntityBuilder setArmLegs(Armour armLegs) {
        this.armLegs = armLegs;
        return this;
    }

    public EntityBuilder setArmFeet(Armour armFeet) {
        this.armFeet = armFeet;
        return this;
    }

    public EntityBuilder setCombatStats(CombatStats combatStats) {
        this.combatStats = combatStats;
        return this;
    }

    public EntityBuilder setSkillset(Skillset skillset) {
        this.skillset = skillset;
        return this;
    }

    public EntityBuilder setResistance(Resistance resistance) {
        this.resistance = resistance;
        return this;
    }

    public EntityBuilder setInventory(Inventory inventory) {
        this.inventory = inventory;
        return this;
    }

    public Entity createEntity() {
        return new Entity(eName, eGender, eClass, eRace, eFaction, eAligment, isAlly, eLevel, ePhysique, eIntellect, eAgility,
                eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue,
                eLu, eMinLu, eExperience, eExpToLvl, backWep, mainWep, offWep, armHead, armShoulders, armChest,
                armGloves, armLegs, armFeet, combatStats, skillset, resistance, inventory);
    }

    public Player createEntityPlayer() {
        return new Player(eName, eGender, eClass, eRace, eFaction, eAligment, isAlly, eLevel, ePhysique, eIntellect, eAgility,
                eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue,
                eLu, eMinLu, eExperience, eExpToLvl, backWep, mainWep, offWep, armHead, armShoulders, armChest,
                armGloves, armLegs, armFeet, combatStats, skillset, resistance, inventory);
    }

    public Jheero createEntityJheero() {
        return new Jheero(eName, eGender, eClass, eRace, eFaction, eAligment, isAlly, eLevel, ePhysique, eIntellect, eAgility,
                eQuickness, eCharisma, eLuck, eLi, eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue,
                eLu, eMinLu, eExperience, eExpToLvl, backWep, mainWep, offWep, armHead, armShoulders, armChest,
                armGloves, armLegs, armFeet, combatStats, skillset, resistance, inventory);
    }
}