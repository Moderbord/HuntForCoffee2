package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;

/**
 * Created by Moderbord on 2016-06-24.
 */
public class CC implements OverTimeEffect {

    private Skill source;
    private Entity target;
    private int duration, effect, status;

    public CC(Skill source, Entity target, int duration, int effect, int status) {
        this.source = source;
        this.target = target;
        this.duration = duration;
        this.effect = effect;
        this.status = status;

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

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public void tickEffect() {
        String append = duration < 1 ? "" : target.geteName() + " is affected by " + source.tickDesc() + "\n\n";
        duration--;
        EventController.text.append(append);
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public int duration() {
        return duration;
    }
}
