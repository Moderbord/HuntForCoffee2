package moderbord.huntforcoffee2.Model.events;

import android.view.View;
import android.widget.Button;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Oscilla on 2016-03-15.
 */

public class CharacterCreation extends EventController {

    private static CharacterCreation instance;

    public static CharacterCreation getInstance() {
        if (instance == null) {
            instance = new CharacterCreation();
        }
        return instance;
    }

    // TODO rename step-methods to appropriate name according to content

    private Entity player = new EntityBuilder().createEntityPlayer();

    public View.OnClickListener intro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.append("The lands of bla is in danger of the invading demons in the south. ");
            text.append("You have to make a choice of which side you want to support. ");
            text.append("\n\nWhat could it be?. ");
            text.submit();
            ui.setButtonEvent(alignmentChoice, 1, "Next");
        }
    };

    View.OnClickListener alignmentChoice = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.append("The good side is light...");
            text.append("\n\nThe evil side is dark...");
            text.append("\n\nWhat shall it be?");
            text.submit();
            ui.setButtonEvent(raceDescription, 1, Constants.ALIGMENT_GOOD);
            ui.setButtonEvent(raceDescription, 2, Constants.ALIGMENT_EVIL);
        }
    };

    View.OnClickListener raceDescription = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String choice = btn.getText().toString();
            player.seteAlignment(choice);
        }
    };
}
