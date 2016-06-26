package moderbord.huntforcoffee2.Model;

import java.util.ArrayList;
import java.util.Iterator;

import moderbord.huntforcoffee2.Model.skills.OverTimeEffect;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Oscilla on 2016-04-16.
 */

public class CombatStats {

    private boolean isActive, isDown, isDefeated, isTargetable;
    private int initiative, initBase, initGain;
    private boolean healed, poisoned, burning, stunned, incapacitated;
    private Tick tick;

    public CombatStats() {
        this.isActive = true;
        this.isDown = false;
        this.isDefeated = false;
        this.isTargetable = true;
        this.initiative = 0;
        this.initBase = 0;
        this.initGain = 0;
        this.healed = false;
        this.poisoned = false;
        this.burning = false;
        this.stunned = false;
        this.incapacitated = false;
        this.tick = new Tick();
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

    public boolean isTargetable() {
        return isTargetable;
    }

    public void setTargetable(boolean targetable) {
        isTargetable = targetable;
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

    public boolean isHealed() {
        return healed;
    }

    public void setHealed(boolean healed) {
        this.healed = healed;
    }

    public void addOTE(OverTimeEffect ote){
        tick.add(ote);
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(boolean burning) {
        this.burning = burning;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public boolean isIncapacitated() {
        return incapacitated;
    }

    public void setIncapacitated(boolean incapacitated) {
        this.incapacitated = incapacitated;
    }

    public void resetStatus(){
        burning = false;
        healed = false;
        poisoned = false;
        stunned = false;
        isTargetable = true;
        incapacitated = false;
    }

    public void applyStatus(int status){
        switch (status){
            case C.STATUS_BURNING:
                burning = true;
                break;
            case C.STATUS_HEALING:
                healed = true;
                break;
            case C.STATUS_POISONED:
                poisoned = true;
                break;
            case C.STATUS_STUNNED:
                stunned = true;
                break;
            case C.STATUS_UNTARGETABLE:
                isTargetable = false;
                break;
            case C.STATUS_STASIS:
                isTargetable = false;
                incapacitated = true;
            default:
                break;
        }
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        if (isDefeated()){
            sb.append(" -- Defeated --");
        } else {
            sb.append(healed ? " -Healing " : "");
            sb.append(poisoned ? " -Poisoned " : "");
            sb.append(burning ? " -Burning " : "");
            sb.append(stunned ? " -Stunned " : "");
            sb.append(incapacitated ? " -Incapacitated " : "");
        }
        return sb.toString();
    }

    public void effectTick() {
        tick.ticking();
    }

    public void cleanseTicks(){
        tick.cleanse();
    }

    private class Tick extends ArrayList<OverTimeEffect> {

        void ticking(){
            resetStatus();
            for (Iterator<OverTimeEffect> iter = this.iterator(); iter.hasNext(); ){
                OverTimeEffect ote = iter.next();
                if (ote.getDuration() < 1){
                    iter.remove();
                } else {
                    applyStatus(ote.getStatus());
                }
                ote.tickEffect();
            }
        }

        void cleanse(){
            this.clear();
        }

    }

}
