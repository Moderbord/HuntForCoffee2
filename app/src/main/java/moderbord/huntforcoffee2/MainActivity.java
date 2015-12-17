package moderbord.huntforcoffee2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import moderbord.huntforcoffee2.Controller.SaveController;
import moderbord.huntforcoffee2.Controller.UIController;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.PlayerBuilder;
import moderbord.huntforcoffee2.Model.item.Burger;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new UIController(this));
        Player p = new PlayerBuilder().seteName("pontus").createPlayer();
        p.getInventory().add(new Burger(4));
        p.getInventory().get(0);
        SaveController.getInstance(this).savePlayer(p);
        p = SaveController.getInstance(this).loadPlayer("pontus");
        p.consumeItem(p.getInventory().get(0));
        Log.d("MainActivity", p.geteName());
    }


}
