package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Weapon extends Gear implements Equipable{

    private String wepType, dmgType;
    private int minDmg, maxDmg;

    public Weapon(){
        className = "Weapon";
    }

    public Weapon(int quantity, String className, String name, String description, int gearLvl,
                  int gearExp, int gearExpToLvl, String gearSlot, String wepType, String dmgType, int minDmg, int maxDmg) {
        super(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot);
        this.wepType = wepType;
        this.dmgType = dmgType;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.className = "Weapon";
    }

    @Override
    public String equip() {
        return "Very weapon, much sharp";
    }

    public String getWepType() {
        return wepType;
    }

    public void setWepType(String wepType) {
        this.wepType = wepType;
    }

    public String getDmgType() {
        return dmgType;
    }

    public void setDmgType(String dmgType) {
        this.dmgType = dmgType;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }
}
