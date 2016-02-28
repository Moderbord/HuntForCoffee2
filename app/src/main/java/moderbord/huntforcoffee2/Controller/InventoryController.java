package moderbord.huntforcoffee2.Controller;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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
    InventoryAllAdapter iAdapter;
    LayoutInflater inflater;
    Inventory dummyInventory;
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

        dummyInventory = EventController.player.getInventory();

        iAdapter = new InventoryAllAdapter();

        inventoryListView = (ListView) findViewById(R.id.inventory_list_view);
        inventoryListView.setAdapter(iAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private class InventoryAllAdapter extends BaseAdapter {

        boolean initCategoryRow = true;

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

            initCategoryRow = false;
            return v;
        }
    }

    private String getItemCategory(Item i){
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

}
