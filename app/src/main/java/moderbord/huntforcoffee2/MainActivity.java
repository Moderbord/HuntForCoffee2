package moderbord.huntforcoffee2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import moderbord.huntforcoffee2.Controller.SaveController;
import moderbord.huntforcoffee2.Model.Player;
import moderbord.huntforcoffee2.Model.PlayerBuilder;
import moderbord.huntforcoffee2.Model.item.Burger;

/**
 * Created by Moderbord on 2015-12-17.
 */

public class MainActivity extends Activity{

    private android.widget.TextView mainTextWindow;
    private android.widget.ScrollView scrollView;
    private android.widget.EditText nameInput;
    private android.widget.TextView subTextWindow;
    private android.widget.ScrollView scrollView2;
    private android.widget.Button b0;
    private android.widget.Button b1;
    private android.widget.Button b2;
    private android.widget.Button b3;
    private android.widget.Button b4;
    private android.widget.LinearLayout linearLayout;
    private android.widget.Button b5;
    private android.widget.Button b6;
    private android.widget.Button b7;
    private android.widget.Button b8;
    private android.widget.Button b9;
    private android.widget.LinearLayout linearLayout2;
    private android.widget.TextView statPhy;
    private android.widget.TextView statInt;
    private android.widget.TextView statAgi;
    private android.widget.TextView statQui;
    private android.widget.TextView statCha;
    private android.widget.TextView statLuck;
    private android.widget.TextView statLi;
    private android.widget.TextView statHealth;
    private android.widget.TextView statMana;
    private android.widget.TextView statFatigue;
    private android.widget.TextView statLu;
    private android.widget.TextView statLvl;
    private android.widget.TextView statClass;
    private android.widget.TextView timeClock;
    private android.widget.TextView timeDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.timeDate = (TextView) findViewById(R.id.timeDate);
        this.timeClock = (TextView) findViewById(R.id.timeClock);
        this.statClass = (TextView) findViewById(R.id.statClass);
        this.statLvl = (TextView) findViewById(R.id.statLvl);
        this.statLu = (TextView) findViewById(R.id.statLu);
        this.statFatigue = (TextView) findViewById(R.id.statFatigue);
        this.statMana = (TextView) findViewById(R.id.statMana);
        this.statHealth = (TextView) findViewById(R.id.statHealth);
        this.statLi = (TextView) findViewById(R.id.statLi);
        this.statLuck = (TextView) findViewById(R.id.statLuck);
        this.statCha = (TextView) findViewById(R.id.statCha);
        this.statQui = (TextView) findViewById(R.id.statQui);
        this.statAgi = (TextView) findViewById(R.id.statAgi);
        this.statInt = (TextView) findViewById(R.id.statInt);
        this.statPhy = (TextView) findViewById(R.id.statPhy);
        this.linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        this.b9 = (Button) findViewById(R.id.b9);
        this.b8 = (Button) findViewById(R.id.b8);
        this.b7 = (Button) findViewById(R.id.b7);
        this.b6 = (Button) findViewById(R.id.b6);
        this.b5 = (Button) findViewById(R.id.b5);
        this.linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        this.b4 = (Button) findViewById(R.id.b4);
        this.b3 = (Button) findViewById(R.id.b3);
        this.b2 = (Button) findViewById(R.id.b2);
        this.b1 = (Button) findViewById(R.id.b1);
        this.b0 = (Button) findViewById(R.id.b0);
        this.scrollView2 = (ScrollView) findViewById(R.id.scrollView2);
        this.subTextWindow = (TextView) findViewById(R.id.subTextWindow);
        this.nameInput = (EditText) findViewById(R.id.nameInput);
        this.scrollView = (ScrollView) findViewById(R.id.scrollView);
        this.mainTextWindow = (TextView) findViewById(R.id.mainTextWindow);
        Player p = new PlayerBuilder().seteName("pontus").createPlayer();
        p.getInventory().add(new Burger());
        SaveController.getInstance(this).savePlayer(p);
        p = SaveController.getInstance(this).loadPlayer("pontus");
        Log.d("MainActivity", p.geteName());
        p.consumeItem(p.getInventory().get(0));
    }


}
