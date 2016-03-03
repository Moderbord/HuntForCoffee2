package moderbord.huntforcoffee2.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Iterator;

import moderbord.huntforcoffee2.Model.Inventory;
import moderbord.huntforcoffee2.Model.item.Armour;
import moderbord.huntforcoffee2.Model.item.Consumable;
import moderbord.huntforcoffee2.Model.item.Item;
import moderbord.huntforcoffee2.Model.item.Reagent;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.R;

/**
 * Created by Oscilla on 2016-02-25.
 */
public class InventoryController extends Activity {

    ListView inventoryListView;
    InventoryAllAdapter allIAdapter;
    InventoryWeaponAdapter weaponIAdapter;
    LayoutInflater inflater;
    Button allButton, weaponsButton, armoursButton, consumablesButton, reagentsButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.inventory_layout, null);
        setContentView(v);

        allButton = (Button) findViewById(R.id.inventory_all_button);
        weaponsButton = (Button) findViewById(R.id.inventory_weapon_button);
        armoursButton = (Button) findViewById(R.id.inventory_armour_button);
        consumablesButton = (Button) findViewById(R.id.inventory_consumable_button);
        reagentsButton = (Button) findViewById(R.id.inventory_reagent_button);
        backButton = (Button) findViewById(R.id.inventory_back_button);

        // Creates a dummy inventory from players inventory. // TODO make this work on Entities

        // Creating adapters for respective tabs
        allIAdapter = new InventoryAllAdapter();
        weaponIAdapter = new InventoryWeaponAdapter();

        inventoryListView = (ListView) findViewById(R.id.inventory_list_view);
        inventoryListView.setAdapter(allIAdapter);

        // Applying all listeners
        allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryListView.setAdapter(allIAdapter);
            }
        });

        weaponsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryListView.setAdapter(weaponIAdapter);
            }
        });

        // "Closes" the inventory
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventController.player.getInventory().remove(2);
                onBackPressed();
            }
        });



    }


    /**
     * Inventory adapter for displaying all Items with name, category, and quantity.
     */
    private class InventoryAllAdapter extends BaseAdapter {

        Inventory dummyInventory = new Inventory().copyInventory(EventController.player.getInventory());

        public InventoryAllAdapter(){
            super();
        }

        @Override
        public int getCount() {
            return dummyInventory.itemCount();
        }

        @Override
        public Object getItem(int pos) {
            return dummyInventory.get(pos);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (convertView == null){
                v = inflater.inflate(R.layout.inventory_all_row, null);
            }
            TextView itemName = (TextView) v.findViewById(R.id.inventory_all_name);
            TextView itemCategory = (TextView) v.findViewById(R.id.inventory_all_category);
            TextView itemQuantity = (TextView) v.findViewById(R.id.inventory_all_quantity);

            itemName.setText(dummyInventory.get(position).getName());
            itemQuantity.setText(Integer.toString(dummyInventory.get(position).getQuantity()));
            String cat = getItemCategory(dummyInventory.get(position));
            itemCategory.setText(cat);

            return v;
        }
    }

    /**
     * A method called from some inventory adapters that will return the proper category assigned to respective Item
     * @param i The Item of which the category will be extracted
     * @return A string of the category
     */
    private String getItemCategory(Item i){ //TODO put in constants
        String category = "";

        if (i instanceof Consumable){
            category = "Consumable";
        }

        if (i instanceof Reagent){
            category = "Reagent";
        }

        if (i instanceof Weapon){
            category = "Weapon";
        }

        if (i instanceof Armour){
            category = "Armour";
        }

        return category;
    }

    /**
     * Inventory adapter that displays all weapons in the entity's inventory with name, weapon type, and max damage.
     */
    private class InventoryWeaponAdapter extends BaseAdapter{

        Inventory dummyInventory = new Inventory().copyInventory(EventController.player.getInventory());

        public InventoryWeaponAdapter(){
            super();
        }

        private void sortInventory(){
            for (Iterator<Item> iter = this.dummyInventory.iterator(); iter.hasNext(); ) {
                Item i = iter.next();
                if (!(i instanceof Weapon)) {
                    iter.remove();
                    notifyDataSetChanged();
                }
            }
        }

        @Override
        public int getCount() {
            sortInventory();
            return dummyInventory.itemCount();
        }

        @Override
        public Object getItem(int pos) {
            return dummyInventory.get(pos);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (convertView == null && dummyInventory.get(position) instanceof Weapon){
                v = inflater.inflate(R.layout.inventory_weapon_row, null);
            }
            TextView itemName = (TextView) v.findViewById(R.id.inventory_weapon_name);
            TextView itemCategory = (TextView) v.findViewById(R.id.inventory_weapon_type);
            TextView itemQuantity = (TextView) v.findViewById(R.id.inventory_weapon_dmg);

            itemName.setText(dummyInventory.get(position).getName());
            itemCategory.setText(((Weapon) dummyInventory.get(position)).getWepType());
            itemQuantity.setText(Integer.toString(((Weapon) dummyInventory.get(position)).getMaxDmg()));

            return v;
        }

    }

}
