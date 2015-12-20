package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-20.
 */
public class UniqueArmour extends Armour {

    public UniqueArmour(int quantity, String className, String name, String description, int gearLvl, int gearExp, int gearExpToLvl, String armClass, String armStrong, String armWeak, int armDef) {
        super(quantity, className, name, description, gearLvl, gearExp, gearExpToLvl, armClass, armStrong, armWeak, armDef);
        this.className = "UniqueArmour";
        this.name = "Warden";
        this.description = "This is the armour for complete nerds who's programming until 8 AM";
        this.armClass = "Heavy";
        this.armDef = 132;
        this.armWeak = "Magic";
        this.armStrong = "Physical";
    }

}
