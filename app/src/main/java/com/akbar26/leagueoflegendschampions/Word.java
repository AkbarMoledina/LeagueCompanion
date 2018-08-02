package com.akbar26.leagueoflegendschampions;

/**
 * Created by akbar on 17/01/2018.
 */

public class Word {

    String mChampionName;

    private String mChampionTitle;

    public Word(String championName, String championTitle) {
        mChampionName = championName;
        mChampionTitle = championTitle;
    }

    public String getmChampionName() {
        return mChampionName;
    }

    public String getmChampionTitle() {
        return mChampionTitle;
    }


}