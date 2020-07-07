package com.example.xiaobao.xiaobaokotlin.home3.day6;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by xiaobao on 2020/6/16.
 */

public class MyStartService extends Service {

static String TAG = "MyStartService";
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: 服务创建了");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(TAG, "onStart: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: 服务启动了");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 服务销毁了");
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: 服务绑定了");
        return null;

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: 服务解绑了");
        return super.onUnbind(intent);
    }
}
