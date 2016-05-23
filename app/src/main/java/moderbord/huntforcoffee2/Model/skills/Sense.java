package moderbord.huntforcoffee2.Model.skills;

import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2016-05-23.
 */
public class Sense extends Skill {

    private static Sense instance;

    public static Sense getInstance() {
        if (instance == null){
            instance = new Sense("Sense", C.TARGET_FORM_SELF, C.SKILL_TYPE_BUFF, 0);
        }
        return instance;
    }

    public Sense(String skillName, int targetForm, int skillType, int skillDuration) {
        super(skillName, targetForm, skillType, skillDuration);
    }
}
