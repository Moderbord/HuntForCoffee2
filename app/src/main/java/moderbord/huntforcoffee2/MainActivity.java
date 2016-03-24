package moderbord.huntforcoffee2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Controller.InventoryController;
import moderbord.huntforcoffee2.Controller.UIController;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.main_layout_wip, null);
        setContentView(v);
        UIController.getInstance().initWithView(v);

        EventController eventController = new EventController();
        eventController.initCharacterCreation();

        EventController.ui.inventoryButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InventoryController.class);
                startActivity(intent);
            }

        });

        /*
        SaveController.getInstance(this).saveEntity(p);
        p = (Player) SaveController.getInstance(this).loadEntity(p);

        p.equipArmour(p.getInventory().gearByString(Constants.ARMOUR_WARDEN));
        */
    }


}
