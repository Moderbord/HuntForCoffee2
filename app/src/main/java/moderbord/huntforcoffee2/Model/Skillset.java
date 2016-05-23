package moderbord.huntforcoffee2.Model;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Oscilla on 2016-04-16.
 */
public class Skillset extends ArrayList<Skill> {

    //TODO make it auto-sort when adding skill

    @Override
    public boolean add(Skill skill) {
        for (Skill s : this){
            try {
                if (s.equals(skill)){
                    return true;
                }
            } catch (Exception e){
                Log.d("Skillset", "Object was null");
            }
        }
        return super.add(skill);
    }

}
