package moderbord.huntforcoffee2.Model;

import moderbord.huntforcoffee2.Model.item.SuperMeal;

/**
 * Created by Moderbord on 2015-12-20.
 */
public class Recipes{

    public void stirThePot(Inventory inventory, String toCreate) {
        switch (toCreate){
            case "SuperMeal":
                if(inventory.hasItemQty("Burger", 2) && inventory.hasItemQty("Unique pizza", 1)){
                    inventory.add(new SuperMeal());
                    inventory.itemByName("Burger").subtractItem(2);
                    inventory.itemByName("Unique pizza").subtractItem(1);
                }
                break;
            default:
        }
        inventory.notifyDataSetChanged();
    }

}
