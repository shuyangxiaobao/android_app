package com.example.xiaobao.xiaobaokotlin.home5.day4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home5_day4_activity extends Activity {
    private Handler handler = new Handler();
    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home5_day4_mainview);
        textView = findViewById(R.id.home5_day4_textview);
        String url = "http://192.168.0.103:8082/girls.xml";
        new XmlThread(url,handler,textView).start();
    }

}
