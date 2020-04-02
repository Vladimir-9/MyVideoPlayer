package com.example.myvideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private int intPosition;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        videoView = findViewById(R.id.videoView);
        String pathVideoFile = "android.resource://com.example.myvideoplayer/" + R.raw.videoplayback;
        videoView.setVideoPath(pathVideoFile);

        if (savedInstanceState != null) {
            intPosition = savedInstanceState.getInt("intPosition");
            videoView.seekTo(intPosition);
            videoView.start();
        } else {
            videoView.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
        intPosition = videoView.getCurrentPosition();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.seekTo(intPosition);
        videoView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        videoView.pause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        videoView.seekTo(intPosition);
        videoView.start();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        intPosition = videoView.getCurrentPosition();
        outState.putInt("intPosition", intPosition);
    }

    public void secondActivity(View view) {
        Intent secondActivity = new Intent(this, TestActivity.class);
        startActivity(secondActivity);
    }
}
