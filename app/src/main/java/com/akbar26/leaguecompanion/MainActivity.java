package com.akbar26.leaguecompanion;

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
import java.util.List;
import android.widget.Toast;

import com.akbar26.leaguecompanion.InfoList;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static TextView champions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        FetchData process = new FetchData();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
//            process.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Void[])null);
//        else
//            process.execute((Void[])null);

        new FetchData().execute();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        champions = (TextView) findViewById(R.id.champions);




        final ArrayList x = new ArrayList<Word>();
        x.add(new Word("Kassadin", "The Void Walker"));
        x.add(new Word("Karthus", "The Deathsinger"));
        x.add(new Word("Lee Sin", "The Blind Monk"));
        x.add(new Word("Vladimir", "The Crimson Reaper"));
        x.add(new Word("Sejuani", "The Winter's Wrath"));
        x.add(new Word("Ekko", "The Boy Who Shattered Time"));
        x.add(new Word("Karma", "The Enlightened One"));
        x.add(new Word("Sivir", "The Battle Mistress"));
        x.add(new Word("Kha'Zix", "The Voidreaver"));

        ArrayList a = new ArrayList<Word>();
        a = InfoList.getmKeyList();
        JSONObject b = new JSONObject();
        b = InfoList.getmChampionInfo();

        ListAdapter adapter = new ListAdapter(this, x);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        int y = 1;

        listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String championName = ((Word)x.get(position)).getmChampionName();
                    Toast.makeText(MainActivity.this, championName, Toast.LENGTH_LONG).show();
                    Intent championsIntent = new Intent(MainActivity.this, Champions.class);
                    startActivity(championsIntent);
                }
            }
        );
    }
}
