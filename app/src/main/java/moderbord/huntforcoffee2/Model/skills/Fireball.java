package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-22.
 */

public class Fireball extends Skill {

    private static Fireball instance;

    public static Fireball getInstance() {
        if (instance == null){
            instance = new Fireball("Fireball", C.TARGET_FORM_ENEMY, C.SKILL_TYPE_DMG, 30);
        }
        return instance;
    }

    public Fireball(String skillName, int attackForm, int skillType, int skillCost) {
        super(skillName, attackForm, skillType, skillCost);
    }

    @Override
    public void getSkillEffect(Entity caster, Entity target) {
        int tFireRes = target.getResistance().getResFire() / 2;
        int xLvl = (caster.geteLevel() * 5) + 15; // base = 20 //TODO Make RNG
        int xInt = caster.geteIntellect();
        int spellDmg = 5; //xLvl + xInt - tFireRes;
        EventController.text.append(caster.geteName() + " launches a fireball" +
                " into " + target.geteName() + "'s face, taking " + Integer.toString(spellDmg) + " dmg.");
        target.damaged(spellDmg);
        target.getCombatStats().addOTE(new OverTimeEffect(this, target, 5, 10, C.STATUS_BURNING, C.SKILL_TYPE_DOT));

        caster.manaCost(skillCost);
    }

    @Override
    public boolean skillCastAllowance(Entity caster) {
        return caster.geteMana() >= skillCost;
    }

    @Override
    public String tickDesc() {
        return "lingering flames";
    }
}
