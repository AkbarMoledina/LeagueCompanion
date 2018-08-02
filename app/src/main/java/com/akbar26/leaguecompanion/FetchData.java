package com.akbar26.leaguecompanion;

import android.os.AsyncTask;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by akbar on 29/05/2018.
 */

public class FetchData extends AsyncTask<Void, Void, List<String>> {
    static String json = "";
    String rowParsed = "";
    private String dataParsed = "";
    private ArrayList<String> keysList = new ArrayList<String>();
    private JSONObject jo = new JSONObject();

    protected void onPreExecute(){
        Log.v("AsyncTask", "onPreExecute");
    }
    @Override
    protected List<String> doInBackground(Void... params) {
        try {
            Log.v("AsyncTask", "doInBackground");
            String apikey = "RGAPI-7262478b-1212-43c5-8376-0fa831802caa";
            URL url = new URL("https://euw1.api.riotgames.com/lol/static-data/v3/champions?locale=en_US&dataById=false&api_key=" + apikey);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String json = bufferedReader.readLine();
            JSONObject joOuter = new JSONObject(json);
            jo = joOuter.getJSONObject("data");

            Iterator keysToCopyIterator = jo.keys();
            while (keysToCopyIterator.hasNext()) {
                String keyValue = (String) keysToCopyIterator.next();
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
        return keysList;
    }

    protected void onPostExecute(List<String> aVoid) {
        Log.v("AsyncTask", "onPostExecute");

    }

//    @Override
//    protected void onPostExecute(List<String> aVoid) {
//        super.onPostExecute(aVoid);
//
//        MainActivity.champions.setText(keysList);
//    }
}
