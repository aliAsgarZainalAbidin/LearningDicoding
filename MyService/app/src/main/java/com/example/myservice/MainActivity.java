package com.example.myservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.myservice.DicodingIntentService.EXTRA_DURATION;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStartService;
    Button btnStartIntentService;
    Button btnStartBoundService;
    Button btnStopBoundService;
    boolean mServiceBound = false;
    BoundService mBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btn_start_service);
        btnStartIntentService = findViewById(R.id.btn_start_intent_service);
        btnStartBoundService = findViewById(R.id.btn_start_bound_service);
        btnStopBoundService = findViewById(R.id.btn_stop_bound_service);

        btnStartService.setOnClickListener(this);
        btnStartIntentService.setOnClickListener(this);
        btnStartBoundService.setOnClickListener(this);
        btnStopBoundService.setOnClickListener(this);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mServiceBound) {
            unbindService(mServiceConnection);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_service : {
                Intent mIntentOriginService = new  Intent(this, OriginService.class);
                startService(mIntentOriginService);
                break;
            }
            case R.id.btn_start_intent_service : {
                Intent mIntentDicodingService = new Intent(this, DicodingIntentService.class);
                mIntentDicodingService.putExtra(EXTRA_DURATION, 5000);
                startService(mIntentDicodingService);
                break;
            }
            case R.id.btn_start_bound_service : {
                Intent mBoundServiceIntent = new Intent(this, BoundService.class);
                bindService(mBoundServiceIntent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            }
            case  R.id.btn_stop_bound_service : {
                unbindService(mServiceConnection);
                break;
            }
        }
    }
}
