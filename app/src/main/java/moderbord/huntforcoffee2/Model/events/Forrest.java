package moderbord.huntforcoffee2.Model.events;

import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;

/**
 * Created by Moderbord on 2016-01-06.
 */
public class Forrest extends EventController implements View.OnClickListener {

    public void entry() {
        ui.mainTextWindow.setText("Gyranimouuyyy!!");

        player.seteHealth(player.geteHealth() - 5);

        ui.b0.setText("Hey!");
        ui.b0.setOnClickListener(new GoldenPath() {
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
