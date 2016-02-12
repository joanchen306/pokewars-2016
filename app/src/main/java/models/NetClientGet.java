package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by joanchen on 2/10/16.
 */
public class NetClientGet {

    // http://localhost:3000
    public JSONObject get() throws JSONException {

        try {

            URL url = new URL("http://localhost:3000");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output = "";
            String line;
            System.out.println("Output from Server .... \n");
            while ((line = br.readLine()) != null) {
                output += line;
            }

            JSONObject data = new JSONObject(output);

            conn.disconnect();
            return data;

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return new JSONObject();
    }
}
