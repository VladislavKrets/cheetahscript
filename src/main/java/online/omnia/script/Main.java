package online.omnia.script;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lollipop on 07.07.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {


        System.out.println("Please wait..");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = HttpMethodUtils.getToken("13256", "ae3a27715fb432f9ba036f163354e598");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(String.class, new JsonTokenDeserializer());
        Gson gson = builder.create();
        String token = gson.fromJson(answer, String.class);

        if (!token.isEmpty()){
            System.out.println();
            String inputLine;
            System.out.println("Input \"unitprice\" to update Unit Price");
            System.out.println("Input \"targetcpi\" to update target CPI");
            System.out.println("Input \"exit\" to exit the programme");
            System.out.println();
            String adsetId;
            String unitPrice;
            String targetCPI;
            Model model = new Model();
            while (!(inputLine = reader.readLine()).equals("exit")) {
                switch (inputLine) {
                    case "unitprice": {
                        System.out.println("Input id of adset:");
                        adsetId = reader.readLine();
                        System.out.println("Input unit price to update:");
                        unitPrice = reader.readLine();
                        model.updateUnitPrice(adsetId, unitPrice, token);
                        break;
                    }
                    case "targetcpi": {
                        System.out.println("Input id of adset:");
                        adsetId = reader.readLine();
                        System.out.println("Input target CPI to update:");
                        targetCPI = reader.readLine();
                        model.updateTargetCPI(adsetId, targetCPI, token);
                        break;
                    }
                }
            }
        }
        reader.close();
    }
}
