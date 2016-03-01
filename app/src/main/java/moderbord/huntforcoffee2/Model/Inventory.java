package moderbord.huntforcoffee2.Model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import moderbord.huntforcoffee2.Model.item.Gear;
import moderbord.huntforcoffee2.Model.item.Item;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class Inventory extends ArrayList<Item> {

    @Override
    public boolean add(Item object) {
        for (Item i : this) {
            try {
                if (i.getName().equals(object.getName()) && !(object instanceof Gear)) {
                    i.addItem(object.getQuantity());
                    return true;
                }
            } catch (Exception e) {
                Log.d("Inventory", "object was null");
            }
        }
        return super.add(object);
    }

    public boolean hasItem(String name) {
        boolean match = false;
        for (Item i : this) {
            if (i.getName().equals(name)) {
                match = true;
            }
        }
        return match;
    }

    public boolean hasItemQty(String name, int qty) {
        boolean match = false;
        for (Item i : this) {
            if (i.getName().equals(name) && i.getQuantity() >= qty) {
                match = true;
            }
        }
        return match;
    }

    public Item itemByName(String name) {
        for (Item i : this) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public Gear gearByIndex(int index) {
        if (this.get(index) instanceof Gear) {
            return (Gear) super.get(index);
        } else {
            Log.d("Inventory", "Tried to return Gear from inventory that was not Gear");
            return null;
        }
    }

    public Gear gearByItem(Item item) {
        for (Item i : this) {
            if (i == item) {
                try {
                    return (Gear) i;
                } catch (Exception e) {
                    Log.d("Inventory", "Tried to return Gear from inventory that was not Gear");
                }
            }
        }
        return null;
    }

    public Gear gearByName(String name) {
        for (Item i : this) {
            if (i.getName().equals(name)) {
                try {
                    return (Gear) i;
                } catch (Exception e) {
                    Log.d("Inventory", "Tried to return Gear from inventory that was not Gear");
                }
            }
        }
        return null;
    }

    public int itemCount(){
        int x = 0;
        for (Item i : this){
            x += 1;
        }
        return x;
    }

    @Override
    public int size() {
        int x = 0;
        for (Item i : this) {
            x += i.getQuantity();
        }
        return x;
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        for (Item i : this) {
            b.append(i.toString() + "\n");
        }
        return b.toString();
    }

    public void notifyDataSetChanged() {
        for (Item x : this) {
            if (x.getQuantity() < 1) {
                this.remove(x);
            }
        }
        size();
    }

    public void updateInventoryData() {
        for (Iterator<Item> iter = this.iterator(); iter.hasNext(); ) {
            Item item = iter.next();
            if (item.getQuantity() < 1) {
                iter.remove();
            }
        }
    }

    public Inventory copyInventory(Inventory original){
        Inventory dummy = new Inventory();

        if (!original.isEmpty()) {
            for (Item i : original){
                dummy.add(i);
            }
        }

        return dummy;
    }

}
