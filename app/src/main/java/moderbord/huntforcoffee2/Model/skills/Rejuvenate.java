package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-23.
 */
public class Rejuvenate extends Skill {

    private static Rejuvenate instance;

    public static Rejuvenate getInstance() {
        if (instance == null){
            instance = new Rejuvenate("Rejuvenate", C.TARGET_FORM_ALLIED, C.SKILL_TYPE_HOT, 2);
        }
        return instance;
    }

    public Rejuvenate(String skillName, int targetForm, int skillType, int skillDuration) {
        super(skillName, targetForm, skillType, skillDuration);
    }

    @Override
    public void getSkillEffect(Entity caster, Entity target) {
        target.healed(10);
        target.getCombatStats().addOTE(new OverTimeEffect(this, target, 2, 10, C.STATUS_HEALING, C.SKILL_TYPE_HOT));
        EventController.text.append(caster.geteName() + " cast rejuvenate on " + target.geteName() +
                " and was healed for " + 10); // Refactor
    }

}
