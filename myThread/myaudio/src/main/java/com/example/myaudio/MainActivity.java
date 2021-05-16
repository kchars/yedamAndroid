package com.example.myaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Switch switchOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchOn = findViewById(R.id.switchOn);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.song1);
        switchOn.setOnClickListener((v) -> {
            if(switchOn.isChecked() == true){
                mediaPlayer.start();
            } else {
                mediaPlayer.stop();
            }

        });

    }
}