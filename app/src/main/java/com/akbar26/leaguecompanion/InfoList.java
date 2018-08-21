package com.akbar26.leaguecompanion;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Setters and Getters related to the JSON obtained from the Riot Games API
 */

public class InfoList {

    private static ArrayList<String> mKeyList;
    private static JSONObject mChampionInfo;
    private static ArrayList<String> mNameAndTitle;
    private static int mPosition;

    public static ArrayList<String> getmKeyList() {
        return mKeyList;
    }

    public void setmKeyList(ArrayList<String> mKeyList) {
        this.mKeyList = mKeyList;
    }

    public static JSONObject getmChampionInfo() {
        return mChampionInfo;
    }

    public void setmChampionInfo(JSONObject mChampionInfo) {
        this.mChampionInfo = mChampionInfo;
    }

    public static ArrayList<String> getmNameAndTitle() {
        return mNameAndTitle;
    }

    public void setmNameAndTitle(ArrayList<String> mNameAndTitle) {
        this.mNameAndTitle = mNameAndTitle;
    }

    public static int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

}

