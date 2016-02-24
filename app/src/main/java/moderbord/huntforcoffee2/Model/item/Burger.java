package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Burger extends Item implements Consumable {

    public Burger() {
        name = Constants.ITEM_BURGER;
        className = "Burger";
        addItem(1);
    }

    public Burger(int x) {
        this();
        addItem(x - 1);
    }

    @Override
    public String consume() {
        return "Oh it's delicous";
    }

}
