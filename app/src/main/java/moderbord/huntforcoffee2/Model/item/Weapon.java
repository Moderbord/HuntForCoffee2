package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Weapon extends Gear implements Equipable {

    protected String wepType, dmgType;
    protected boolean twoHanded;
    protected int minDmg, maxDmg;

    public Weapon() {
        className = "Weapon";
    }

    public Weapon(int quantity, String className, String name, String description, int gearLvl,
                  int gearExp, int gearExpToLvl, String gearSlot, String wepType, String dmgType,
                  boolean twoHanded, int minDmg, int maxDmg) {
        super(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, gearSlot);
        this.wepType = wepType;
        this.dmgType = dmgType;
        this.twoHanded = twoHanded;
        this.minDmg = minDmg;
        this.maxDmg = maxDmg;
        this.className = "Weapon";
    }

    @Override
    public String equip() {
        return "Very weapon, much sharp";
    }

    @Override
    public String itemInformation(){
        String twoHanded = (this.twoHanded) ? "Yes" : "No";
        return "Name: " + this.name + "\nType: " + this.wepType + "\nTwo Handed: " + twoHanded
                + "\nDamage: " + this.minDmg + " - " + this.maxDmg + "\nSource: " + this.dmgType
                + "\n\nLevel: " + this.gearLvl + "\nExp: " + this.gearExp + "\n\n" +
                this.description;
    }

    public boolean isWeapon(){
        boolean isWeapon = (name != null && maxDmg != 0);
        return isWeapon;
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

    public boolean isTwoHanded() {
        return twoHanded;
    }

    public void setTwoHanded(boolean twoHanded) {
        this.twoHanded = twoHanded;
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
