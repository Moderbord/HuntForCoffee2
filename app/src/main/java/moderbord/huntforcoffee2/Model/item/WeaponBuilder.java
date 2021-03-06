package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.C;

public class WeaponBuilder {
    private int quantity = 1;
    private String className = "Weapon";
    private String name = C.WEAPON_GENERIC;
    private String description = "I am your weapon!";
    private int gearLvl = 1;
    private int gearExp = 0;
    private int gearExpToLvl = 100;
    private String gearSlot = C.GEAR_SLOT_MAIN_WEP;
    private String wepType = C.WEAPON_TYPE_SWORD;
    private String dmgType = C.GEAR_TYPE_PIERCING;
    private boolean twoHanded = false;
    private int minDmg = 5;
    private int maxDmg = 10;

    public WeaponBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public WeaponBuilder setClassName(String className) {
        this.className = className;
        return this;
    }

    public WeaponBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public WeaponBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public WeaponBuilder setGearLvl(int gearLvl) {
        this.gearLvl = gearLvl;
        return this;
    }

    public WeaponBuilder setGearExp(int gearExp) {
        this.gearExp = gearExp;
        return this;
    }

    public WeaponBuilder setGearExpToLvl(int gearExpToLvl) {
        this.gearExpToLvl = gearExpToLvl;
        return this;
    }

    public WeaponBuilder setGearSlot(String gearSlot) {
        this.gearSlot = gearSlot;
        return this;
    }

    public WeaponBuilder setWepType(String wepType) {
        this.wepType = wepType;
        return this;
    }

    public WeaponBuilder setDmgType(String dmgType) {
        this.dmgType = dmgType;
        return this;
    }

    public WeaponBuilder setTwoHanded(boolean twoHanded) {
        this.twoHanded = twoHanded;
        return this;
    }

    public WeaponBuilder setMinDmg(int minDmg) {
        this.minDmg = minDmg;
        return this;
    }

    public WeaponBuilder setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
        return this;
    }

    public Weapon createWeapon() {
        return new Weapon(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, wepType, dmgType, twoHanded, minDmg, maxDmg);
    }

    public Greatsword createGreatsword(){
        return new Greatsword(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, wepType, dmgType, twoHanded, minDmg, maxDmg);
    }

    public Sword createSword(){
        return new Sword(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, wepType, dmgType, twoHanded, minDmg, maxDmg);
    }

    public Mace createMace(){
        return new Mace(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, wepType, dmgType, twoHanded, minDmg, maxDmg);
    }

    public Shield createShield(){
        return new Shield(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, wepType, dmgType, twoHanded, minDmg, maxDmg);
    }

}