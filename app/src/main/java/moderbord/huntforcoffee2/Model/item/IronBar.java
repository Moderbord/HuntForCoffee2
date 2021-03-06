package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class IronBar extends Reagent {

    public IronBar() {
        name = C.ITEM_IRON_BAR;
        className = "IronBar";
        description = "A heavy bar of iron that can be used as crafting material in certain crafting recipes.";
        addItem(1);
    }

    public IronBar(int x) {
        this();
        addItem(x - 1);
    }

    @Override
    public String combineFail() {
        return null;
    }

    @Override
    public String combineSucess() {
        return null;
    }
}
