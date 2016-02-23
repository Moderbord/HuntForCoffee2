package moderbord.huntforcoffee2.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import moderbord.huntforcoffee2.Model.item.Item;

/**
 * Created by laurentmeyer on 17/12/15.
 */
public class CustomDeserializer implements JsonDeserializer<Item> {
    @Override
    public Item deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String classToLookFor = jsonObject.get("className").getAsString();
        try {
            Class newInstance = Class.forName("moderbord.huntforcoffee2.Model.item." + classToLookFor);
            return (Item) new Gson().fromJson(json, newInstance);
        } catch (Exception e) {

        }
        return null;
    }
}
