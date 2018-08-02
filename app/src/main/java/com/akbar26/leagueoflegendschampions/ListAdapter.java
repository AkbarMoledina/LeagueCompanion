package com.akbar26.leagueoflegendschampions;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.widget.Toast;

public class ListAdapter extends ArrayAdapter<Word> {


    public ListAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID champion_text_view.
        TextView championTextView = (TextView) listItemView.findViewById(R.id.champion_text_view);
        championTextView.setText(currentWord.getmChampionName());

        // Find the TextView in the list_item.xml layout with the ID title_text_view.
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentWord.getmChampionTitle());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}

