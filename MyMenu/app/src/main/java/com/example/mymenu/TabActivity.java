package com.example.mymenu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

public class TabActivity extends android.app.TabActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        tabHost = getTabHost();
        TabHost.TabSpec ts1 = tabHost.newTabSpec("song").setIndicator("음악별");
        ts1.setContent(R.id.tabSong);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("artist").setIndicator("가수별");
        ts2.setContent(R.id.tabArtist);

        TabHost.TabSpec ts3 = tabHost.newTabSpec("album").setIndicator("앨범별");
        ts3.setContent(R.id.tabAlbum);

        tabHost.addTab(ts1);
        tabHost.addTab(ts2);
        tabHost.addTab(ts3);
        tabHost.setCurrentTab(1);


    }
}