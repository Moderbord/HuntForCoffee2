package moderbord.huntforcoffee2.Model.item;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class Item {

    protected int quantity;
    protected String className;
    protected String name;
    protected String description;

    public Item() {
    }

    public Item(int quantity, String className, String name, String description) {
        this.quantity = quantity;
        this.className = className;
        this.name = name;
        this.description = description;
    }

    public void addItem(int toAdd) {
        quantity += toAdd;
    }

    public void subtractItem(int toSubtract) {
        quantity -= toSubtract;
        if (quantity < 1) {
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

    public String itemInformation(){
        return "Name: " + this.name + "\n\n" + this.description;

    }

    @Override
    public String toString() {
        return quantity + " x " + name;
    }
}
