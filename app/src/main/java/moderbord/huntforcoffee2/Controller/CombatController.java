package moderbord.huntforcoffee2.Controller;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import moderbord.huntforcoffee2.Model.CombatStats;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.EntityBuilder;

/**
 * Created by Oscilla on 2016-04-15.
 */
public class CombatController extends EventController {

    private final String TAG = "Combat";

    private static CombatController instance;

    public static CombatController getInstance() {
        if (instance == null) {
            instance = new CombatController();
        }
        return instance;
    }

    public static ArrayList<Entity> entityList = new ArrayList<>();
    private Entity attacker;
    private Entity target;
    private CombatStats ecs;

    public boolean combat;
    public int round = 0;

    private Entity first = new EntityBuilder().seteName("Peter").seteHealth(35).seteAgility(25).seteQuickness(36).createEntity();
    private Entity second = new EntityBuilder().seteName("Jack").seteHealth(46).seteAgility(70).seteQuickness(45).createEntity();
    private Entity third = new EntityBuilder().seteName("Matilda").seteHealth(57).seteAgility(46).seteQuickness(68).createEntity();
    private Entity fourth = new EntityBuilder().seteName("Hariett").seteHealth(34).seteAgility(23).seteQuickness(41).createEntity();
    private Entity fifth = new EntityBuilder().seteName("Draken").seteHealth(156).seteAlly(false).seteAgility(19).seteQuickness(12).createEntity();

    public void prepareCombat() {
        entityList.add(first);
        entityList.add(second);
        entityList.add(third);
        entityList.add(fourth);
        entityList.add(fifth);

        for (Entity e : entityList){
            updateBaseInitiative(e);
        }

        displayCombat();
    }

    public void displayCombat() {
        /*round++; // Round counter

        if (round == 2){ // Initiative gain test (buff)
            entityList.get(4).seteAgility(100);
            entityList.get(4).seteQuickness(100);
            updateBaseInitiative(entityList.get(4));
        }*/
        sortEntityList();
        Log.d(TAG, "displayCombat: Combat is active");


        for (Entity e : entityList){
            String name = e.geteName();
            int health = e.geteHealth();
            text.append(name + " " + health + "\n");
        }
        text.submit();
        ui.setEvent(nextTargetAction, 1, "Next");

    }

    private void testest(){
        /*for (Entity e : entityList) {
            Log.d(TAG, "displayCombat: entity " + e.geteName());
            ecs = e.getCombatStats();
            if (ecs.isActive()) {
                //TODO isEnemy & Action
                Log.d(TAG, "displayCombat: Action");
                if (e.isAlly()){
                    //TODO controlled Action
                    attacker = e;
                    showActionControls(e);
                } else {
                    //TODO randomized enemy Action
                    attacker = e;
                }
                ecs.setInitiative(ecs.getInitBase());
            }
            //TODO effect each round goes here
            Log.d(TAG, "displayCombat: Effect");
        }
        //TODO victory/lose condition goes here
        Log.d(TAG, "displayCombat: win/lose check");*/
    }

    private View.OnClickListener nextTargetAction = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            attacker = entityList.get(0);
            if (attacker.isAlly()){
                ui.setEvent(entityNormalAttack, 1, "Attack");
                ui.setEvent(entitySkills, 2, "Skills");
                ui.setEvent(entitySpells, 3, "Spells");
                ui.setEvent(actionYield, 8, "Yield");
                ui.setEvent(actionRun, 9, "Run");
            } else {
                String attack = attacker.geteName();
                text.append(attack + " attacks!");
                text.submit();
            }
        }
    };


    private void sortEntityList() {
        Log.d(TAG, "sortEntityList: Sorting list");
        for (Entity e : entityList) {
            ecs = e.getCombatStats();
            if (ecs.isDown() || ecs.isDefeated()) {
                Log.d(TAG, "sortEntityList: Entity is down");
                ecs.setIsActive(false);
                ecs.setInitiative(0);
            } else {
                Log.d(TAG, "sortEntityList: Entity is active");
                ecs.setIsActive(true);
                calculateInitiative(e);
            }
        }

        Collections.sort(entityList, new Comparator<Entity>() {
            @Override
            public int compare(Entity lhs, Entity rhs) {
                Log.d(TAG, "compare: comparing entities");
                int x = lhs.getCombatStats().getInitiative() > rhs.getCombatStats().getInitiative() ? -1 : 1;
                return x;
            }
        });

    }

    // Updates base initiative
    private void updateBaseInitiative(Entity e){
        ecs = e.getCombatStats();
        ecs.setInitBase(baseIni(e));
        ecs.setInitiative(ecs.getInitBase());
    }

    // The starting and base initiative
    private int baseIni(Entity e){
        int agi = e.geteAgility();
        int quick = e.geteQuickness();
        int i = agi / 4 + quick / 2;
        return i;
    }

    // Base initiative plus ini/round
    private void calculateInitiative(Entity e) {
        int agi = e.geteAgility();
        int quick = e.geteQuickness();
        ecs = e.getCombatStats();
        ecs.setInitGain(agi / 6 + quick / 3);
        //TODO combat effect here?
        Log.d(TAG, "calculateInitiative: Calculating initiative");
        ecs.setInitiative(ecs.getInitiative() + ecs.getInitGain());
    }

    // Sets an entity as defeated and check for win/lose conditions
    private void onDefeated(Entity e){
        ecs = e.getCombatStats();
        ecs.setIsDefeated(true);
        checkCombatStatus();
    }

    // Checks if player has won or lost combat
    private void checkCombatStatus() {
        boolean won = true;
        boolean lose = true;
        for (Entity e : entityList){
            ecs = e.getCombatStats();
            if (e.isAlly() && !ecs.isDefeated()){ // Not defeated
                lose = false;
            } else if (!e.isAlly() && !ecs.isDefeated()){ // Not ally and not defeated
                won = false;
            }
        }
        if (won){onWin();}
        if (lose){onLose();}
    }

    private void onWin() {
        combat = false;
    }

    private void onLose() {
        combat = false;
    }

    View.OnClickListener entityNormalAttack = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO normal attack, display each foe
        }
    };

    View.OnClickListener entitySkills = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO show entity skills
        }
    };

    View.OnClickListener entitySpells = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO show entity spells
        }
    };

    View.OnClickListener entityTarget = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO select target
        }
    };

    View.OnClickListener actionResult = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO display attack result
        }
    };

    View.OnClickListener actionRun = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO run from combat
        }
    };

    View.OnClickListener actionYield = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO yield to enemy
        }
    };

}
