package com.example.xiaobao.android_one.home4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/18.
 */

public class home4_day7_activity extends Activity {
    private TextView textView;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            textView.setText("ok----2");

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home4_day7_mainview);
        textView = findViewById(R.id.home4_day7_textview);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
//                    textView.setText("ok------奔溃");

                    handle4();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }


    private void handle1() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("ok------1");
            }
        });
    }
    private void handle2() {
        handler.sendEmptyMessage(1);
    }
    private void handle3() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("ok------3");
            }
        });
    }

    private void handle4() {
        textView.post(new Runnable() {
            @Override
            public void run() {
                textView.setText("ok------4");
            }
        });
    }




}







































