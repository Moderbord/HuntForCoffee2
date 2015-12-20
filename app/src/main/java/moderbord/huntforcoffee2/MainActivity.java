package moderbord.huntforcoffee2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import moderbord.huntforcoffee2.Controller.SaveController;
import moderbord.huntforcoffee2.Controller.UIController;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.PlayerBuilder;
import moderbord.huntforcoffee2.Model.item.Burger;
import moderbord.huntforcoffee2.Model.item.Pizza;
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
        Player p = new PlayerBuilder().seteName("pontus").createPlayer();
        p.getInventory().add(new Burger(4));
        p.getInventory().get(0);
        Weapon weapon = new WeaponBuilder().setWepType("Sword").setDmgType("Piercing").createWeapon();
        weapon.setName("Trollbane");
        Weapon weapons = new WeaponBuilder().setWepType("LargeSword").setDmgType("Hacking").createWeapon();
        weapons.setName("Giant Slayer");
        Weapon weaponed = new WeaponBuilder().setWepType("Axe").setDmgType("Slashing").createWeapon();
        weaponed.setName("Ice");
        p.getInventory().add(weapon);
        p.getInventory().add(weapons);
        p.getInventory().add(weaponed);
        SaveController.getInstance(this).savePlayer(p);
        p = SaveController.getInstance(this).loadPlayer("pontus");
        p.equipGear(p.getInventory().getGear(1));
        //p.equipGear(p.getInventory().getGear(2));
        //p.equipGear(p.getInventory().getGear(2));
        p.consumeItem(p.getInventory().get(0));
        Log.d("MainActivity", p.geteName());
        p.getInventory().add(new Burger(4));
        p.getInventory().add(new Pizza());
        p.seteHealth(100);
        UIController ui = UIController.getInstance();
        ui.mainTextWindow.setText(p.getInventory().toString());
    }


}
