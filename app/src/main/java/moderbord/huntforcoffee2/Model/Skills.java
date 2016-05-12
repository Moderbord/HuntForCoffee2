package moderbord.huntforcoffee2.Model;

/**
 * Created by Oscilla on 2016-04-16.
 */
public class Skills {

    //TODO this class

    private String skillName;
    private int attackForm, skillType, skillDuration;

    public Skills(String skillName, int attackForm, int skillType, int skillDuration) {
        this.skillName = skillName;
        this.attackForm = attackForm;
        this.skillType = skillType;
        this.skillDuration = skillDuration;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getAttackForm(){
        return attackForm;
    }

    public void setAttackForm(int attackForm) {
        this.attackForm = attackForm;
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

}
