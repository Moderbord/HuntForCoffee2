package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Gear extends Item {

    protected int gearLvl, gearExp, gearExpToLvl;

    public Gear(){}

    public Gear(int quantity, String className, String name, String description, int gearLvl, int gearExp, int gearExpToLvl) {
        super(quantity, className, name, description);
        this.gearLvl = gearLvl;
        this.gearExp = gearExp;
        this.gearExpToLvl = gearExpToLvl;
    }

    public int getGearLvl() {
        return gearLvl;
    }

    public void setGearLvl(int gearLvl) {
        this.gearLvl = gearLvl;
    }

    public int getGearExp() {
        return gearExp;
    }

    public void setGearExp(int gearExp) {
        this.gearExp = gearExp;
    }

    public int getGearExpToLvl() {
        return gearExpToLvl;
    }

    public void setGearExpToLvl(int gearExpToLvl) {
        this.gearExpToLvl = gearExpToLvl;
    }
}