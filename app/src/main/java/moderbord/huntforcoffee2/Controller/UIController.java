package moderbord.huntforcoffee2.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import moderbord.huntforcoffee2.R;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class UIController {

    public android.widget.TextView mainTextWindow;
    public android.widget.ScrollView scrollView;
    public android.widget.EditText nameInput;
    public android.widget.TextView subTextWindow;
    public android.widget.ScrollView scrollView2;
    public android.widget.Button b0;
    public android.widget.Button b1;
    public android.widget.Button b2;
    public android.widget.Button b3;
    public android.widget.Button b4;
    public android.widget.LinearLayout linearLayout;
    public android.widget.Button b5;
    public android.widget.Button b6;
    public android.widget.Button b7;
    public android.widget.Button b8;
    public android.widget.Button b9;
    public android.widget.LinearLayout linearLayout2;
    public android.widget.TextView statPhy;
    public android.widget.TextView statInt;
    public android.widget.TextView statAgi;
    public android.widget.TextView statQui;
    public android.widget.TextView statCha;
    public android.widget.TextView statLuck;
    public android.widget.TextView statLi;
    public android.widget.TextView statHealth;
    public android.widget.TextView statMana;
    public android.widget.TextView statFatigue;
    public android.widget.TextView statLu;
    public android.widget.TextView statLvl;
    public android.widget.TextView statClass;
    public android.widget.TextView timeClock;
    public android.widget.TextView timeDate;
    private static UIController instance;

    public static UIController getInstance() {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

    public void initWithView(View v) {
        this.timeDate = (TextView) v.findViewById(R.id.timeDate);
        this.timeClock = (TextView) v.findViewById(R.id.timeClock);
        this.statClass = (TextView) v.findViewById(R.id.statClass);
        this.statLvl = (TextView) v.findViewById(R.id.statLvl);
        this.statLu = (TextView) v.findViewById(R.id.statLu);
        this.statFatigue = (TextView) v.findViewById(R.id.statFatigue);
        this.statMana = (TextView) v.findViewById(R.id.statMana);
        this.statHealth = (TextView) v.findViewById(R.id.statHealth);
        this.statLi = (TextView) v.findViewById(R.id.statLi);
        this.statLuck = (TextView) v.findViewById(R.id.statLuck);
        this.statCha = (TextView) v.findViewById(R.id.statCha);
        this.statQui = (TextView) v.findViewById(R.id.statQui);
        this.statAgi = (TextView) v.findViewById(R.id.statAgi);
        this.statInt = (TextView) v.findViewById(R.id.statInt);
        this.statPhy = (TextView) v.findViewById(R.id.statPhy);
        this.linearLayout2 = (LinearLayout) v.findViewById(R.id.linearLayout2);
        this.b9 = (Button) v.findViewById(R.id.b9);
        this.b8 = (Button) v.findViewById(R.id.b8);
        this.b7 = (Button) v.findViewById(R.id.b7);
        this.b6 = (Button) v.findViewById(R.id.b6);
        this.b5 = (Button) v.findViewById(R.id.b5);
        this.linearLayout = (LinearLayout) v.findViewById(R.id.linearLayout);
        this.b4 = (Button) v.findViewById(R.id.b4);
        this.b3 = (Button) v.findViewById(R.id.b3);
        this.b2 = (Button) v.findViewById(R.id.b2);
        this.b1 = (Button) v.findViewById(R.id.b1);
        this.b0 = (Button) v.findViewById(R.id.b0);
        this.scrollView2 = (ScrollView) v.findViewById(R.id.scrollView2);
        this.subTextWindow = (TextView) v.findViewById(R.id.subTextWindow);
        this.nameInput = (EditText) v.findViewById(R.id.nameInput);
        this.scrollView = (ScrollView) v.findViewById(R.id.scrollView);
        this.mainTextWindow = (TextView) v.findViewById(R.id.mainTextWindow);
    }
}
