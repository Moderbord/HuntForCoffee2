package moderbord.huntforcoffee2.Model.events;

import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;

/**
 * Created by Moderbord on 2016-03-21.
 */
public class Graveyard extends EventController {

    private static Graveyard instance;

    public static Graveyard getInstance() {
        if (instance == null) {
            instance = new Graveyard();
        }
        return instance;
    }

    View.OnClickListener dig = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.setLocation("Hole");

            ui.setButtonText("Climb", 1);
            ui.setButtonText("Continue", 2);
        }
    };

    View.OnClickListener entry = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.setLocation("Graveyard");

            ui.setEvent(graveyard.dig, 1, "Dig");
        }
    };

}
