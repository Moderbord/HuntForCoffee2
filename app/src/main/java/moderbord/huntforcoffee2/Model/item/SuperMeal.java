package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class SuperMeal extends Consumable {

    public SuperMeal() {
        name = Constants.ITEM_SUPERMEAL;
        className = "SuperMeal";
        addItem(1);
    }

    public SuperMeal(int x) {
        this();
        addItem(x - 1);
    }

    @Override
    public String consume() {
        return "It's too much to eat!";
    }

}
