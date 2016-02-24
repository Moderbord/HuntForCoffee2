package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Pizza extends Item implements Consumable {

    public Pizza() {
        name = Constants.ITEM_PIZZA_UNIQUE;
        className = "Pizza";
        addItem(1);
    }

    public Pizza(int x) {
        this();
        addItem(x - 1);
    }

    @Override
    public String consume() {
        return "Oh it's delicous";
    }

}
