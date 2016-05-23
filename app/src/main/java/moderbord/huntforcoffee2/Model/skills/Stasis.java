package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-23.
 */
public class Stasis extends Skill {

    private static Stasis instance;

    public static Stasis getInstance() {
        if (instance == null){
            instance = new Stasis("Stasis", C.TARGET_FORM_ALL, C.SKILL_TYPE_CC, 0);
        }
        return instance;
    }

    public Stasis(String skillName, int targetForm, int skillType, int skillDuration) {
        super(skillName, targetForm, skillType, skillDuration);
    }
}
