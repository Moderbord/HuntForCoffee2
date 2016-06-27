package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-23.
 */
public class Sense extends Skill {

    private static Sense instance;

    public static Sense getInstance() {
        if (instance == null){
            instance = new Sense("Sense", C.TARGET_FORM_ALL, C.SKILL_TYPE_BUFF, 10);
        }
        return instance;
    }

    public Sense(String skillName, int targetForm, int skillType, int skillCost) {
        super(skillName, targetForm, skillType, skillCost);
    }

    @Override
    public void getSkillEffect(Entity caster, Entity target) {
        EventController.text.append(caster.geteName() + " senses things about " + target.geteName());
        caster.manaCost(skillCost);
    }

    @Override
    public boolean skillCastAllowance(Entity caster) {
        return caster.geteMana() >= skillCost;
    }

}
