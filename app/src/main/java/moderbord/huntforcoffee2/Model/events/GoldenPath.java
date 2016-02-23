package moderbord.huntforcoffee2.Model.events;

import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;

/**
 * Created by Moderbord on 2016-01-06.
 */
public class GoldenPath extends EventController implements View.OnClickListener {

    public void entry() {
        ui.mainTextWindow.setText("Golden path??");

        ui.b0.setText("Back");
        ui.b0.setOnClickListener(new Forrest() {
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
