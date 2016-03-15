package moderbord.huntforcoffee2.Model.events;

import android.view.View;
import android.widget.Button;

import moderbord.huntforcoffee2.Controller.EventController;

/**
 * Created by Moderbord on 2016-01-06.
 */
public class GoldenPath extends EventController implements View.OnClickListener {

    public void entry() {
        ui.mainText.setText("Golden path??");

        ui.button1.setText("Back");
        ui.button1.setOnClickListener(new Forrest() {
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
