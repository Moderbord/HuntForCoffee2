package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class IronOre extends Item implements Reagent {

    public IronOre() {
        name = "Iron ore";
        className = "IronOre";
        addItem(1);
    }

    public IronOre(int x) {
        this();
        addItem(x-1);
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
