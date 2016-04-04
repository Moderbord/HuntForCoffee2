package moderbord.huntforcoffee2.Model.events;

import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-01-06.
 */
public class Forrest extends EventController{

    private static Forrest instance;

    public static Forrest getInstance(){
        if (instance == null){
            instance = new Forrest();
        }
        return instance;
    }

    View.OnClickListener entry = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.setLocation(C.LOCATION_FORREST);
            ui.disableActionButtons();

            ui.mainText.setText("Gyranimouuyyy!!");

            ui.setEvent(goldenRoad.entry, 1, "Golden Road");
        }
    };
}
