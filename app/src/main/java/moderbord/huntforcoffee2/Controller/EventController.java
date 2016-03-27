package moderbord.huntforcoffee2.Controller;

import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.Recipes;
import moderbord.huntforcoffee2.Model.events.CharacterCreation;
import moderbord.huntforcoffee2.Model.events.Forrest;
import moderbord.huntforcoffee2.Model.events.GoldenRoad;
import moderbord.huntforcoffee2.Model.events.Graveyard;
import moderbord.huntforcoffee2.Model.item.ManaPotion;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Model.item.WeaponBuilder;
import moderbord.huntforcoffee2.Utils.Constants;

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

        ui.setButtonEvent(cc.intro, 1, "New Character");
        ui.setPortraitDefault();
    }

    public void initGamedfgdfg() {
        ManaPotion manaPotion = new ManaPotion();

        Weapon bigSword = new WeaponBuilder().setName("Iron Greatsword").setTwoHanded(true).createWeapon();
        Weapon bigAxe = new WeaponBuilder().setName("Cobalt Greataxe").setTwoHanded(true).createWeapon();
        Weapon smallSword = new WeaponBuilder().setName("Iron Sword").createWeapon();
        Weapon smallDagger = new WeaponBuilder().setName("Silver Dagger").createWeapon();
        Weapon smallHatchet = new WeaponBuilder().setName("Golden Hatchet").setWepType(Constants.WEAPON_TYPE_AXE).createWeapon();
        Weapon bow = new WeaponBuilder().setWepType(Constants.WEAPON_TYPE_BOW).setGearSlot(Constants.GEAR_SLOT_BACK_WEP).setName("Wooden Bow").createWeapon();
        Weapon rifle = new WeaponBuilder().setWepType(Constants.WEAPON_TYPE_CROSSBOW).setGearSlot(Constants.GEAR_SLOT_BACK_WEP).setName("Military Rifle").createWeapon();
    }

}
