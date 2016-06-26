package moderbord.huntforcoffee2.Model;

import moderbord.huntforcoffee2.Utils.Utils;

/**
 * Created by Moderbord on 2016-05-12.
 */
public class Skill extends SkillEffect {

    protected String skillName;
    protected int targetForm, skillType, skillDuration;

    public Skill(String skillName, int targetForm, int skillType, int skillDuration) { //TODO remove duration
        this.skillName = skillName;
        this.targetForm = targetForm;
        this.skillType = skillType;
        this.skillDuration = skillDuration;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getTargetForm() {
        return targetForm;
    }

    public void setTargetForm(int targetForm) {
        this.targetForm = targetForm;
    }

    public int getSkillType() {
        return skillType;
    }

    public void setSkillType(int skillType) {
        this.skillType = skillType;
    }

    public int getSkillDuration() {
        return skillDuration;
    }

    public void setSkillDuration(int skillDuration) {
        this.skillDuration = skillDuration;
    }

    public String tickDesc(){
        return Utils.toLow(skillName);
    }

    @Override
    public void getSkillEffect(Entity caster, Entity target) {

    }
}
