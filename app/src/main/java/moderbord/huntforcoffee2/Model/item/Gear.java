package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Gear extends Item {

    protected int gearLvl, gearExp, gearExpToLvl;

    public Gear(){

    }

    public Gear(int gearLvl, int gearExp, int gearExpToLvl) {
        this.gearLvl = gearLvl;
        this.gearExp = gearExp;
        this.gearExpToLvl = gearExpToLvl;
    }

}