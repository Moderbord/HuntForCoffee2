package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */

public abstract class Reagent extends Item {

    private String quality = "Common"; // TODO add this and additional qualities to C

    abstract String combineFail();

    abstract String combineSucess();

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public String itemInformation() {
        return "Name: " + this.name + "\nQuality: " + this.quality + "\n\n" + this.description;
    }
}
