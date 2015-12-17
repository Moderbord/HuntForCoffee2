package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Burger extends Item implements Consumable {

    public Burger() {
        className = "Burger";
        addItem(1);
    }

    public Burger(int x) {
        name = "Burger";
        addItem(x);
    }

    @Override
    public String consume() {
        return "Oh it's delicous";
    }

}
