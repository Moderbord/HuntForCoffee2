package moderbord.huntforcoffee2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Controller.InventoryController;
import moderbord.huntforcoffee2.Controller.SaveController;
import moderbord.huntforcoffee2.Controller.UIController;
import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.item.IronOre;
import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.main_layout, null);
        setContentView(v);
        UIController.getInstance().initWithView(v);

        EventController eventController = new EventController();
        eventController.initGame();

        EventController.ui.b1.setVisibility(View.VISIBLE);
        EventController.ui.b1.setText("Inventory");
        EventController.ui.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InventoryController.class);
                startActivity(intent);
            }
        });

        Player p = new EntityBuilder().seteName("Pontus").createEntityPlayer();
        p.getInventory().add(new IronOre(8));
        p.combineItem(Constants.RECIPE_IRON_BAR);
        p.combineItem(Constants.RECIPE_IRON_BAR);
        p.combineItem(Constants.RECIPE_IRON_BAR);
        p.combineItem(Constants.RECIPE_IRON_BAR);

        p.combineItem(Constants.RECIPE_ARMOUR_WARDEN);

        SaveController.getInstance(this).saveEntity(p);
        p = (Player) SaveController.getInstance(this).loadEntity(p);

        p.equipArmour(p.getInventory().gearByName(Constants.ARMOUR_WARDEN));
    }


}
