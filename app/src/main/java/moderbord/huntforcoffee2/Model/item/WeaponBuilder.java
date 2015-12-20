package moderbord.huntforcoffee2.Model.item;

public class WeaponBuilder {
    private int quantity = 1;
    private String className = "Weapon";
    private String name = "GenericWeapon";
    private String description = "I am your weapon!";
    private int gearLvl = 1;
    private int gearExp = 0;
    private int gearExpToLvl = 100;
    private String wepType;
    private String dmgType;
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

    public WeaponBuilder setWepType(String wepType) {
        this.wepType = wepType;
        return this;
    }

    public WeaponBuilder setDmgType(String dmgType) {
        this.dmgType = dmgType;
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
        return new Weapon(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, wepType, dmgType, minDmg, maxDmg);
    }
}