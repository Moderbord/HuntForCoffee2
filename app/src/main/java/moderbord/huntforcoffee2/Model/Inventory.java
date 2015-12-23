package moderbord.huntforcoffee2.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

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

    public boolean hasItem(String name){
        boolean match = false;
        for(Item i: this){
            if(i.getName().equals(name)){
                match = true;
            }
        }
        return match;
    }

    public boolean hasItemQty(String name, int qty){
        boolean match = false;
        for(Item i: this){
            if(i.getName().equals(name) && i.getQuantity() >= qty){
                match = true;
            }
        }
        return match;
    }

    public Gear getGear(int index) {
        return (Gear) super.get(index);
    }

    public Item itemByName(String name){
        for(Item i: this){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

    public Gear gearByName(String name){
        for(Item i: this){
            if(i.getName().equals(name)){
                try {
                    return (Gear) i;
                } catch (Exception e) {
                    Log.d("Inventory", "Tried to return Gear from inventory that was not Gear");
                }
            }
        }
        return null;
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

    public void updateInventoryData() {
        for(Iterator<Item> iter = this.iterator(); iter.hasNext(); ){
            Item item = iter.next();
            if(item.getQuantity() < 1){
                iter.remove();
            }
        }
    }

}
