package moderbord.huntforcoffee2.Controller;

import android.view.View;

import java.util.ArrayList;

import moderbord.huntforcoffee2.Model.CombatStats;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.EntityBuilder;
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
    private Entity attacker;
    private Entity target;
    private CombatStats ecs;

    public int round = 0, tmp = 0;
    private int attackType;

    private Entity first = new EntityBuilder().seteName("Philip").seteHealth(35).seteAgility(25).seteQuickness(36).createEntity();
    private Entity second = new EntityBuilder().seteName("Lögdal").seteHealth(46).seteAgility(70).seteQuickness(45).createEntity();
    private Entity third = new EntityBuilder().seteName("Victor").seteHealth(57).seteAgility(46).seteQuickness(68).createEntity();
    private Entity fourth = new EntityBuilder().seteName("Hanna").seteHealth(34).seteAgility(23).seteQuickness(41).createEntity();
    private Entity fifth = new EntityBuilder().seteName("Draken").seteHealth(156).seteAlly(false).seteAgility(19).seteQuickness(12).createEntity();

    public void prepareCombat() {
        entityList.add(first);
        entityList.add(second);
        entityList.add(third);
        entityList.add(fourth);
        entityList.add(fifth);

        ui.setEvent(nextEntity, 1, "Begin");
    }

    View.OnClickListener nextEntity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ui.clearActionButtons();
            // Going through each entity in list and let them take action. Going to be replaces by initiative
            if (tmp == entityList.size()) {
                tmp = 0;
            }
            attacker = entityList.get(tmp);

            // Display combat status
            for (Entity e : entityList) {
                String name = e.geteName();
                int health = e.geteHealth();
                text.append(name + "  Health: " + health + "\n\n");
            }
            text.submit();

            ui.setDescriptionText(attacker.geteName());
            ui.setEvent(new AttackListener(), 1, "Attack");
        }
    };

    public void targetSelection() {
        ui.clearActionButtons();
        int x = 1;
        boolean allied = attacker.isAlly();
        for (Entity e : entityList) {

            switch (attackType) {
                case C.ATTACK_TYPE_ENEMY:
                    if (!e.isAlly() == allied) {
                        ui.setEvent(new TargetListener(e), x, e.geteName());
                        x++;
                    }
                    break;
                case C.ATTACK_TYPE_ALLIED:
                    if (e.isAlly() == allied) {
                        ui.setEvent(new TargetListener(e), x, e.geteName());
                        x++;
                    }
                    break;
                case C.ATTACK_TYPE_ALL:
                    ui.setEvent(new TargetListener(e), x, e.geteName());
                    x++;
                    break;
                default:
                    break;
            }

            ui.setEvent(nextEntity, 10, "Back");
        }
    }

    public void result() {
        ui.clearActionButtons();
        text.append(attacker.geteName() + " attacks " + target.geteName() + " for damage");
        text.submit();
        ui.setEvent(nextEntity, 1, "Next");
        tmp++;
    }

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
            attackType = 1;
            targetSelection();
        }
    }

}


