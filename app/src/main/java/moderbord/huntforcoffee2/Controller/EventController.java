package moderbord.huntforcoffee2.Controller;

import android.content.Intent;
import android.view.View;

import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.Recipes;
import moderbord.huntforcoffee2.Model.events.Forrest;
import moderbord.huntforcoffee2.Model.item.IronOre;
import moderbord.huntforcoffee2.Model.item.ManaPotion;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Model.item.WeaponBuilder;
import moderbord.huntforcoffee2.Utils.Constants;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class EventController {

    public static UIController ui = UIController.getInstance();
    public static Recipes recipes = Recipes.getInstance(); // Move elsewhere?

    protected static Player player = new EntityBuilder().seteName("Pontus").createEntityPlayer();

    public void initGame() {
        ui.mainText.setText("Welcome to Jurassic Park " + player.geteName() + "!");

        player.seteHealth(100);

        player.getInventory().add(new IronOre(16));
        player.combineItem(Constants.RECIPE_IRON_BAR);
        player.combineItem(Constants.RECIPE_IRON_BAR);
        player.combineItem(Constants.RECIPE_IRON_BAR);
        player.combineItem(Constants.RECIPE_IRON_BAR);
        player.combineItem(Constants.RECIPE_IRON_BAR);

        ManaPotion manaPotion = new ManaPotion();

        Weapon bigSword = new WeaponBuilder().setName("Iron Greatsword").setTwoHanded(true).createWeapon();
        Weapon bigAxe = new WeaponBuilder().setName("Cobalt Greataxe").setTwoHanded(true).createWeapon();
        Weapon smallSword = new WeaponBuilder().setName("Iron Sword").createWeapon();
        Weapon smallDagger = new WeaponBuilder().setName("Silver Dagger").createWeapon();
        Weapon smallHatchet = new WeaponBuilder().setName("Golden Hatchet").setWepType(Constants.WEAPON_TYPE_AXE).createWeapon();
        Weapon bow = new WeaponBuilder().setWepType(Constants.WEAPON_TYPE_BOW).setGearSlot(Constants.GEAR_SLOT_BACK_WEP).setName("Wooden Bow").createWeapon();
        Weapon rifle = new WeaponBuilder().setWepType(Constants.WEAPON_TYPE_CROSSBOW).setGearSlot(Constants.GEAR_SLOT_BACK_WEP).setName("Military Rifle").createWeapon();
        player.getInventory().add(bigSword);
        player.getInventory().add(bigAxe);
        player.getInventory().add(smallSword);
        player.getInventory().add(smallDagger);
        player.getInventory().add(smallHatchet);
        player.getInventory().add(bow);
        player.getInventory().add(rifle);
        player.getInventory().add(manaPotion);


        player.combineItem(Constants.RECIPE_ARMOUR_WARDEN);


        ui.button1.setText("Forrest");
        ui.button1.setOnClickListener(new Forrest() {
            @Override
            public void onClick(View v) {
                entry();
            }
        });

    }

}
