package moderbord.huntforcoffee2.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import moderbord.huntforcoffee2.Model.Inventory;
import moderbord.huntforcoffee2.R;

/**
 * Created by Oscilla on 2016-02-25.
 */
public class InventoryController extends Activity {

    ListView inventoryListView;
    InventoryAdapter iAdapter;
    LayoutInflater inflater;
    Inventory dummyInventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.inventory_layout, null);
        setContentView(v);

        dummyInventory = EventController.player.getInventory();

        iAdapter = new InventoryAdapter();
        //iAdapter.notifyDataSetChanged();

        inventoryListView = (ListView) findViewById(R.id.inventory_list_view);
        inventoryListView.setAdapter(iAdapter);

    }

    private class InventoryAdapter extends BaseAdapter {

        public InventoryAdapter(){
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
            if (convertView == null){
                v = inflater.inflate(R.layout.inventory_all_row, null);
            }
            TextView itemName = (TextView) v.findViewById(R.id.inventory_all_name);
            TextView itemCategory = (TextView) v.findViewById(R.id.inventory_all_category);
            TextView itemQuantity = (TextView) v.findViewById(R.id.inventory_all_quantity);

            itemName.setText(dummyInventory.get(position).getName());
            itemCategory.setText(dummyInventory.get(position).getClass().getSimpleName());
            itemQuantity.setText(Integer.toString(dummyInventory.get(position).getQuantity()));

            return v;
        }
    }

}
