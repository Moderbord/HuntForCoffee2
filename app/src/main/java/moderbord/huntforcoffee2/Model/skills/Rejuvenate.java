package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-23.
 */
public class Rejuvenate extends Skill {

    private static Rejuvenate instance;

    public static Rejuvenate getInstance() {
        if (instance == null){
            instance = new Rejuvenate("Rejuvenate", C.TARGET_FORM_ALLIED, C.SKILL_TYPE_HEAL, 0);
        }
        return instance;
    }

    public Rejuvenate(String skillName, int targetForm, int skillType, int skillDuration) {
        super(skillName, targetForm, skillType, skillDuration);
    }
}
