package com.example.xiaobao.android_one.home3.day6;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by xiaobao on 2020/6/16.
 */

public class MyBindService extends Service {

static String TAG = "MyBindService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return new MyBinder();

    }

    public class MyBinder extends Binder{
        public MyBindService getService() {
            return MyBindService.this;
        }
    }

    public void play(){
        Log.i(TAG, "play: 播放");
    }

    public void pause(){
        Log.i(TAG, "play: 暂停");
    }

    public void pervious(){
        Log.i(TAG, "play: 上一首");
    }

    public void next(){
        Log.i(TAG, "play: 下一首");
    }


}
