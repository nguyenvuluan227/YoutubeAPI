package com.example.youtubeapiv329072019.view.activity;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;

import com.example.youtubeapiv329072019.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class LoadVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String API_KEY = "AIzaSyCLeRsCNEpWYYjFzNcL1B0Gjfmy_rGTaDI";
    YouTubePlayerView youTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadvideo);
        youTubePlayerView = findViewById(R.id.youtubePlayerview);
        youTubePlayerView.initialize(API_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo("juCeHsRZi-Y");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(LoadVideoActivity.this,123);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK && data != null){
            youTubePlayerView.initialize(API_KEY,this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
