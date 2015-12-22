package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class SuperMeal extends Item implements Consumable {

    public SuperMeal() {
        name = "SuperMeal";
        className = "SuperMeal";
        addItem(1);
    }

    public SuperMeal(int x) {
        this();
        addItem(x-1);
    }

    @Override
    public String consume() {
        return "It's too much to eat!";
    }

}
