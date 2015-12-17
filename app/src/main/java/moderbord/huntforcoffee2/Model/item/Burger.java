package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Burger extends Item implements Consumable{

    public Burger() {
        name = "Burger";
        addItem(1);
    }

    @Override
    public String consume() {
        return "Oh it's delicous";
    }

}
