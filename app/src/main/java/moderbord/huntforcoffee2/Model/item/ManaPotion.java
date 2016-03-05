package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2016-03-02.
 */
public class ManaPotion extends Consumable {

    public ManaPotion() {
        name = "Mana Potion";
        className = "ManaPotion";
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