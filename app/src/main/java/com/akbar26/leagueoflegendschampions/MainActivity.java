package com.akbar26.leagueoflegendschampions;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import android.widget.Toast;

import com.akbar26.leagueoflegendschampions.InfoList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static TextView champions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FetchData process = new FetchData();
        process.getData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList nameAndTitle = new ArrayList<Word>();
        ArrayList keys;
        keys = InfoList.getmKeyList();
        JSONObject json;
        json = InfoList.getmChampionInfo();
        JSONObject championInfo;
        String name;
        String title;

        Iterator keyIterator = keys.iterator();
        while (keyIterator.hasNext()) {
            try {
                championInfo = json.getJSONObject((String) keyIterator.next());
                name = (String) championInfo.get("name");
                title = (String) championInfo.get("title");
                nameAndTitle.add(new Word(name, title));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

//        InfoList x = new InfoList();
//        x.setmNameAndTitle(nameAndTitle);

        ListAdapter adapter = new ListAdapter(this, nameAndTitle);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        int y = 1;

        listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String championName = ((Word)nameAndTitle.get(position)).getmChampionName();
                    InfoList x = new InfoList();
                    x.setmPosition(position);
                    InfoList y = new InfoList();
                    y.setmNameAndTitle(nameAndTitle);
                    Toast.makeText(MainActivity.this, championName, Toast.LENGTH_LONG).show();
                    Intent championsIntent = new Intent(MainActivity.this, Champions.class);
                    startActivity(championsIntent);
                }
            }
        );
    }
}
