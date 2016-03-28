package moderbord.huntforcoffee2.Model;

import moderbord.huntforcoffee2.Model.item.ArmourBuilder;
import moderbord.huntforcoffee2.Model.item.IronBar;
import moderbord.huntforcoffee2.Model.item.SuperMeal;
import moderbord.huntforcoffee2.Model.item.UniqueArmour;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2015-12-20.
 */
public class Recipes {

    private static Recipes instance;

    public static Recipes getInstance() {
        if (instance == null) {
            instance = new Recipes();
        }
        return instance;
    }

    public void stirThePot(Entity e, String toCreate) {// TODO make a failed message?
        switch (toCreate) {                            // TODO compare against Item instead of String?
            case C.RECIPE_PIZZA_UNIQUE:
                if (e.getInventory().hasItemQty(C.ITEM_BURGER, 2) && e.getInventory().hasItemQty(C.ITEM_PIZZA_UNIQUE, 1)) {
                    e.getInventory().add(new SuperMeal());
                    e.getInventory().itemByName(C.ITEM_BURGER).subtractItem(2);
                    e.getInventory().itemByName(C.ITEM_PIZZA_UNIQUE).subtractItem(1);
                }
                break;
            case C.RECIPE_IRON_BAR:
                if (e.getInventory().hasItemQty(C.ITEM_IRON_ORE, 2)) {
                    e.getInventory().add(new IronBar());
                    e.getInventory().itemByName(C.ITEM_IRON_ORE).subtractItem(2);
                }
                break;
            case C.RECIPE_ARMOUR_WARDEN:
                if (e.getInventory().hasItemQty(C.ITEM_IRON_BAR, 4)) {
                    UniqueArmour uniqueArmour = new ArmourBuilder().createUniqueArmour();
                    e.getInventory().add(uniqueArmour);
                    e.getInventory().itemByName(C.ITEM_IRON_BAR).subtractItem(4);
                }
                break;
            default:
        }
    }

}
