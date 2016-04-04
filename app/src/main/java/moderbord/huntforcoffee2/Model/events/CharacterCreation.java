package moderbord.huntforcoffee2.Model.events;

import android.view.View;
import android.widget.Button;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Model.item.Shield;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Model.item.WeaponBuilder;
import moderbord.huntforcoffee2.Utils.C;
import moderbord.huntforcoffee2.Utils.Utils;

/**
 * Created by Oscilla on 2016-03-15.
 */

public class CharacterCreation extends EventController {

    private static CharacterCreation instance;

    public static CharacterCreation getInstance() {
        if (instance == null) {
            instance = new CharacterCreation();
        }
        return instance;
    }

    private Entity player = new EntityBuilder().createEntityPlayer();

    public View.OnClickListener intro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.append("The lands are stirring...");
            text.append("\n\nThey came from the east as the sun had settled below the horizon. Thousands" +
                    " had poured out from the wooden transports that had sailed from the far eastern" +
                    " countries. Provided with the darkness of dusk and with magical abilities they had remained" +
                    " unseen until it was too late for the orcs to mount a proper defence. With little to no" +
                    " choice the orcs fought bravely until only the chief had remained, all other dead or fleeing." +
                    " The troops had surrounded the chieftain, but wielding her giant cleaver no one had dared challenge" +
                    " her in close combat.");
            text.append("\n\nCaptain " + C.CHAR_AIDEN + " had emerged and unmounted his steed a safe distance" +
                    " from the chieftain. He had turned to the orc and bowed lightly, and in turn he had received" +
                    " a blank stare as the humongous cleaver had been raised at him. \"She orc\" he had said, and" +
                    " flicked his hand and a bolt had instantaneously darted its way and pierced the chieftains" +
                    " neck.");
            text.submit();
            ui.setEvent(alignmentChoice, 1, "Next");
        }
    };

    View.OnClickListener alignmentChoice = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            ui.setPortrait(C.PORTRAIT_DEFAULT);
            text.append("The good side is light...");
            text.append("\n\nThe evil side is dark...");
            text.append("\n\nWhat shall it be?");
            text.submit();
            ui.setEvent(alignmentDescription, 1, C.ALIGNMENT_GOOD);
            ui.setEvent(alignmentDescription, 2, C.ALIGNMENT_EVIL);
        }
    };

    View.OnClickListener alignmentDescription = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String choice = btn.getText().toString();
            player.seteAlignment(choice);

            text.append("So the " + Utils.toLow(choice) + " side it is?");
            text.submit();
            ui.clearActionButtons();
            ui.setEvent(choice.equals(C.ALIGNMENT_GOOD) ? goodChoice : evilChoice, 1, "Next");
        }
    };

    View.OnClickListener goodChoice = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.append("The good side is light and touches these races");
            text.append("\n\nWhich one are you?");
            text.submit();
            ui.setEvent(goodRace, 1, C.RACE_HUMAN);
            ui.setEvent(goodRace, 2, C.RACE_ELF);
            ui.setEvent(goodRace, 3, C.RACE_ORC);
        }
    };

    View.OnClickListener goodRace = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String choice = btn.getText().toString();
            player.seteRace(choice);

            text.append("A " + Utils.toLow(choice) + " it is huh?\n\n");

            if (choice.equals(C.RACE_HUMAN)){
                text.append("The humans are the currently the rulers of blabla with the capital city " + C.CITIES_DALARUST +
                        " as their seat of power. For centuries the humans have pushed the bounds of magic and nurtured their" +
                        " magical capabilities, accumulating some of the strongest wizards through time. As a result," +
                        " a majority of the armies consists of magicians and apprentices. If you are born without" +
                        " this ability, you are sent to the capital barracks for immediate close-combat training. The" +
                        " demon threat is of great importance for the humans, as they hope to establish permanent foothold" +
                        " in this region.");
                ui.setPortrait(C.PORTRAIT_HUMAN_INTRO);
            } else if (choice.equals(C.RACE_ELF)){
                text.append("The elven people have settled in the western province of blabla deep in the" +
                        " forrest. They are living in peace and harmony, in tune with the nature and wildlife." +
                        " Being nimble and dexterous, having quick and good reflexes combined with a keen eye and" +
                        " a hunters sense about their surroundings makes them a deadly enemy. Living by themselves" +
                        " the elves rarely leaves the bounds of the forrest. As of late, however, even they have" +
                        " recognized the growing threat of the southern invaders.");
                ui.setPortrait(C.PORTRAIT_ELF_INTRO);
            } else {
                text.append("The orcs previously held the lands of blabla before the humans came with their wizards" +
                        " and magical powers. Driven north the orcs now occupies about a third of the country." +
                        " Having cured their wounds and regained most of their strength they are still planning their next" +
                        " course of action. With incredible physical abilities, they are taller and much broader than" +
                        " their human counterparts, wielding the largest weapons in the land by far. The danger in the south" +
                        " has not yet become an issue for the orcs. Amongst the the chieftains the subject" +
                        " has barely raised an eyebrow.");
                ui.setPortrait(C.PORTRAIT_ORC_INTRO);
            }
            text.submit();
            ui.setEvent(alignmentChoice, 5, "Back");
            ui.setEvent(goodIntro, 6, "Next");
        }
    };

    View.OnClickListener goodIntro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            ui.setPortraitDefault();
            text.append("You dream about fire...");
            text.submit();
            if (player.geteRace().equals(C.RACE_HUMAN)) {
                ui.setEvent(humanIntro, 1, "Next");
            }
        }
    };

    View.OnClickListener evilChoice = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.append("The evil side is dark");
            text.append("\n\nWhich one are you?");
            text.submit();
            ui.setEvent(evilRace, 1, C.RACE_DEMON);
            ui.setEvent(evilRace, 2, C.RACE_IMP);
            ui.setEvent(evilRace, 3, C.RACE_KOBOLD);
        }
    };

    View.OnClickListener evilRace = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String choice = btn.getText().toString();
            player.seteRace(choice);

            text.append("A " + Utils.toLow(choice) + " it is huh?\n\n");

            if (choice.equals(C.RACE_DEMON)){
                text.append("The demons nature is malicious and filled with evil intentions. They are two heads" +
                        " taller than the average human and puts their trust in their incredible strength." +
                        " Older and more powerful demons usually find an affinity for fire magic. Some have even" +
                        " been seen drawing power from the shadows.");
                ui.setPortrait(C.PORTRAIT_DEMON_INTRO);
            } else if (choice.equals(C.RACE_IMP)){
                text.append("The imps are more trustworthy than demons and kobolds, nurturing their wisdom and" +
                        " intellect rather than their strength and physique. Learning about their enemies actually opens up" +
                        " for a more diplomatic approach. However, this knowledge also makes them extremely dangerous." +
                        " As they are in touch with the Arcane, imps are able to channel magical energies into the" +
                        " living world.");
                ui.setPortrait(C.PORTRAIT_IMP_INTRO);
            } else {
                text.append("Kobolds are generally small and covered in a layer of protective scales. Their small frame" +
                        " and their agile tail makes them perfect in situation requiring great dexterity. This makes them" +
                        " favor smaller weapons and usually works behind enemy lines. Kobolds tend to work alone or" +
                        " in small groups of three to four members and carry out missions that others would deem impossible.");
                ui.setPortrait(C.PORTRAIT_KOBOLD_INTRO);
            }
            text.submit();
            ui.setEvent(alignmentChoice, 5, "Back");
            ui.setEvent(evilIntro, 6, "Next");
        }
    };

    View.OnClickListener evilIntro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            ui.setPortraitDefault();

        }
    };

    View.OnClickListener humanIntro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            ui.setPortraitDefault();
            text.append("You watch as your opponent circles you in the training field. The sun is standing high" +
                    " in the sky, making both of your shadows appear as small disks beneath your feet. The heat" +
                    " is actively numbing your thinking and your thoughts feel as they're wading through quicksand." +
                    " \nCorporal " + C.CHAR_FYNN_S + " had of course chosen one of the warmest days for sparring." +
                    " As usual he was not present, letting his subordinate cover for him. He was probably off in" +
                    " some of the capital gardens enjoying the scenery whilst keeping cool in some pleasurable shade;" +
                    " the only way to keep a sane mind a day like this.");
            text.append("\n\n" + C.CHAR_QARA_F + " was therefore now in charge of training the new recruits. She is a " +
                    " serious fighter who doesn't accept sorry excuses from anyone. When she sense a weakness she" +
                    " pokes it until they constructs a defence." +
                    " \n\nOn the opposite side of the yard there are more recruits sparring in the midst of training" +
                    " dummies and archery butts. " + C.CHAR_QARA + " observes them attentively on top of the battlements," +
                    " occasionally shouting remarks or instructive commands at them. Your own opponent has inched his way" +
                    " closer and aims a heavy blow with his mace at your right shoulder. Reminded by your reflexes" +
                    " you try to parry the blow with your...");
            ui.setEvent(humanIntroWepChoice, 1, C.WEAPON_TYPE_GREATSWORD);
            ui.setEvent(humanIntroWepChoice, 2, C.WEAPON_TYPE_SWORD);
            ui.setEvent(humanIntroWepChoice, 3, C.WEAPON_TYPE_MACE);
            ui.setEvent(humanIntroWepChoice, 4, C.WEAPON_TYPE_SHIELD);
            text.submit();
        }
    };

    View.OnClickListener humanIntroWepChoice = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String choice = ui.getButtonText(v);
            ui.clearActionButtons();
            Weapon weapon;
            switch (choice) {
                case C.WEAPON_TYPE_GREATSWORD:
                    weapon = new WeaponBuilder().createGreatsword();
                    break;
                case C.WEAPON_TYPE_SWORD:
                    weapon = new WeaponBuilder().createSword();
                    break;
                case C.WEAPON_TYPE_MACE:
                    weapon = new WeaponBuilder().createMace();
                    break;
                case C.WEAPON_TYPE_SHIELD:
                    weapon = new WeaponBuilder().createShield();
                    break;
                default:
                    weapon = new WeaponBuilder().createWeapon();
                    break;
            }
            player.getInventory().add(weapon);
            boolean offHand = choice.equals(C.WEAPON_TYPE_SHIELD);
            player.equipWeapon(player.getInventory().gearByObject(weapon), offHand);
            player.toString();
            ui.setEvent(humanIntro, 1, "Next");
        }
    };

}
