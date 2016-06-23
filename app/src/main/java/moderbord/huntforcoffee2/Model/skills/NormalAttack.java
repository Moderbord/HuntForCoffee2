package moderbord.huntforcoffee2.Model.skills;

import java.util.Random;

import moderbord.huntforcoffee2.Controller.EventController;
import moderbord.huntforcoffee2.Model.Entity;
import moderbord.huntforcoffee2.Model.Skill;
import moderbord.huntforcoffee2.Model.item.Weapon;
import moderbord.huntforcoffee2.Utils.C;
import moderbord.huntforcoffee2.Utils.Utils;

/**
 * Created by Moderbord on 2016-06-01.
 */

public class NormalAttack extends Skill {

    Random rand = new Random();
    private static NormalAttack instance;

    public static NormalAttack getInstance() {
        if (instance == null) {
            instance = new NormalAttack("Attack", C.TARGET_FORM_ENEMY, C.SKILL_TYPE_DMG, 0);
        }
        return instance;
    }

    public NormalAttack(String skillName, int targetForm, int skillType, int skillDuration) {
        super(skillName, targetForm, skillType, skillDuration);
    }

    @Override
    public void getSkillEffect(Entity caster, Entity target) {
        if (caster.getMainWep().isWeapon()){
            int dmg = performAttack(caster.getMainWep(), caster);
            EventController.text.append(caster.geteName() + " hits " + target.geteName() + " with " + caster.hisHer() +
                    " " + Utils.toLow(caster.getMainWep().getWepType()) + " for " + dmg + " damage.\n");
            target.damaged(dmg);
        }
        if (caster.getOffWep().isWeapon()){
            int dmg = performAttack(caster.getOffWep(), caster);
            EventController.text.append(caster.geteName() + " hits " + target.geteName() + " with " + caster.hisHer() +
                    " " + Utils.toLow(caster.getOffWep().getWepType()) + " for " + dmg + " damage.\n");
            target.damaged(dmg);
        }
    }

    private int performAttack(Weapon weapon, Entity caster) {
        int min = weapon.getMinDmg(), max = weapon.getMaxDmg(); //Retrieves the minimum and maximum damage from the weapon
        int weaponDmg = rand.nextInt(max - min) + min; //Randomizes a number between the damage range of the weapon (can't be 0 unless minDmg is 0)
        double dmgMlt = 1; //Damage multiplier which will be altered depending on player factors

        //TODO factors armour, strength, skills , etc

        int outDmg = Math.round(weaponDmg *= dmgMlt);
        return outDmg;
    }

}
