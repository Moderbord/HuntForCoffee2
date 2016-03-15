package moderbord.huntforcoffee2.Model.events;

import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2016-01-06.
 */
public class Forrest extends EventController implements View.OnClickListener {

    public void entry() {
        ui.setLocation(Constants.LOCATION_FORREST);
        ui.disableActionButtons();

        ui.mainText.setText("Gyranimouuyyy!!");

        ui.setButtonText(1, "Hey!");
        ui.button1.setOnClickListener(new GoldenPath() {
            @Override
            public void onClick(View v) {
                entry();
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
