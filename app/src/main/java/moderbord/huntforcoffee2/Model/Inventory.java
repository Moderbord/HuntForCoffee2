package moderbord.huntforcoffee2.Model;

import java.util.ArrayList;

import moderbord.huntforcoffee2.Model.item.Gear;
import moderbord.huntforcoffee2.Model.item.Item;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class Inventory extends ArrayList<Item>{

    @Override
    public boolean add(Item object) {
        for (Item i: this){
            if(i.getName().equals(object.getName()) && !(object instanceof Gear)){
                i.addItem(object.getQuantity());
                return true;
            }
        }
        return super.add(object);
    }

    public Gear getGear(int index) {
        return (Gear) super.get(index);
    }

    @Override
    public int size() {
        int x = 0;
        for (Item i: this){
            x += i.getQuantity();
        }
        return x;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Item i : this){
            b.append(i.toString() + "\n");
        }
        return b.toString();
    }

    public void notifyDataSetChanged() {
        for (Item x: this){
            if(x.getQuantity() < 1){
                this.remove(x);
            }
        }
        size();
    }
}
