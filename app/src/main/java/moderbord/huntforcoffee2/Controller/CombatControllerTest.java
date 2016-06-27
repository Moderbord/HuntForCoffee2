package moderbord.huntforcoffee2.Controller;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import moderbord.huntforcoffee2.Model.CombatStats;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.EntityBuilder;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Model.Skillset;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Model.item.WeaponBuilder;
import moderbord.huntforcoffee2.Model.skills.Bite;
import moderbord.huntforcoffee2.Model.skills.Fireball;
import moderbord.huntforcoffee2.Model.skills.NormalAttack;
import moderbord.huntforcoffee2.Model.skills.Rejuvenate;
import moderbord.huntforcoffee2.Model.skills.Revive;
import moderbord.huntforcoffee2.Model.skills.Sense;
import moderbord.huntforcoffee2.Model.skills.Stasis;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-10.
 */

public class CombatControllerTest extends EventController {

    private final String TAG = "Combat";

    private static CombatControllerTest instance;

    public static CombatControllerTest getInstance() {
        if (instance == null) {
            instance = new CombatControllerTest();
        }
        return instance;
    }

    public static ArrayList<Entity> entityList = new ArrayList<>();
    private Entity caster;
    private Entity target;
    private CombatStats ecs;
    private Skill loadedAction;

    public int round = 0, tmp = 0;
    public int targetForm;


    private Entity first = new EntityBuilder().seteName("Philip").seteGender(C.GENDER_MALE).seteMaxHealth(35).seteHealth(35).seteMana(60).seteMaxMana(60).seteAgility(25).seteQuickness(36).seteAlly(true).createEntity();
    private Entity second = new EntityBuilder().seteName("Lögdal").seteGender(C.GENDER_MALE).seteMaxHealth(70).seteHealth(10).seteMana(40).seteMaxMana(40).seteAgility(70).seteQuickness(45).seteAlly(true).createEntity();
    private Entity third = new EntityBuilder().seteName("Victor").seteGender(C.GENDER_MALE).seteMaxHealth(57).seteHealth(57).seteMana(20).seteMaxMana(20).seteAgility(46).seteQuickness(68).seteAlly(true).createEntity();
    private Entity fourth = new EntityBuilder().seteName("Hanna").seteGender(C.GENDER_FEMALE).seteMaxHealth(34).seteHealth(34).seteMana(120).seteMaxMana(120).seteAgility(23).seteQuickness(41).seteAlly(true).createEntity();
    private Entity fifth = new EntityBuilder().seteName("Draken").seteGender(C.GENDER_MALE).seteMaxHealth(156).seteHealth(156).seteMana(300).seteMaxMana(300).seteIntellect(50).seteFatigue(0).seteMaxFatigue(50).seteLevel(5).seteAlly(false).seteAgility(19).seteQuickness(12).createEntity();

    public void prepareCombat() {
        Weapon bigSword = new WeaponBuilder().setName("Iron Greatsword").setTwoHanded(true).createWeapon();
        Weapon bigAxe = new WeaponBuilder().setName("Cobalt Greataxe").setTwoHanded(true).createWeapon();
        Weapon smallSword = new WeaponBuilder().setName("Iron Sword").createWeapon();
        Weapon smallDagger = new WeaponBuilder().setName("Silver Dagger").setWepType(C.WEAPON_TYPE_DAGGER).createWeapon();
        Weapon smallHatchet = new WeaponBuilder().setName("Golden Hatchet").setWepType(C.WEAPON_TYPE_AXE).createWeapon();
        Weapon bow = new WeaponBuilder().setWepType(C.WEAPON_TYPE_BOW).setGearSlot(C.GEAR_SLOT_BACK_WEP).setName("Wooden Bow").createWeapon();
        Weapon rifle = new WeaponBuilder().setWepType(C.WEAPON_TYPE_CROSSBOW).setGearSlot(C.GEAR_SLOT_BACK_WEP).setName("Military Rifle").createWeapon();
        Weapon rClaw = new WeaponBuilder().setWepType(C.WEAPON_TYPE_CLAWS).setGearSlot(C.GEAR_SLOT_MAIN_WEP).setName("left claw").setMinDmg(10).setMaxDmg(20).createWeapon();
        Weapon lClaw = new WeaponBuilder().setWepType(C.WEAPON_TYPE_CLAWS).setGearSlot(C.GEAR_SLOT_OFF_WEP).setName("right claw").setMinDmg(10).setMaxDmg(20).createWeapon();

        first.receiveItem(bigSword);
        first.equipWeapon(bigSword, false);
        second.receiveItem(smallSword);
        second.receiveItem(smallDagger);
        second.equipWeapon(smallSword, false);
        second.equipWeapon(smallDagger, true);
        third.receiveItem(smallHatchet);
        third.equipWeapon(smallHatchet, true);
        fourth.receiveItem(bigAxe);
        fourth.receiveItem(bigSword);
        fourth.equipWeapon(bigSword, false);
        fourth.equipWeapon(bigAxe, false);

        fifth.receiveItem(rClaw);
        fifth.receiveItem(lClaw);
        fifth.equipWeapon(rClaw, false);
        fifth.equipWeapon(lClaw, true);

        entityList.add(first);
        entityList.add(second);
        entityList.add(third);
        entityList.add(fourth);
        entityList.add(fifth);
        fifth.addSkill(Fireball.getInstance());
        fifth.addSkill(Stasis.getInstance());
        fifth.addSkill(Bite.getInstance());
        second.addSkill(Stasis.getInstance());
        first.addSkill(Rejuvenate.getInstance());
        third.addSkill(Sense.getInstance());
        fourth.addSkill(Revive.getInstance());
        first.getResistance().setResFire(10);

        ui.setEvent(nextEntity, 1, "Begin");
    }

    View.OnClickListener nextEntity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            setNextEntity();
            displayCombatStatus();
            displayCasterActions();
        }
    };

    View.OnClickListener backPress = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            displayCasterActions();
        }
    };

    public void setNextEntity(){
        // Going through each entity in list and let them take action. Going to be replaces by initiative
        if (tmp == entityList.size()) {
            tmp = 0;
        }

        caster = entityList.get(tmp);
        ecs = caster.getCombatStats();
        ecs.effectTick();
        defeatCheck(caster);
        while (!ecs.isActive() || ecs.isDefeated() || ecs.isDown() || ecs.isStunned() || ecs.isIncapacitated()){ // If target isn't active, is down??, or is stunned
            tmp++;
            tmp = entityList.size() == tmp ? 0 : tmp;
            caster = entityList.get(tmp);
            ecs = caster.getCombatStats();
            ecs.effectTick(); //TODO move check here?
            defeatCheck(caster);
        }
    }

    public void displayCombatStatus(){
        String separator = "\n--------------------------------------------\n\n";
        text.append(separator);
        for (Entity e : entityList) {
            String name = e.geteName();
            int health = e.geteHealth();
            int mana = e.geteMana();
            text.append(name + "  Health: " + health + "  Mana: " + mana + "  " + e.getCombatStats().getStatus() + "\n\n");
        }
        text.submit();
    }

    public void displayCasterActions(){
        ui.setDescriptionText(caster.geteName());
        ui.setEvent(new AttackListener(), 1, "Attack");
        ui.setEvent(skillSelection, 2, "Skills");
        ui.setEvent(waitAction, 8, "Wait");
        if (caster.getSkillset().size() == 0) {
            ui.disableButton(ui.button2);
        }
    }

    public void targetSelection() {
        ui.clearActionButtons();
        int x = 1; // Makes the targets appear from correct button (nmr 1)
        boolean allied = caster.isAlly();
        for (Entity e : entityList) {
            ecs = e.getCombatStats();
            boolean disabled = ecs.isDefeated() || !ecs.isTargetable();

            switch (targetForm) {
                case C.TARGET_FORM_ENEMY:
                    if (!e.isAlly() == allied) { // Enemy target
                        ui.setEvent(new TargetListener(e), x, e.geteName(), disabled);
                        x++;
                    }
                    break;
                case C.TARGET_FORM_ALLIED: // Friendly target
                    if (e.isAlly() == allied) {
                        ui.setEvent(new TargetListener(e), x, e.geteName(), disabled);
                        x++;
                    }
                    break;
                case C.TARGET_FORM_ALL: // All entities is targetable
                    ui.setEvent(new TargetListener(e), x, e.geteName(), disabled);
                    x++;
                    break;
                /*case C.TARGET_FORM_SELF: // Self targeting
                    target = caster; // TODO self targeting. Same as TargetListener?? (simple)
                    x++;
                    result();
                    break;
                case C.TARGET_FORM_MULTI:
                    x++;
                    break;*/
                case C.TARGET_FORM_DEFEATED:
                    if (e.getCombatStats().isDefeated() && e.isAlly()){
                        ui.setEvent(new TargetListener(e), x, e.geteName());
                        x++;
                    }
                    break;

                default:
                    break;
            }
        }
        ui.setEvent(backPress, 10, "Back");
    }

    public void result() {
        ui.clearActionButtons();
        loadedAction.getSkillEffect(caster, target);
        text.submit();
        ui.setEvent(nextEntity, 1, "Next");
        tmp++;

        defeatCheck();
    }

    private View.OnClickListener waitAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            tmp++;
            text.append(caster.geteName() + " waits " + caster.hisHer() + " turn");
            text.submit();
            ui.setEvent(nextEntity, 1, "Next");
        }
    };

    private class TargetListener implements View.OnClickListener {

        private Entity entity;

        public TargetListener(Entity e) {
            this.entity = e;
        }

        @Override
        public void onClick(View v) {
            target = entity;
            result();
        }
    }

    private class AttackListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            loadedAction = NormalAttack.getInstance();
            targetForm = C.TARGET_FORM_ENEMY;
            targetSelection();
        }
    }

    private View.OnClickListener skillSelection = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            Skillset skillset = caster.getSkillset();
            int x = 1;
            for (Skill s: skillset){
                boolean clearCost = !s.skillCastAllowance(caster);
                ui.setEvent(new SkillListener(s), x, s.getSkillName(), clearCost);
                x++;
            }
            ui.setEvent(backPress, 10, "Back");
        }
    };

    private class SkillListener implements View.OnClickListener {

        private Skill skill;

        public SkillListener(Skill skill) {
            this.skill = skill;
        }

        @Override
        public void onClick(View v) {
            loadedAction = skill;
            targetForm = skill.getTargetForm();
            targetSelection();
        }
    }

    private void defeatCheck(Entity e){
        if (e.geteHealth() <= 0){
            onDefeated(e);
        }
    }

    private void defeatCheck(){
        for (Entity e : entityList){
            if (e.geteHealth() <= 0){
                onDefeated(e);
            }
        }
        checkCombatStatus();
    }

    // Sets an entity as defeated and check for win/lose conditions
    private void onDefeated(Entity e){
        ecs = e.getCombatStats();
        ecs.resetStatus();
        ecs.cleanseTicks();
        ecs.setIsDefeated(true);
        ecs.setIsActive(false);
        ecs.setIsDown(false);
    }

    // Checks if player has won or lost combat
    private void checkCombatStatus() {
        boolean won = true;
        boolean lose = true;
        for (Entity e : entityList){
            if (e.isAlly() && !e.getCombatStats().isDefeated()){ // If any ally is still alive
                lose = false;
            } else if (!e.isAlly() && !e.getCombatStats().isDefeated()){ // If any enemy is still standing
                won = false;
            }
        }
        if (won){onWin();}
        if (lose){onLose();}
    }

    private void onWin() {
        text.append("\n\nYou won!\n\n");
    }

    private void onLose() {
        text.append("\n\nYou lost!\n\n");
    }

}


