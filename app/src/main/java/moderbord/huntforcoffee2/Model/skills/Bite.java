package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;
import moderbord.huntforcoffee2.Utils.Utils;

/**
 * Created by Moderbord on 2016-06-26.
 */

public class Bite extends Skill {

    private static Bite instance;

    public static Bite getInstance() {
        if (instance == null){
            instance = new Bite("Bite", C.TARGET_FORM_ENEMY, C.SKILL_TYPE_DMG, 15);
        }
        return instance;
    }

    public Bite(String skillName, int targetForm, int skillType, int skillCost) {
        super(skillName, targetForm, skillType, skillCost);
    }

    @Override
    public void getSkillEffect(Entity caster, Entity target) {
        int dmg = Utils.rand.nextInt(20 - 10) + 10 * caster.geteLevel();
        target.damaged(dmg);
        EventController.text.append(caster.geteName() + " bites " + target.geteName() + " with " + caster.hisHer() + " great teeth for" +
                " " + dmg + " damage");

        caster.fatigueCost(skillCost);
    }

    @Override
    public boolean skillCastAllowance(Entity caster) {
        return caster.geteFatigue() + skillCost <= caster.geteMaxFatigue();
    }

}