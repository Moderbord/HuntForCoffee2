package moderbord.huntforcoffee2.Controller;

import android.util.Log;

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

    private static CombatController instance;

    public static CombatController getInstance() {
        if (instance == null) {
            instance = new CombatController();
        }
        return instance;
    }

    private final String TAG = "Combat";
    public static ArrayList<Entity> entityList = new ArrayList<>();
    public boolean combat;

    private Entity first = new EntityBuilder().seteName("10").createEntity();
    private Entity second = new EntityBuilder().seteName("30").createEntity();
    private Entity third = new EntityBuilder().seteName("20").createEntity();
    private Entity fourth = new EntityBuilder().seteName("130").createEntity();
    private Entity fifth = new EntityBuilder().seteName("40").createEntity();

    public void prepareCombat() {
        first.getCombatStats().setInitiative(10);
        second.getCombatStats().setInitiative(30);
        third.getCombatStats().setInitiative(20);
        fourth.getCombatStats().setInitiative(130);
        fifth.getCombatStats().setInitiative(40);

        entityList.add(first);
        entityList.add(second);
        entityList.add(third);
        entityList.add(fourth);
        entityList.add(fifth);

        initiateCombat();
    }

    public void initiateCombat() {
        combat = true;
        while (combat) {
            Log.d(TAG, "initiateCombat: Combat is active");
            sortEntityList();
            for (Entity e : entityList) {
                Log.d(TAG, "initiateCombat: entity " + e.geteName());
                CombatStats ecs = e.getCombatStats();
                if (ecs.isActive()) {
                    //TODO isEnemy & Action
                    Log.d(TAG, "initiateCombat: Action");
                    ecs.setInitiative(ecs.getInitBase());
                }
                //TODO effect each round goes here
                Log.d(TAG, "initiateCombat: Effect");
            }
            //TODO victory/lose condition goes here
            Log.d(TAG, "initiateCombat: win/lose check");
        }
    }

    private void sortEntityList() {
        Log.d(TAG, "sortEntityList: Sorting list");
        for (Entity e : entityList) {
            CombatStats ecs = e.getCombatStats();
            if (ecs.isDown()) {
                Log.d(TAG, "sortEntityList: Entity is down");
                ecs.setIsActive(false);
                ecs.setInitiative(0);
            } else {
                Log.d(TAG, "sortEntityList: Entity is active");
                calculateInitiative(e);
            }
        }

        //TODO sort entityList
        Collections.sort(entityList, new Comparator<Entity>() {
            @Override
            public int compare(Entity lhs, Entity rhs) {
                Log.d(TAG, "compare: comparing entities");
                int x = lhs.getCombatStats().getInitiative() > rhs.getCombatStats().getInitiative() ? -1 : 1;
                return x;
            }
        });

    }

    private void calculateInitiative(Entity e) {
        Log.d(TAG, "calculateInitiative: Calculating initiative");
    }

}
