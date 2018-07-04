package online.omnia.script;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lollipop on 07.07.2017.
 */
public class Model {
    public void updateUnitPrice(String adsetId, String unitPrice, String token){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("unit_price", unitPrice));
        String answer = HttpMethodUtils.postMethod("adset/" + adsetId, nameValuePairs, token);
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(String.class, new JsonUnitPriceUpdateAnswerDecerializer());
        Gson gson = builder.create();
        gson.fromJson(answer, String.class);
    }

    public void updateTargetCPI(String adsetId, String targetCPI, String token) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("target_cpi", targetCPI));
        String answer = HttpMethodUtils.postMethod("adset/" + adsetId, nameValuePairs, token);
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(String.class, new JsonTargetCPIUpdateDecerializer());
        Gson gson = builder.create();
        gson.fromJson(answer, String.class);
    }
}
