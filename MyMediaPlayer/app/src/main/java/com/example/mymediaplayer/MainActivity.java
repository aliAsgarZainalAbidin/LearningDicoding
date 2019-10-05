package com.example.mymediaplayer;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = MainActivity.class.getSimpleName();
    private Button btnPlay;
    private Button btnStop;

    private Messenger mService = null;
    private Intent mBoundServiceIntent;
    private boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btn_play);
        btnStop = findViewById(R.id.btn_stop);

        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_play:
                break;
            case R.id.btn_stop:
                break;
            default:
                break;
        }
    }
}
