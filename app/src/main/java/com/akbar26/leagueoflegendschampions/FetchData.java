package com.akbar26.leagueoflegendschampions;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akbar on 29/05/2018.
 */

public class FetchData{
    static String json = "";
    String rowParsed = "";
    private String dataParsed = "";
    private ArrayList<String> keysList = new ArrayList<String>();
    private JSONObject jo = new JSONObject();

    protected void getData() {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        try {
            String apikey = "RGAPI-1420da60-e73d-4487-8f60-8283772c540d";
            URL url = new URL("https://euw1.api.riotgames.com/lol/static-data/v3/champions?locale=en_US&dataById=false&api_key=" + apikey);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            URLConnection connection = (URLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String json = bufferedReader.readLine();
            JSONObject joOuter = new JSONObject(json);
            jo = joOuter.getJSONObject("data");

            Iterator keyIterator = jo.keys();
            while (keyIterator.hasNext()) {
                String keyValue = (String) keyIterator.next();
                keysList.add(keyValue);
            }
            Collections.sort(keysList);
            InfoList keys = new InfoList();
            keys.setmKeyList(keysList);
            InfoList info = new InfoList();
            info.setmChampionInfo(jo);
        } catch (JSONException | IOException e1) {
            e1.printStackTrace();
        }
    }
}
