package com.example.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

public class BoundService extends Service {

    CountDownTimer mTimer = new CountDownTimer(100000, 1000) {
        @Override
        public void onTick(long l) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            Log.d(TAG, "onTick: " + elapsedTime);
        }
        @Override
        public void onFinish() {
        }
    };


    final String TAG = BoundService.class.getSimpleName();
    MyBinder binder = new MyBinder();
    final long startTime = System.currentTimeMillis();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        mTimer.start();
        return binder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        mTimer.cancel();
        return super.onUnbind(intent);
    }
    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind: ");
    }

    public BoundService() {
    }
    class MyBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }
}
