package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class IronBar extends Item implements Reagent {

    public IronBar() {
        name = "Iron bar";
        className = "IronBar";
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
