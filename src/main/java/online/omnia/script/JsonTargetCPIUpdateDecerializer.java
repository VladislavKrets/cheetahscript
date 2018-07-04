package online.omnia.script;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by lollipop on 07.07.2017.
 */
public class JsonTargetCPIUpdateDecerializer implements JsonDeserializer<String>{
    @Override
    public String deserialize(JsonElement jsonElement, Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        String status = object.get("status").getAsString();
        String message = object.get("message").getAsString();
        if (status.equals("200")) {
            System.out.println("Target CPI has been successfully updated");
        }
        else {
            System.out.println("Error during updating target CPI");
            System.out.println("Message: " + message);
        }
        return status;
    }
}
