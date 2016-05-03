package moderbord.huntforcoffee2.Model;

/**
 * Created by Oscilla on 2016-04-16.
 */

public class CombatStats {

    private boolean isActive, isDown, isDefeated;
    private int initiative, initBase, initGain;

    public CombatStats() {
        this.isActive = true;
        this.isDown = false;
        this.isDefeated = false;
        this.initiative = 0;
        this.initBase = 0;
        this.initGain = 0;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setIsDown(boolean isDown) {
        this.isDown = isDown;
    }

    public boolean isDefeated() {
        return isDefeated;
    }

    public void setIsDefeated(boolean isDefeated) {
        this.isDefeated = isDefeated;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getInitBase() {
        return initBase;
    }

    public void setInitBase(int initBase) {
        this.initBase = initBase;
    }

    public int getInitGain() {
        return initGain;
    }

    public void setInitGain(int initGain) {
        this.initGain = initGain;
    }
}
