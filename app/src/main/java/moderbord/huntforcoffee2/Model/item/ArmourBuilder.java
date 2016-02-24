package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.Constants;

public class ArmourBuilder {
    private int quantity = 1;
    private String className = "Armour";
    private String name = Constants.ARMOUR_GENERIC;
    private String description = "I am your armor!";
    private int gearLvl = 1;
    private int gearExp = 0;
    private int gearExpToLvl = 100;
    private String gearSlot;
    private String armClass = Constants.ARMOUR_CLASS_MEDIUM;
    private String armStrong = Constants.GEAR_TYPE_MAGIC;
    private String armWeak = Constants.GEAR_TYPE_PIERCING;
    private int armDef = 10;

    public ArmourBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ArmourBuilder setClassName(String className) {
        this.className = className;
        return this;
    }

    public ArmourBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ArmourBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArmourBuilder setGearLvl(int gearLvl) {
        this.gearLvl = gearLvl;
        return this;
    }

    public ArmourBuilder setGearExp(int gearExp) {
        this.gearExp = gearExp;
        return this;
    }

    public ArmourBuilder setGearExpToLvl(int gearExpToLvl) {
        this.gearExpToLvl = gearExpToLvl;
        return this;
    }

    public ArmourBuilder setGearSlot(String gearSlot) {
        this.gearSlot = gearSlot;
        return this;
    }

    public ArmourBuilder setArmClass(String armClass) {
        this.armClass = armClass;
        return this;
    }

    public ArmourBuilder setArmStrong(String armStrong) {
        this.armStrong = armStrong;
        return this;
    }

    public ArmourBuilder setArmWeak(String armWeak) {
        this.armWeak = armWeak;
        return this;
    }

    public ArmourBuilder setArmDef(int armDef) {
        this.armDef = armDef;
        return this;
    }

    public Armour createArmour() {
        return new Armour(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, armClass, armStrong, armWeak, armDef);
    }

    public UniqueArmour createUniqueArmour() {
        return new UniqueArmour(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot, armClass, armStrong, armWeak, armDef);
    }
}