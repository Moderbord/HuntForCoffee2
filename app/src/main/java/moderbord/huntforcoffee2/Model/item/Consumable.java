package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public abstract class Consumable extends Item{

    private String effect = "Rejuvenating"; // TODO add this and more effects to C

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public abstract String consume();

    @Override
    public String itemInformation() {
        return "Name: " + this.name + "\nEffect: " + this.effect + "\n\n" + this.description;
    }
}
