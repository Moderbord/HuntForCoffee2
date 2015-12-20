package moderbord.huntforcoffee2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import moderbord.huntforcoffee2.Controller.SaveController;
import moderbord.huntforcoffee2.Controller.UIController;
import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Model.Jheero;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.item.Armour;
import moderbord.huntforcoffee2.Model.item.ArmourBuilder;
import moderbord.huntforcoffee2.Model.item.Burger;
import moderbord.huntforcoffee2.Model.item.Pizza;
import moderbord.huntforcoffee2.Model.item.UniqueArmour;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Model.item.WeaponBuilder;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_main, null);
        setContentView(v);
        UIController.getInstance().initWithView(v);
        Player p = new EntityBuilder().seteName("Pontus").createEntityPlayer();
        p.getInventory().add(new Burger(4));
        p.getInventory().get(0);

        Weapon weapon = new WeaponBuilder().setName("Trollbane").createWeapon();
        Weapon weapons = new WeaponBuilder().setName("Giant Slayer").createWeapon();
        Weapon weaponed = new WeaponBuilder().setName("Ice").createWeapon();
        p.getInventory().add(weapon);
        p.getInventory().add(weapons);
        p.getInventory().add(weaponed);

        Jheero jheero = new EntityBuilder().createEntityJheero();

        Armour shiny = new ArmourBuilder().createArmour();
        p.getInventory().add(shiny);

        UniqueArmour unique = new ArmourBuilder().createUniqueArmour();
        jheero.getInventory().add(new Pizza());
        jheero.getInventory().add(unique);
        jheero.equipGear(jheero.getInventory().getGear(1));
        jheero.getResistance().setResCleaving(40);

        p.equipGear(p.getInventory().getGear(1));
        p.equipGear(p.getInventory().getGear(2));
        p.equipGear(p.getInventory().getGear(2));
        p.consumeItem(p.getInventory().get(0));
        Log.d("MainActivity", p.geteName());
        p.getInventory().add(new Burger(4));
        p.getInventory().add(new Pizza());
        p.seteHealth(100);
        SaveController.getInstance(this).saveEntity(p);
        p = (Player) SaveController.getInstance(this).loadEntity(p);

        SaveController.getInstance(this).saveEntity(jheero);
        Jheero test = (Jheero) SaveController.getInstance(this).loadEntity(jheero);
        jheero.getResistance().addResCleaving(13);


        UIController ui = UIController.getInstance();
        ui.mainTextWindow.setText(p.getInventory().toString());
    }


}
