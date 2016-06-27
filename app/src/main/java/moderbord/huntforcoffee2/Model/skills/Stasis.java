package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-23.
 */

public class Stasis extends Skill {

    private static Stasis instance;

    public static Stasis getInstance() {
        if (instance == null){
            instance = new Stasis("Stasis", C.TARGET_FORM_ALL, C.SKILL_TYPE_CC, 50);
        }
        return instance;
    }

    public Stasis(String skillName, int targetForm, int skillType, int skillCost) {
        super(skillName, targetForm, skillType, skillCost);
    }

    @Override
    public void getSkillEffect(Entity caster, Entity target) {
        int dmg = 0;
        int duration = 2;
        EventController.text.append(caster.geteName() + " casts stasis on " + target.geteName() + ". " + target.geteName() + " becomes" +
                " untargetable and unable to take any action.");
        target.getCombatStats().addOTE(new OverTimeEffect(this, target, duration, dmg, C.STATUS_STASIS, C.SKILL_TYPE_CC));

        caster.manaCost(skillCost);
    }

    @Override
    public boolean skillCastAllowance(Entity caster) {
        return caster.geteMana() >= skillCost;
    }

}
