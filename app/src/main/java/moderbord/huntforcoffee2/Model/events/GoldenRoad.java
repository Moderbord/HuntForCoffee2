package moderbord.huntforcoffee2.Model.events;

import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;

/**
 * Created by Moderbord on 2016-01-06.
 */
public class GoldenRoad extends EventController {

    private static GoldenRoad instance;

    public static GoldenRoad getInstance(){
        if (instance == null){
            instance = new GoldenRoad();
        }
        return instance;
    }

    View.OnClickListener entry = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.append("There is a golden road leading to unexplored areas ahead of you");
            text.submit();
        }
    };
}
