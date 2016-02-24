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

        Weapon bigSword = new WeaponBuilder().setName("Iron Greatsword").setTwoHanded(true).createWeapon();
        Weapon bigAxe = new WeaponBuilder().setName("Cobalt Greataxe").setTwoHanded(true).createWeapon();
        Weapon smallSword = new WeaponBuilder().setName("Iron Sword").createWeapon();
        Weapon smallDagger = new WeaponBuilder().setName("Silver Dagger").createWeapon();
        Weapon smallHatchet = new WeaponBuilder().setName("Golden Hatchet").createWeapon();
        Weapon bow = new WeaponBuilder().setWepType(Constants.WEAPON_TYPE_BOW).setGearSlot(Constants.GEAR_SLOT_BACK_WEP).setName("Wooden Bow").createWeapon();
        Weapon rifle = new WeaponBuilder().setWepType(Constants.WEAPON_TYPE_RIFLE).setGearSlot(Constants.GEAR_SLOT_BACK_WEP).setName("Military Rifle").createWeapon();

        p.getInventory().add(bigSword);
        p.getInventory().add(bigAxe);
        p.getInventory().add(smallSword);
        p.getInventory().add(smallDagger);
        p.getInventory().add(smallHatchet);
        p.getInventory().add(bow);
        p.getInventory().add(rifle);

        p.equipWeapon(p.getInventory().gearByItem(bigSword));
        p.equipWeapon(p.getInventory().gearByItem(smallSword));
        p.equipOffWeapon((Weapon) p.getInventory().gearByItem(smallHatchet));
        p.equipWeapon(p.getInventory().gearByItem(bigAxe));
        p.equipWeapon(p.getInventory().gearByItem(bow));
        p.equipWeapon(p.getInventory().gearByItem(rifle));
        p.equipOffWeapon((Weapon) p.getInventory().gearByItem(smallDagger));
        p.equipWeapon(p.getInventory().gearByItem(smallSword));


        Entity jheero = new EntityBuilder().createEntityJheero();
        Entity tut = jheero.returnMe();

        p.combineItem(Constants.RECIPE_ARMOUR_WARDEN);

        UniqueArmour warden = new ArmourBuilder().createUniqueArmour();
        jheero.getInventory().add(warden);
        jheero.equipArmour(jheero.getInventory().gearByIndex(0));

        SaveController.getInstance(this).saveEntity(p);
        p = (Player) SaveController.getInstance(this).loadEntity(p);

        p.getInventory().add(new Burger(2));
        p.consumeItem(p.getInventory().itemByName(Constants.ITEM_BURGER));
        p.consumeItem(p.getInventory().itemByName(Constants.ITEM_BURGER));
        p.equipArmour(p.getInventory().gearByName(Constants.ARMOUR_WARDEN));
        p.getInventory().add(new IronOre(8));
    }


}
