package moderbord.huntforcoffee2.Model;

import android.util.Log;

import com.google.gson.Gson;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.item.Armour;
import moderbord.huntforcoffee2.Model.item.Consumable;
import moderbord.huntforcoffee2.Model.item.Item;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class Entity {

    protected String eName, eGender, eClass, eRace, eFaction, eAlignment;
    protected boolean isAlly;
    protected int eLevel, ePhysique, eIntellect, eAgility, eQuickness, eCharisma, eLuck, eLi,
            eMaxHealth, eHealth, eMaxMana, eMana, eMaxFatigue, eFatigue, eLu, eMinLu, eExperience, eExpToLvl;
    protected Weapon backWep, mainWep, offWep;
    protected Armour armHead, armShoulders, armChest, armGloves, armLegs, armFeet;
    protected CombatStats combatStats;
    protected Skillset skillset;
    protected Resistance resistance;
    protected Inventory inventory;

    public Entity(String eName, String eGender, String eClass, String eRace, String eFaction,
                  String eAlignment, boolean isAlly, int eLevel, int ePhysique, int eIntellect, int eAgility, int eQuickness,
                  int eCharisma, int eLuck, int eLi, int eMaxHealth, int eHealth, int eMaxMana,
                  int eMana, int eMaxFatigue, int eFatigue, int eLu, int eMinLu, int eExperience,
                  int eExpToLvl, Weapon backWep, Weapon mainWep, Weapon offWep, Armour armHead,
                  Armour armShoulders, Armour armChest, Armour armGloves, Armour armLegs, Armour armFeet,
                  CombatStats combatStats, Skillset skillset, Resistance resistance, Inventory inventory) {
        this.eName = eName;
        this.eGender = eGender;
        this.eClass = eClass;
        this.eRace = eRace;
        this.eFaction = eFaction;
        this.eAlignment = eAlignment;
        this.isAlly = isAlly;
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
        this.combatStats = combatStats;
        this.skillset = skillset;
        this.resistance = resistance;
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Entity returnMe() {
        return this;
    }

    public void consumeItem(Item i) {
        if (i instanceof Consumable) {
            Log.d(this.eName, ((Consumable) i).consume());
            i.subtractItem(1);
            inventory.updateInventoryData();
        } else {
            Log.d(this.eName, "I am hungry!");
        }
    }

    public void combineItem(String toCreate) {
        EventController.recipes.stirThePot(this, toCreate);
        inventory.updateInventoryData();
    }

    public void equipArmour(Item i) {
        Armour a = (Armour) this.inventory.gearByObject(i);
        switch (a.getGearSlot()) {

            case C.GEAR_SLOT_HEAD:
                if (this.armHead.getName() != null) {                       // Save current armour to inventory
                    this.getInventory().add((this).armHead);
                }
                this.armHead = a;                                  // Equips new armour..
                break;

            case C.GEAR_SLOT_SHOULDERS:
                if (this.armShoulders.getName() != null) {
                    this.getInventory().add((this).armShoulders);
                }
                this.armShoulders = a;
                break;

            case C.GEAR_SLOT_CHEST:
                if (this.armChest.getName() != null) {
                    this.getInventory().add((this).armChest);
                }
                this.armChest = a;
                break;

            case C.GEAR_SLOT_GLOVES:
                if (this.armGloves.getName() != null) {
                    this.getInventory().add((this).armGloves);
                }
                this.armGloves = a;
                break;

            case C.GEAR_SLOT_LEGS:
                if (this.armLegs.getName() != null) {
                    this.getInventory().add((this).armLegs);
                }
                this.armLegs = a;
                break;

            case C.GEAR_SLOT_FEET:
                if (this.armFeet.getName() != null) {
                    this.getInventory().add((this).armFeet);
                }
                this.armFeet = a;
                break;

            default:
                Log.d(this.eName, "Could not equip armour");
        }

        Log.d(this.eName, (a).equip());
        this.getInventory().remove(a);                                      // ..and removes it from inventory
    }

    /**
     * Equips a weapon to the entity in question
     * @param i The item (weapon) that is to be equipped
     * @param offHand Set to true if the item is to be equipped in off-hand slot
     */
    public void equipWeapon(Item i, boolean offHand) {
        Weapon w = (Weapon) this.inventory.gearByObject(i);
        if (offHand) {
            equipOffWeapon(w);
        } else {
            switch (w.getGearSlot()) {

                case C.GEAR_SLOT_MAIN_WEP:
                    if (w.isTwoHanded() && this.offWep.getName() != null) {     // If weapon requires two hands and entity is currently wielding an offhand weapon
                        this.getInventory().add((this).offWep);
                        this.offWep = new Weapon();                             // Adds a "clean" weapon
                    }
                    if (this.mainWep.getName() != null) {                       // Save current weapon to inventory
                        this.getInventory().add((this).mainWep);
                    }
                    this.mainWep = w;                       // Equip new weapon..
                    break;

                case C.GEAR_SLOT_BACK_WEP:
                    if (this.backWep.getName() != null) {
                        this.getInventory().add((this).backWep);
                    }
                    this.backWep = w;                               // Equip new weapon..
                    break;

                default:
                    Log.d(this.eName, "Could not equip weapon");
            }
        }
        Log.d(this.eName, (w).equip());
        this.getInventory().remove(w);                           // ..and remove it from inventory
    }

    private void equipOffWeapon(Weapon w) {
        if (this.mainWep.isTwoHanded()) {                       // If previous weapon required two hands it is removed
            this.getInventory().add((this).mainWep);
            this.mainWep = new Weapon();
        }
        if (this.offWep.getName() != null) {                    // Save current weapon to inventory
            this.getInventory().add((this).offWep);
        }
        this.offWep = w;                                // Equip new offhand weapon..

        //Log.d(this.eName, (w).equip());
        //this.getInventory().remove(w);                  // ..and remove it from inventory
    }

    public boolean isDualWielding(){
        boolean dualWielding = (mainWep != null && offWep != null);
        return dualWielding;
    }

    public void receiveItem(Item i){
        inventory.add(i);
    }

    public void corrHealth(){
        if (eHealth > eMaxHealth){
            eHealth = eMaxHealth;
        }
    }

    public void corrMana(){
        if (eMana > eMaxMana){
            eMana = eMaxMana;
        }
    }

    public void corrFatique(){
        if (eFatigue > eMaxFatigue){
            eFatigue = eMaxFatigue;
        }
    }

    public void damaged (int dmg){
        eHealth -= dmg;
        if (eHealth <= 0){
            eHealth = 0;
            this.combatStats.setIsDefeated(true);
            this.combatStats.setIsDown(false);
            this.combatStats.setIsActive(false);
        }
    }

    public void healed (int heal){
        eHealth += heal;
        corrHealth();
    }

    public String heShe(){
        String heshe = eGender.equals(C.GENDER_FEMALE) ? "she" : "he";
        return heshe;
    }

    public String hisHer(){
        String hisHer = eGender.equals(C.GENDER_FEMALE) ? "her" : "his";
        return hisHer;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteGender() {
        return eGender;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender;
    }

    public String geteClass() {
        return eClass;
    }

    public void seteClass(String eClass) {
        this.eClass = eClass;
    }

    public String geteRace() {
        return eRace;
    }

    public void seteRace(String eRace) {
        this.eRace = eRace;
    }

    public String geteFaction() {
        return eFaction;
    }

    public void seteFaction(String eFaction) {
        this.eFaction = eFaction;
    }

    public String geteAlignment() {
        return eAlignment;
    }

    public void seteAlignment(String eAlignment) {
        this.eAlignment = eAlignment;
    }

    public boolean isAlly() {
        return isAlly;
    }

    public void setAlly(boolean ally) {
        isAlly = ally;
    }

    public int geteLevel() {
        return eLevel;
    }

    public void seteLevel(int eLevel) {
        this.eLevel = eLevel;
    }

    public int getePhysique() {
        return ePhysique;
    }

    public void setePhysique(int ePhysique) {
        this.ePhysique = ePhysique;
    }

    public int geteIntellect() {
        return eIntellect;
    }

    public void seteIntellect(int eIntellect) {
        this.eIntellect = eIntellect;
    }

    public int geteAgility() {
        return eAgility;
    }

    public void seteAgility(int eAgility) {
        this.eAgility = eAgility;
    }

    public int geteQuickness() {
        return eQuickness;
    }

    public void seteQuickness(int eQuickness) {
        this.eQuickness = eQuickness;
    }

    public int geteCharisma() {
        return eCharisma;
    }

    public void seteCharisma(int eCharisma) {
        this.eCharisma = eCharisma;
    }

    public int geteLuck() {
        return eLuck;
    }

    public void seteLuck(int eLuck) {
        this.eLuck = eLuck;
    }

    public int geteLi() {
        return eLi;
    }

    public void seteLi(int eLi) {
        this.eLi = eLi;
    }

    public int geteMaxHealth() {
        return eMaxHealth;
    }

    public void seteMaxHealth(int eMaxHealth) {
        this.eMaxHealth = eMaxHealth;
    }

    public int geteHealth() {
        return eHealth;
    }

    public void seteHealth(int eHealth) {
        this.eHealth = eHealth;
    }

    public int geteMaxMana() {
        return eMaxMana;
    }

    public void seteMaxMana(int eMaxMana) {
        this.eMaxMana = eMaxMana;
    }

    public int geteMana() {
        return eMana;
    }

    public void seteMana(int eMana) {
        this.eMana = eMana;
    }

    public int geteMaxFatigue() {
        return eMaxFatigue;
    }

    public void seteMaxFatigue(int eMaxFatigue) {
        this.eMaxFatigue = eMaxFatigue;
    }

    public int geteFatigue() {
        return eFatigue;
    }

    public void seteFatigue(int eFatigue) {
        this.eFatigue = eFatigue;
    }

    public int geteLu() {
        return eLu;
    }

    public void seteLu(int eLu) {
        this.eLu = eLu;
    }

    public int geteMinLu() {
        return eMinLu;
    }

    public void seteMinLu(int eMinLu) {
        this.eMinLu = eMinLu;
    }

    public int geteExperience() {
        return eExperience;
    }

    public void seteExperience(int eExperience) {
        this.eExperience = eExperience;
    }

    public int geteExpToLvl() {
        return eExpToLvl;
    }

    public void seteExpToLvl(int eExpToLvl) {
        this.eExpToLvl = eExpToLvl;
    }

    public Weapon getBackWep() {
        return backWep;
    }

    public void setBackWep(Weapon backWep) {
        this.backWep = backWep;
    }

    public Weapon getMainWep() {
        return mainWep;
    }

    public void setMainWep(Weapon mainWep) {
        this.mainWep = mainWep;
    }

    public Weapon getOffWep() {
        return offWep;
    }

    public void setOffWep(Weapon offWep) {
        this.offWep = offWep;
    }

    public Armour getArmHead() {
        return armHead;
    }

    public void setArmHead(Armour armHead) {
        this.armHead = armHead;
    }

    public Armour getArmShoulders() {
        return armShoulders;
    }

    public void setArmShoulders(Armour armShoulders) {
        this.armShoulders = armShoulders;
    }

    public Armour getArmChest() {
        return armChest;
    }

    public void setArmChest(Armour armChest) {
        this.armChest = armChest;
    }

    public Armour getArmGloves() {
        return armGloves;
    }

    public void setArmGloves(Armour armGloves) {
        this.armGloves = armGloves;
    }

    public Armour getArmLegs() {
        return armLegs;
    }

    public void setArmLegs(Armour armLegs) {
        this.armLegs = armLegs;
    }

    public Armour getArmFeet() {
        return armFeet;
    }

    public void setArmFeet(Armour armFeet) {
        this.armFeet = armFeet;
    }

    public CombatStats getCombatStats() {
        return combatStats;
    }

    public void setCombatStats(CombatStats combatStats) {
        this.combatStats = combatStats;
    }

    public Skillset getSkillset() {
        return skillset;
    }

    public void setSkillset(Skillset skillset) {
        this.skillset = skillset;
    }

    public Resistance getResistance() {
        return resistance;
    }

    public void setResistance(Resistance resistance) {
        this.resistance = resistance;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
