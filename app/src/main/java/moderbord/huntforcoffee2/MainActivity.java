package moderbord.huntforcoffee2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Controller.InventoryController;
import moderbord.huntforcoffee2.Controller.UIController;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class MainActivity extends Activity {

    public static Context context;
    private final String FLOW = "flow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean restoreSession = false;

        try { restoreSession = savedInstanceState.getBoolean("restore", false); } catch (Exception e) {
            e.printStackTrace(); }

        if (!restoreSession) {
            LayoutInflater inflater = getLayoutInflater();
            View v = inflater.inflate(R.layout.main_layout_wip, null);
            setContentView(v);
            UIController.getInstance().initWithView(v);
            context = this;
            EventController eventController = new EventController();
            eventController.initCharacterCreation();

            EventController.ui.inventoryButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), InventoryController.class);
                    startActivity(intent);
                }

            });
        }

        /*
        SaveController.getInstance(this).saveEntity(p);
        p = (Player) SaveController.getInstance(this).loadEntity(p);

        p.equipArmour(p.getInventory().gearByString(C.ARMOUR_WARDEN));
        */

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        boolean restoreSession = true;
        outState.putBoolean("restore", restoreSession);
        Log.d("FLOW", "onSaveInstanceState");
    }
}
