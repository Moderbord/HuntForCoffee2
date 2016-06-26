package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-06-24.
 */
public class Revive extends Skill {

    public static Revive instance;

    public static Revive getInstance(){
        if (instance == null){
            instance = new Revive("Revive", C.TARGET_FORM_DEFEATED, C.SKILL_TYPE_HOT, 0);
        }
        return instance;
    }

    public Revive(String skillName, int targetForm, int skillType, int skillDuration) {
        super(skillName, targetForm, skillType, skillDuration);
    }

    @Override
    public void getSkillEffect(Entity caster, Entity target) {
        target.getCombatStats().setIsDefeated(false);
        target.getCombatStats().setIsDown(false);
        target.getCombatStats().setIsActive(true);
        target.healed(15);
        EventController.text.append(target.geteName() + " got revived by " + caster.geteName());
    }
}
