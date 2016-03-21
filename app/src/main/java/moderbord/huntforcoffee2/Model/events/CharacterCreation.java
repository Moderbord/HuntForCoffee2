package moderbord.huntforcoffee2.Model.events;

import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;

/**
 * Created by Oscilla on 2016-03-15.
 */

public class CharacterCreation extends EventController implements View.OnClickListener {

    // TODO rename step-methods to appropriate name according to content

    public void stepOne(){
        ui.nameInput.setVisibility(View.VISIBLE);

        ui.button1.setOnClickListener(CharacterCreation.this );
    }

    public void stepTwo(){
        ui.nameInput.setVisibility(View.GONE);

    }
    @Override
    public void onClick(View v) {

    }

}
