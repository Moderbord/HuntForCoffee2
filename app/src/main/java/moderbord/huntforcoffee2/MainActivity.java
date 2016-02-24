package moderbord.huntforcoffee2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Controller.SaveController;
import moderbord.huntforcoffee2.Controller.UIController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.item.Armour;
import moderbord.huntforcoffee2.Model.item.ArmourBuilder;
import moderbord.huntforcoffee2.Model.item.Burger;
import moderbord.huntforcoffee2.Model.item.IronOre;
import moderbord.huntforcoffee2.Model.item.UniqueArmour;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Model.item.WeaponBuilder;
import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_main, null);
        setContentView(v);
        UIController.getInstance().initWithView(v);

        EventController eventController = new EventController();
        eventController.initGame();

        Player p = new EntityBuilder().seteName("Pontus").createEntityPlayer();
        p.getInventory().add(new IronOre(8));
        p.combineItem(Constants.RECIPE_IRON_BAR);
        p.combineItem(Constants.RECIPE_IRON_BAR);
        p.combineItem(Constants.RECIPE_IRON_BAR);
        p.combineItem(Constants.RECIPE_IRON_BAR);

        p.combineItem(Constants.RECIPE_ARMOUR_WARDEN);

        SaveController.getInstance(this).saveEntity(p);
        p = (Player) SaveController.getInstance(this).loadEntity(p);

        p.equipArmour(p.getInventory().gearByName(Constants.ARMOUR_WARDEN));
    }


}
