package moderbord.huntforcoffee2.Model;

import java.util.ArrayList;

import moderbord.huntforcoffee2.Model.item.Item;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class Inventory extends ArrayList<Item>{

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
        size();
    }
}
