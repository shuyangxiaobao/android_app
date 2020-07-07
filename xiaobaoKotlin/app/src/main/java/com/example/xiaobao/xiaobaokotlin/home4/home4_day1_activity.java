package com.example.xiaobao.xiaobaokotlin.home4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home4_day1_activity extends Activity {

    private TextView textView;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home4_day1_mainview);
        this.initEvent();
    }

    private void initEvent() {
        textView = findViewById(R.id.home4_day1_textview1);
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("update thread");
                            System.out.println("当前线程"+Thread.currentThread());
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }


}
