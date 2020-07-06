package com.example.xiaobao.android_one.home10.day1;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
/**
 * Created by xiaobao on 2020/7/3.
 */

public class MyApplication extends Application {
    public static RequestQueue queues;

    @Override
    public void onCreate() {
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getHttpQueues(){
        return queues;
    }
}
