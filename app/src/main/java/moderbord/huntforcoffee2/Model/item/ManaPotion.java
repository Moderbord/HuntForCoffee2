package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2016-03-02.
 */
public class ManaPotion extends Consumable {

    public ManaPotion() {
        name = "Mana Potion";
        className = "ManaPotion";
        description = "A potion commonly used by magicians to regain some of their magic capabilities.";
        addItem(1);
    }

    public ManaPotion(int x) {
        this();
        addItem(x - 1);
    }

    @Override
    public String consume() {
        return null;
    }

}