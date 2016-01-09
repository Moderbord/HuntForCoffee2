package moderbord.huntforcoffee2.Controller;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.events.Forrest;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class EventController {

    protected UIController ui = UIController.getInstance();

    protected static Player player = new EntityBuilder().seteName("Pontarn").createEntityPlayer();

    public void initGame() {
        ui.mainTextWindow.setText("Welcome to Jurassic Park " + player.geteName() + "!");

        player.seteHealth(100);

        ui.b0.setText("Forrest");
        ui.b0.setOnClickListener(new Forrest() {
            @Override
            public void onClick(View v) {
                entry();
            }
        });
    }

}
