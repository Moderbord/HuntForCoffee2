package moderbord.huntforcoffee2.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
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
    InventoryArmourAdapter armourAdapter;
    InventoryConsumableAdapter consumableAdapter;
    InventoryReagentAdapter reagentAdapter;
    LayoutInflater inflater;
    ImageButton allButton, weaponsButton, armoursButton, consumablesButton, reagentsButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // TODO make this work on Entities
        super.onCreate(savedInstanceState);
        inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.inventory_layout, null);
        setContentView(v);

        allButton = (ImageButton) findViewById(R.id.inventory_all_button);
        weaponsButton = (ImageButton) findViewById(R.id.inventory_weapon_button);
        armoursButton = (ImageButton) findViewById(R.id.inventory_armour_button);
        consumablesButton = (ImageButton) findViewById(R.id.inventory_consumable_button);
        reagentsButton = (ImageButton) findViewById(R.id.inventory_reagent_button);
        backButton = (ImageButton) findViewById(R.id.inventory_back_button);


        // Creating adapters for respective tabs
        allIAdapter = new InventoryAllAdapter();
        weaponIAdapter = new InventoryWeaponAdapter();
        armourAdapter = new InventoryArmourAdapter();
        consumableAdapter = new InventoryConsumableAdapter();
        reagentAdapter = new InventoryReagentAdapter();

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

        armoursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryListView.setAdapter(armourAdapter);
            }
        });

        consumablesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryListView.setAdapter(consumableAdapter);
            }
        });

        reagentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inventoryListView.setAdapter(reagentAdapter);
            }
        });

        // "Closes" the inventory
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    /**
     * Inventory adapter for displaying all Items with name, category, and quantity.
     */
    private class InventoryAllAdapter extends BaseAdapter {

        Inventory dummyInventory = new Inventory().copyInventory(EventController.player.getInventory());

        public InventoryAllAdapter() {
            super();
        }

        @Override
        public int getCount() {
            return dummyInventory.size();
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
            if (convertView == null) {
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
     * Inventory adapter that displays all weapons in the entity's inventory with name, weapon type, and max damage.
     */
    private class InventoryWeaponAdapter extends BaseAdapter {

        Inventory dummyInventory = new Inventory().copyInventory(EventController.player.getInventory());

        public InventoryWeaponAdapter() {
            super();
        }

        private void sortWeapons() {
            for (Iterator<Item> iter = this.dummyInventory.iterator(); iter.hasNext(); ) {
                Item i = iter.next();
                if (!(i instanceof Weapon)) {
                    iter.remove();
                }
            }
        }

        @Override
        public int getCount() {
            sortWeapons();
            return dummyInventory.size();
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
            if (convertView == null && dummyInventory.get(position) instanceof Weapon) {
                v = inflater.inflate(R.layout.inventory_weapon_row, null);
            }
            TextView weaponName = (TextView) v.findViewById(R.id.inventory_weapon_name);
            TextView weaponType = (TextView) v.findViewById(R.id.inventory_weapon_type);
            TextView weaponDmg = (TextView) v.findViewById(R.id.inventory_weapon_dmg);

            weaponName.setText(dummyInventory.get(position).getName());
            weaponType.setText(((Weapon) dummyInventory.get(position)).getWepType());
            weaponDmg.setText(Integer.toString(((Weapon) dummyInventory.get(position)).getMaxDmg()));

            return v;
        }
    }

    /**
     * Inventory adapter that displays all Armours in the entity's inventory with name, armour type, and defence.
     */
    private class InventoryArmourAdapter extends BaseAdapter {

        Inventory dummyInventory = new Inventory().copyInventory(EventController.player.getInventory());

        public InventoryArmourAdapter() {
            super();
        }

        private void sortArmours() {
            for (Iterator<Item> iter = this.dummyInventory.iterator(); iter.hasNext(); ) {
                Item i = iter.next();
                if (!(i instanceof Armour)) {
                    iter.remove();
                }
            }
        }

        @Override
        public int getCount() {
            sortArmours();
            return dummyInventory.size();
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
            if (convertView == null && dummyInventory.get(position) instanceof Armour) {
                v = inflater.inflate(R.layout.inventory_armour_row, null);
            }
            TextView armourName = (TextView) v.findViewById(R.id.inventory_armour_name);
            TextView armourType = (TextView) v.findViewById(R.id.inventory_armour_type);
            TextView armourDef = (TextView) v.findViewById(R.id.inventory_armour_defence);

            armourName.setText(dummyInventory.get(position).getName());
            armourType.setText(((Armour) dummyInventory.get(position)).getArmClass());
            armourDef.setText(Integer.toString(((Armour) dummyInventory.get(position)).getArmDef()));

            return v;
        }
    }

    /**
     * Inventory adapter that displays all Consumables in the entity's inventory with name and amount
     */
    private class InventoryConsumableAdapter extends BaseAdapter {

        Inventory dummyInventory = new Inventory().copyInventory(EventController.player.getInventory());

        public InventoryConsumableAdapter() {
            super();
        }

        private void sortConsumables() {
            for (Iterator<Item> iter = this.dummyInventory.iterator(); iter.hasNext(); ) {
                Item i = iter.next();
                if (!(i instanceof Consumable)) {
                    iter.remove();
                }
            }
        }

        @Override
        public int getCount() {
            sortConsumables();
            return dummyInventory.size();
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
            if (convertView == null && dummyInventory.get(position) instanceof Consumable) {
                v = inflater.inflate(R.layout.inventory_consumable_row, null);
            }
            TextView consumableName = (TextView) v.findViewById(R.id.inventory_consumable_name);
            TextView consumableQuantity = (TextView) v.findViewById(R.id.inventory_consumable_quantity);

            consumableName.setText(dummyInventory.get(position).getName());
            consumableQuantity.setText(Integer.toString((dummyInventory.get(position)).getQuantity()));

            return v;
        }
    }

    /**
     * Inventory adapter that displays all Reagents in the entity's inventory with name, reagent quality, and amount.
     */
    private class InventoryReagentAdapter extends BaseAdapter {

        Inventory dummyInventory = new Inventory().copyInventory(EventController.player.getInventory());

        public InventoryReagentAdapter() {
            super();
        }

        private void sortReagents() {
            for (Iterator<Item> iter = this.dummyInventory.iterator(); iter.hasNext(); ) {
                Item i = iter.next();
                if (!(i instanceof Reagent)) {
                    iter.remove();
                }
            }
        }

        @Override
        public int getCount() {
            sortReagents();
            return dummyInventory.size();
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
            if (convertView == null && dummyInventory.get(position) instanceof Reagent) {
                v = inflater.inflate(R.layout.inventory_reagent_row, null);
            }
            TextView reagentName = (TextView) v.findViewById(R.id.inventory_reagent_name);
            TextView reagentQuality = (TextView) v.findViewById(R.id.inventory_reagent_quality);
            TextView reagentQuantity = (TextView) v.findViewById(R.id.inventory_reagent_quantity);

            reagentName.setText(dummyInventory.get(position).getName());
            reagentQuality.setText(((Reagent) dummyInventory.get(position)).getQuality());
            reagentQuantity.setText(Integer.toString((dummyInventory.get(position)).getQuantity()));

            return v;
        }
    }

    /**
     * A method called from some inventory adapters that will return the proper category assigned to respective Item
     *
     * @param i The Item of which the category will be extracted
     * @return A string of the category
     */
    private String getItemCategory(Item i) {
        String category = "";

        if (i instanceof Consumable) {
            category = "Consumable";
        }

        if (i instanceof Reagent) {
            category = "Reagent";
        }

        if (i instanceof Weapon) {
            category = "Weapon";
        }

        if (i instanceof Armour) {
            category = "Armour";
        }

        return category;
    }

}
