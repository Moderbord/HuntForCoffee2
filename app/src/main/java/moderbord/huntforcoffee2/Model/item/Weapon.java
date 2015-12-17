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

    @Override
    public String onEquip() {
        return "Very weapon, much sharp";
    }
}
