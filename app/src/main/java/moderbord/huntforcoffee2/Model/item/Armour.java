package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Armour extends Gear implements Equipable{

    protected String armClass, armStrong, armWeak;
    protected int armDef;

    public Armour(){
        className = "Armour";
    }

    public Armour(int quantity, String className, String name, String description, int gearLvl, int gearExp, int gearExpToLvl, String armClass, String armStrong, String armWeak, int armDef) {
        super(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl);
        this.armClass = armClass;
        this.armStrong = armStrong;
        this.armWeak = armWeak;
        this.armDef = armDef;
    }

    @Override
    public String equip() {
        return "Very armour, much defence";
    }

    public String getArmClass() {
        return armClass;
    }

    public void setArmClass(String armClass) {
        this.armClass = armClass;
    }

    public String getArmStrong() {
        return armStrong;
    }

    public void setArmStrong(String armStrong) {
        this.armStrong = armStrong;
    }

    public String getArmWeak() {
        return armWeak;
    }

    public void setArmWeak(String armWeak) {
        this.armWeak = armWeak;
    }

    public int getArmDef() {
        return armDef;
    }

    public void setArmDef(int armDef) {
        this.armDef = armDef;
    }
}