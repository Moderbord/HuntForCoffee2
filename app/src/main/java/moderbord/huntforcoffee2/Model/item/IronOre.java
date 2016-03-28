package moderbord.huntforcoffee2.Model.item;

import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class IronOre extends Reagent {

    public IronOre() {
        name = C.ITEM_IRON_ORE;
        className = "IronOre";
        description = "Ore extracted from a iron vein. May be smelted into an iron bar.";
        addItem(1);
    }

    public IronOre(int x) {
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
