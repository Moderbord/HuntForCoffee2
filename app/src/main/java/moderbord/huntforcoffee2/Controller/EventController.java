package moderbord.huntforcoffee2.Controller;

import android.view.View;

import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.Recipes;
import moderbord.huntforcoffee2.Model.events.CharacterCreation;
import moderbord.huntforcoffee2.Model.events.Forrest;
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

    protected static Player player;

    public void initCharacterCreation(){
        ui.disableAllButtons();
        ui.clearActionButtons();
        ui.setButtonText(1, "New Character");

        ui.button1.setOnClickListener(new CharacterCreation(){
            @Override
            public void onClick(View v) {
                stepOne();
            }
        });

    }

    public void initGamedfgdfg() {
        ui.clearActionButtons();
        ui.mainText.setText("Welcome to Jurassic Park " + player.geteName() + "!");

        ManaPotion manaPotion = new ManaPotion();

        Weapon bigSword = new WeaponBuilder().setName("Iron Greatsword").setTwoHanded(true).createWeapon();
        Weapon bigAxe = new WeaponBuilder().setName("Cobalt Greataxe").setTwoHanded(true).createWeapon();
        Weapon smallSword = new WeaponBuilder().setName("Iron Sword").createWeapon();
        Weapon smallDagger = new WeaponBuilder().setName("Silver Dagger").createWeapon();
        Weapon smallHatchet = new WeaponBuilder().setName("Golden Hatchet").setWepType(Constants.WEAPON_TYPE_AXE).createWeapon();
        Weapon bow = new WeaponBuilder().setWepType(Constants.WEAPON_TYPE_BOW).setGearSlot(Constants.GEAR_SLOT_BACK_WEP).setName("Wooden Bow").createWeapon();
        Weapon rifle = new WeaponBuilder().setWepType(Constants.WEAPON_TYPE_CROSSBOW).setGearSlot(Constants.GEAR_SLOT_BACK_WEP).setName("Military Rifle").createWeapon();


        ui.button1.setText(Constants.LOCATION_FORREST);
        ui.button1.setOnClickListener(new Forrest() {
            @Override
            public void onClick(View v) {
                entry();
            }
        });

    }

}
