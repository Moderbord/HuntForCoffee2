package moderbord.huntforcoffee2.Model.events;

import android.view.View;
import android.widget.Button;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Utils.Constants;
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
            text.append("The lands of bla is in danger of the invading demons in the south. ");
            text.append("You have to make a choice of which side you want to support. ");
            text.append("\n\nWhat could it be?");
            text.submit();
            ui.setButtonEvent(alignmentChoice, 1, "Next");
        }
    };

    View.OnClickListener alignmentChoice = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            ui.setPortrait(Constants.PORTRAIT_DEFAULT);
            text.append("The good side is light...");
            text.append("\n\nThe evil side is dark...");
            text.append("\n\nWhat shall it be?");
            text.submit();
            ui.setButtonEvent(alignmentDescription, 1, Constants.ALIGNMENT_GOOD);
            ui.setButtonEvent(alignmentDescription, 2, Constants.ALIGNMENT_EVIL);
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
            ui.setButtonEvent(choice.equals(Constants.ALIGNMENT_GOOD) ? goodChoice : evilChoice, 1, "Next");
        }
    };

    View.OnClickListener goodChoice = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.append("The good side is light and touches these races");
            text.append("\n\nWhich one are you?");
            text.submit();
            ui.setButtonEvent(goodRace, 1, Constants.RACE_HUMAN);
            ui.setButtonEvent(goodRace, 2, Constants.RACE_ELF);
            ui.setButtonEvent(goodRace, 3, Constants.RACE_ORC);
        }
    };

    View.OnClickListener evilChoice = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            text.append("The evil side is dark");
            text.append("\n\nWhich one are you?");
            text.submit();
            ui.setButtonEvent(evilRace, 1, Constants.RACE_DEMON);
            ui.setButtonEvent(evilRace, 2, Constants.RACE_IMP);
            ui.setButtonEvent(evilRace, 3, Constants.RACE_KOBOLD);
        }
    };

    View.OnClickListener goodRace = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String choice = btn.getText().toString();
            player.seteRace(choice);

            text.append("A " + Utils.toLow(choice) + " it is huh?\n\n");

            if (choice.equals(Constants.RACE_HUMAN)){
                text.append("The demons nature is malicious and filled with evil intentions. They are slightly" +
                        " taller than the average human and puts their trust in their incredible strength." +
                        " Older and more powerful demons usually find an affinity for fire magic. Some have even" +
                        " been seen drawing power from the shadows.");
                ui.setPortrait(Constants.PORTRAIT_HUMAN_INTRO);
            } else if (choice.equals(Constants.RACE_ELF)){
                text.append("The imps are more trustworthy than demons and kobolds, nurturing their wisdom and" +
                        " intellect rather than other abilities. Learning about their enemies actually opens up" +
                        " a more diplomatic approach. However, this knowledge also makes them extremely dangerous.");
                ui.setPortrait(Constants.PORTRAIT_ELF_INTRO);
            } else {
                text.append("Kobolds are generally small and covered in a layer of protective scales. Their small frame" +
                        " and their agile tail makes them perfect in situation requiring great dexterity. This makes them" +
                        " favor smaller weapons and usually works behind enemy lines. ");
                ui.setPortrait(Constants.PORTRAIT_ORC_INTRO);
            }
            text.submit();
            ui.setButtonEvent(alignmentChoice, 5, "Back");
            ui.setButtonEvent(goodIntro, 6, "Next");
        }
    };

    View.OnClickListener evilRace = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            String choice = btn.getText().toString();
            player.seteRace(choice);

            text.append("A " + Utils.toLow(choice) + " it is huh?\n\n");

            if (choice.equals(Constants.RACE_DEMON)){
                text.append("The demons nature is malicious and filled with evil intentions. They are slightly" +
                        " taller than the average human and puts their trust in their incredible strength." +
                        " Older and more powerful demons usually find an affinity for fire magic. Some have even" +
                        " been seen drawing power from the shadows.");
                ui.setPortrait(Constants.PORTRAIT_DEMON_INTRO);
            } else if (choice.equals(Constants.RACE_IMP)){
                text.append("The imps are more trustworthy than demons and kobolds, nurturing their wisdom and" +
                        " intellect rather than other abilities. Learning about their enemies actually opens up" +
                        " a more diplomatic approach. However, this knowledge also makes them extremely dangerous.");
                ui.setPortrait(Constants.PORTRAIT_IMP_INTRO);
            } else {
                text.append("Kobolds are generally small and covered in a layer of protective scales. Their small frame" +
                        " and their agile tail makes them perfect in situation requiring great dexterity. This makes them" +
                        " favor smaller weapons and usually works behind enemy lines. ");
                ui.setPortrait(Constants.PORTRAIT_KOBOLD_INTRO);
            }
            text.submit();
            ui.setButtonEvent(alignmentChoice, 5, "Back");
            ui.setButtonEvent(evilIntro, 6, "Next");
        }
    };

    View.OnClickListener goodIntro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            ui.setPortraitDefault();

        }
    };

    View.OnClickListener evilIntro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            ui.setPortraitDefault();

        }
    };


}
