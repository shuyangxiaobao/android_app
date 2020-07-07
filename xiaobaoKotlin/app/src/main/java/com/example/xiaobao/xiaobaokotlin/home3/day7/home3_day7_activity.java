package com.example.xiaobao.xiaobaokotlin.home3.day7;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home3.day7.home3_day7_activity;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day7_activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demo1();

    }


    private void demo1() {
        LayoutInflater inflater = (LayoutInflater) home3_day7_activity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.home3_day7_mainview, null);
        setContentView(view);
    }

    public void doclick(View view) {
        switch (view.getId()) {
            case R.id.home3_day7_button1: {
                boolean connected = isNetWorkConnected(home3_day7_activity.this);
                if (connected) {
                    Toast.makeText(this, "网络打开", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "网络未连接", Toast.LENGTH_SHORT).show();
                }

                break;
            }
            case R.id.home3_day7_button2: {
                wifi_switch();
                break;
            }
            case R.id.home3_day7_button3: {
                getVoice();
                break;
            }
            case R.id.home3_day7_button4: {
                getPackageName_xlp();
                break;
            }

        }
    }


    public boolean isNetWorkConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = manager.getActiveNetworkInfo();
            if (networkInfo != null) {
                return networkInfo.isAvailable();
            }
            return false;
        }
        return false;

    }

    public void wifi_switch() {
        @SuppressLint("WifiManagerLeak") WifiManager wifimanager = (WifiManager) home3_day7_activity.this.getSystemService(WIFI_SERVICE);
        if (wifimanager.isWifiEnabled()) {
            wifimanager.setWifiEnabled(false);
            Toast.makeText(this, "wifi已经关闭", Toast.LENGTH_SHORT).show();
        } else {
            wifimanager.setWifiEnabled(true);
            Toast.makeText(this, "wifi已经打开", Toast.LENGTH_SHORT).show();
        }
    }

    public void getVoice() {
        AudioManager audioManager = (AudioManager)home3_day7_activity.this.getSystemService(AUDIO_SERVICE);
        int max = audioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
        int current = audioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);
        Toast.makeText(this, "最大音量："+max+"\n 当前音量"+current, Toast.LENGTH_SHORT).show();
    }

    public void getPackageName_xlp() {

        ActivityManager activityManager = (ActivityManager)home3_day7_activity.this.getSystemService(ACTIVITY_SERVICE);
        String packageName = activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
        Toast.makeText(this, ""+packageName, Toast.LENGTH_SHORT).show();
    }



    }
































