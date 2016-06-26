package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-06-24.
 */

/*public interface OverTimeEffect {

    void tickEffect();
    int getStatus();
    int duration();

}*/

public class OverTimeEffect {

    private Skill source;
    private Entity target;
    private int duration, effect, status, type;

    public OverTimeEffect(Skill source, Entity target, int duration, int effect, int status, int type) {
        this.source = source;
        this.target = target;
        this.duration = duration;
        this.effect = effect;
        this.status = status;
        this.type = type;

        target.getCombatStats().applyStatus(status);
    }

    public Skill getSource() {
        return source;
    }

    public void setSource(Skill source) {
        this.source = source;
    }

    public Entity getTarget() {
        return target;
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void tickEffect() {
        switch (type){
            case C.SKILL_TYPE_DOT:
                target.damaged(effect);
                duration--;
                EventController.text.append(target.geteName() + " was damaged by " + effect + " from " + source.tickDesc() + "\n\n");
                break;
            case C.SKILL_TYPE_HOT:
                target.healed(effect);
                duration--;
                EventController.text.append(target.geteName() + " got healed by " + effect + " from " + source.tickDesc() + "\n\n");
                break;
            case C.SKILL_TYPE_CC:
                String append = duration < 1 ? "" : target.geteName() + " is affected by " + source.tickDesc() + "\n\n";
                duration--;
                EventController.text.append(append);
                break;
            default:
                break;
        }


    }

}
