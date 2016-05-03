package moderbord.huntforcoffee2.Controller;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import moderbord.huntforcoffee2.MainActivity;
import moderbord.huntforcoffee2.R;
import moderbord.huntforcoffee2.Utils.C;

/**
 * Created by Moderbord on 2015-12-17.
 */
public class UIController {

    public Button inventoryButton;
    public Button characterButton;
    public Button optionsButton;
    public ImageView portrait;
    public EditText nameInput;
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

    public ArrayList<Button> actionButtons = new ArrayList<>();
    public ArrayList<Button> allButtons = new ArrayList<>();

    private static UIController instance;
    private StringBuilder stringBuilder = new StringBuilder();

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
        this.nameInput = (EditText) v.findViewById(R.id.mv_nameInput);
        this.portrait = (ImageView) v.findViewById(R.id.mv_portrait_imageview);
        this.optionsButton = (Button) v.findViewById(R.id.mv_options_button);
        this.characterButton = (Button) v.findViewById(R.id.mv_character_button);
        this.inventoryButton = (Button) v.findViewById(R.id.mv_inventory_button);

        this.actionButtons.addAll(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9, button10));
        this.allButtons.addAll(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8,
                button9, button10, optionsButton, characterButton, inventoryButton)); // TODO add from actionButtons list instead of loading same buttons twice

    }

    public void append(String toAppend){
        stringBuilder.append(toAppend);
    }

    public void submit(){
        String submit = stringBuilder.toString();
        mainText.setText(submit);
        stringBuilder.setLength(0);
    }

    public void setButtonText(String text, int button){
        Button btn = actionButtons.get(button - 1); // Corrects index for array
        enableButton(btn);
        btn.setText(text);
    }

    /**
     *
     * @param event Which event that should be applied
     * @param button Which button
     * @param text Which text to display
     */
    public void setEvent(View.OnClickListener event, int button, String text){
        Button btn = actionButtons.get(button - 1); // Corrects index for array
        enableButton(btn);
        btn.setText(text);
        btn.setOnClickListener(event);
    }

    public String getButtonText(View v){
        Button button = (Button) v;
        String string = button.getText().toString();
        return string;
    }

    public void enableActionButtons(){
        for (Button b : actionButtons){
            enableButton(b);
        }
    }

    public void enableButton (Button button){
        button.setAlpha(1.0f);
        button.setEnabled(true);
    }

    public void disableActionButtons(){
        for (Button b : actionButtons){
            disableButton(b);
        }
    }

    public void disableAllButtons(){
        for (Button b : allButtons){
            disableButton(b);
        }
    }

    public void disableButton (Button button){
        button.setAlpha(.5f);
        button.setEnabled(false);
    }

    public void clearActionButtons (){
        for (Button b : actionButtons){
            b.setText("");
            disableButton(b);
        }
    }

    public void clearButton (Button button){
        button.setText("");
        disableButton(button);
    }

    public void setLocation(String location){
        locationView.setText("Location: " + location);
    }

    public void setDescriptionText(String text){
        descriptionText.setText(text);
    }

    public void setPortrait(String resource){
        Drawable d = getDrawableAssets(resource);
        portrait.setImageDrawable(d);
    }

    public void setPortraitDefault(){
        Drawable d = getDrawableAssets(C.PORTRAIT_DEFAULT);
        portrait.setImageDrawable(d);
    }

    private Drawable getDrawableAssets(String path){
        Drawable d = null;
        InputStream stream = null;
        try {
            stream = MainActivity.context.getAssets().open(path);
            d = Drawable.createFromStream(stream, null);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return d;
    }

    public void updateTime(){
        // TODO need to implement time mechanic
    }

}
