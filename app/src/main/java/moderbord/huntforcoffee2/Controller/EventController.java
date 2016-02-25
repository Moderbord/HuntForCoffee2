package moderbord.huntforcoffee2.Controller;

import android.content.Intent;
import android.view.View;

import moderbord.huntforcoffee2.MainActivity;
import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.Recipes;
import moderbord.huntforcoffee2.Model.events.Forrest;
import moderbord.huntforcoffee2.Model.item.IronOre;
import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class EventController {

    public static UIController ui = UIController.getInstance();
    public static Recipes recipes = Recipes.getInstance(); // Move elsewhere?

    protected static Player player = new EntityBuilder().seteName("Pontarn").createEntityPlayer();

    public void initGame() {
        ui.mainTextWindow.setText("Welcome to Jurassic Park " + player.geteName() + "!");

        player.seteHealth(100);

        player.getInventory().add(new IronOre(8));
        player.combineItem(Constants.RECIPE_IRON_BAR);
        player.combineItem(Constants.RECIPE_IRON_BAR);
        player.combineItem(Constants.RECIPE_IRON_BAR);
        player.combineItem(Constants.RECIPE_IRON_BAR);

        player.combineItem(Constants.RECIPE_ARMOUR_WARDEN);


        ui.b0.setText("Forrest");
        ui.b0.setOnClickListener(new Forrest() {
            @Override
            public void onClick(View v) {
                entry();
            }
        });


    }

}
