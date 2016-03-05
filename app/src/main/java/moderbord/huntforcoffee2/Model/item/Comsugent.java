package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Oscilla on 2016-03-03.
 */
public abstract class Comsugent extends Item{

    // TODO this is a class for Items which are both a Consumable and a Reagent

    private String quality = "Common";

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    abstract String combineFail();

    abstract String combineSucess();

    abstract String consume();

    @Override
    public String itemInformation() {
        return super.itemInformation();
    }

}
