package com.akbar26.leagueoflegendschampions;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by akbar on 29/05/2018.
 */

public class Champions extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.champions);

        int position = InfoList.getmPosition();
        ArrayList<String> nameAndTitle = InfoList.getmNameAndTitle();

        Object champion = new Object();
        champion = nameAndTitle.get(position);
        String championName = ((Word)champion).getmChampionName();
        String championTitle = ((Word)champion).getmChampionTitle();

        TextView championTextView = findViewById(R.id.championName);
        championTextView.setText(championName);
        TextView titleTextView = findViewById(R.id.championTitle);
        titleTextView.setText(championTitle);


    }
}