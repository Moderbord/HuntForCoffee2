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

    @Override
    public String onEquip() {
        return "Very armour, much defence";
    }

}
