package com.example.group.tedxtv16.db;

import android.content.Context;
import android.os.AsyncTask;

import com.example.group.tedxtv16.MainActivity;
import com.example.group.tedxtv16.item.Item;
import com.example.group.tedxtv16.item.ItemType;
import com.example.group.tedxtv16.item.SpeakerItem;

import java.util.ArrayList;
import java.util.List;

public class LoadFromDatabaseAsyncTask extends AsyncTask<Void,Void,Void> {

    private List<Item> speakerItemList;
    private List<Item> newsItemList;
    private List<Item> teamItemList;
    private List<Item> aboutItemList;
    private MainActivity activity;

    public LoadFromDatabaseAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        ItemDAO itemDAO = new ItemDAO(activity);
        speakerItemList.addAll(itemDAO.getAllItems(ItemType.SPEAKER));
        newsItemList.addAll(itemDAO.getAllItems(ItemType.NEWS));
        teamItemList.addAll(itemDAO.getAllItems(ItemType.TEAM));
        aboutItemList.addAll(itemDAO.getAllItems(ItemType.ABOUT));
        return null;

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        activity.createFragment();

    }

    public void setSpeakerItemList(List<Item> speakerItemList) {
        this.speakerItemList = speakerItemList;
    }

    public void setNewsItemList(List<Item> newsItemList) {
        this.newsItemList = newsItemList;
    }

    public void setTeamItemList(List<Item> teamItemList) {
        this.teamItemList = teamItemList;
    }

    public void setAboutItemList(List<Item> aboutItemList) {
        this.aboutItemList = aboutItemList;
    }
}
