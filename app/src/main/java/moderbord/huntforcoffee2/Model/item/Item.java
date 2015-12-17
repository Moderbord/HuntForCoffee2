package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class Item {

    private int quantity;
    private String name;
    private String description;

    public void addItem(int toAdd){
        quantity += toAdd;
    }

    public void removeItem(int toRemove){
        quantity -= toRemove;
        if (quantity < 1){
            quantity = 0;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return quantity + "x" + name;
    }
}
