package com.example.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ThirdActivity extends YouTubeBaseActivity {
    YouTubePlayerView playerView;
    YouTubePlayer player;
    Button thirdTopBtn1;

    private static String API_KEY = "AIzaSyB3lgEALNYeCJqKz-SuOBmBfI3mhQ2yLtI";
    private static String videoId = "Ktazno7rgZg";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        initPlayer();
        thirdTopBtn1 = findViewById(R.id.ThirdTopBtn1);
        thirdTopBtn1.setOnClickListener(view -> {goHomePage();});

        Button button = findViewById(R.id.button_play);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });
    }

    private void goHomePage() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void initPlayer() {
        playerView = findViewById(R.id.playerView);
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player = youTubePlayer;

                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {
                    }

                    @Override
                    public void onLoaded(String id) {
                        Log.d("PlayerView", "onLoaded 호출됨: " + id);

                        player.play();
                    }

                    @Override
                    public void onAdStarted() {
                    }

                    @Override
                    public void onVideoStarted() {
                    }

                    @Override
                    public void onVideoEnded() {
                    }

                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {
                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        });
    }

    public void playVideo() {
        if (player != null) {
            if (player.isPlaying()) {
                player.pause();
            }
            player.cueVideo(videoId);
        }
    }

}