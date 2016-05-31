package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-22.
 */
public class Fireball extends Skill {

    // TODO make class inherit interface (as for all skillset)
    // TODO which then will be overridden in each skill with Entity as parameter which
    // TODO in turn will effect the spell accordingly to spellpower and skillset etc.

    private static Fireball instance;

    public static Fireball getInstance() {
        if (instance == null){
            instance = new Fireball("Fireball", C.TARGET_FORM_ENEMY, C.SKILL_TYPE_DMG, 0);
        }
        return instance;
    }

    public Fireball(String skillName, int attackForm, int skillType, int skillDuration) {
        super(skillName, attackForm, skillType, skillDuration);
    }

    @Override
    public String getSkillEffect(Entity caster, Entity target) {
        return super.getSkillEffect(caster, target);
    }
}
