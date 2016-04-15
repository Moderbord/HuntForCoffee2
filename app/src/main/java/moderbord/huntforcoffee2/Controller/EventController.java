package moderbord.huntforcoffee2.Controller;

import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.Recipes;
import moderbord.huntforcoffee2.Model.events.CharacterCreation;
import moderbord.huntforcoffee2.Model.events.Forrest;
import moderbord.huntforcoffee2.Model.events.GoldenRoad;
import moderbord.huntforcoffee2.Model.events.Graveyard;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class EventController {

    public static UIController ui = UIController.getInstance();
    public static UIController text = UIController.getInstance();

    public static Recipes recipes = Recipes.getInstance(); // Move elsewhere?
    public static CharacterCreation cc = CharacterCreation.getInstance();
    public static GoldenRoad goldenRoad = GoldenRoad.getInstance();
    public static Graveyard graveyard = Graveyard.getInstance();
    public static Forrest forrest = Forrest.getInstance();

    protected static Player player;

    public void initCharacterCreation(){
        ui.disableAllButtons();
        ui.clearActionButtons();
        ui.setEvent(cc.intro, 1, "New Character");
        ui.setPortraitDefault();
    }

}
