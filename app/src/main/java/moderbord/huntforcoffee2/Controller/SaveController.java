package moderbord.huntforcoffee2.Controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.item.Item;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class SaveController {

    public static final String PLAYER = "player";
    Context c;
    private static SaveController instance;

    private SaveController(Context c) {
        this.c = c;
    }

    public static SaveController getInstance(Context c){
        if(instance == null){
            instance = new SaveController(c);
        }
        return instance;
    }

    public void savePlayer(Player player){
        SharedPreferences sp = c.getSharedPreferences(PLAYER, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(player.geteName(), player.toJson());
        editor.commit();
    }

    public Player loadPlayer(String playerName){
        SharedPreferences sp = c.getSharedPreferences(PLAYER, 0);
        String retrievedFromMemory = sp.getString(playerName, null);
        if (retrievedFromMemory == null){
            return null;
        }
//        Gson gson = new Gson();
//        return gson.fromJson(retrievedFromMemory, Player.class);
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Item.class, new CustomDeserializer());
        Gson g = builder.create();
        return g.fromJson(retrievedFromMemory, Player.class);
    }

}
