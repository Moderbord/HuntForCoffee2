package moderbord.huntforcoffee2.Model;

import moderbord.huntforcoffee2.Model.item.ArmourBuilder;
import moderbord.huntforcoffee2.Model.item.IronBar;
import moderbord.huntforcoffee2.Model.item.SuperMeal;
import moderbord.huntforcoffee2.Model.item.UniqueArmour;

/**
 * Created by Moderbord on 2015-12-20.
 */
public class Recipes{

    public void stirThePot(Entity e, String toCreate) {
        switch (toCreate){
            case "SuperMeal":
                if(e.getInventory().hasItemQty("Burger", 2) && e.getInventory().hasItemQty("Unique pizza", 1)){
                    e.getInventory().add(new SuperMeal());
                    e.getInventory().itemByName("Burger").subtractItem(2);
                    e.getInventory().itemByName("Unique pizza").subtractItem(1);
                }
                break;
            case "Iron bar":
                if(e.getInventory().hasItemQty("Iron ore", 2)){
                    e.getInventory().add(new IronBar());
                    e.getInventory().itemByName("Iron ore").subtractItem(2);
                }
                break;
            case "WardenArmour":
                if(e.getInventory().hasItemQty("Iron bar", 4)){
                    UniqueArmour uniqueArmour = new ArmourBuilder().createUniqueArmour();
                    e.getInventory().add(uniqueArmour);
                    e.getInventory().itemByName("Iron bar").subtractItem(4);
                }
                break;
            default:
        }
    }

}
