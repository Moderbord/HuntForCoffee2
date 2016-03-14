package moderbord.huntforcoffee2.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import moderbord.huntforcoffee2.R;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class UIController {

    public Button inventoryButton;
    public Button characterButton;
    public Button optionsButton;
    public ImageView portrait;
    public TextView mainText;
    public TextView descriptionText;
    public TextView locationView;
    public TextView timeView;
    public TextView dateView;
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    public Button button10;
    private static UIController instance;

    public static UIController getInstance() {
        if (instance == null) {
            instance = new UIController();
        }
        return instance;
    }

    public void initWithView(View v) {
        this.button10 = (Button) v.findViewById(R.id.mv_button_10);
        this.button9 = (Button) v.findViewById(R.id.mv_button_9);
        this.button8 = (Button) v.findViewById(R.id.mv_button_8);
        this.button7 = (Button) v.findViewById(R.id.mv_button_7);
        this.button6 = (Button) v.findViewById(R.id.mv_button_6);
        this.button5 = (Button) v.findViewById(R.id.mv_button_5);
        this.button4 = (Button) v.findViewById(R.id.mv_button_4);
        this.button3 = (Button) v.findViewById(R.id.mv_button_3);
        this.button2 = (Button) v.findViewById(R.id.mv_button_2);
        this.button1 = (Button) v.findViewById(R.id.mv_button_1);
        this.dateView = (TextView) v.findViewById(R.id.mv_date_textview);
        this.timeView = (TextView) v.findViewById(R.id.mv_time_textview);
        this.locationView = (TextView) v.findViewById(R.id.mv_location_textview);
        this.descriptionText = (TextView) v.findViewById(R.id.mv_description_textview);
        this.mainText = (TextView) v.findViewById(R.id.mv_main_textview);
        this.portrait = (ImageView) v.findViewById(R.id.mv_portrait_imageview);
        this.optionsButton = (Button) v.findViewById(R.id.mv_options_button);
        this.characterButton = (Button) v.findViewById(R.id.mv_character_button);
        this.inventoryButton = (Button) v.findViewById(R.id.mv_inventory_button);

    }
}
