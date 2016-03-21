package moderbord.huntforcoffee2.Utils;

/**
 * Created by Oscilla on 2016-03-15.
 */

public class Utils {

    public static String toUp(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String toLow(String str){
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

}
