package com.example.xiaobao.xiaobaokotlin.home8.day2;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home8.day1.home8_day1_activity_second;

import java.net.URI;


public class home8_day2_activity_first extends Activity implements OnClickListener {
    public String TAG = "home8_day1_activity_first";
    private Button button;
    private TextView textView;
    private MediaPlayer mediaPlayer;
    private int positon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day2_firstview);
        button = findViewById(R.id.button);
        button.setOnClickListener(home8_day2_activity_first.this);
    }


    @Override
    public void onClick(View v) {
//        //显式启动 方式1
        if (false){
            Intent intent = new Intent(home8_day2_activity_first.this, home8_day2_activity_second.class);
            startActivity(intent);
            return;
        }

        if (false){
            Intent intent2 = new Intent();
            ComponentName component = new ComponentName(home8_day2_activity_first.this, home8_day2_activity_second.class);
            intent2.setComponent(component);
            startActivity(intent2);
            return;
        }
        if (true){
            //匿名启动
            Intent intent3 = new Intent();
            intent3.setAction("xlp_second");
            startActivity(intent3);
        }
    }


//    启动系统应用
    public void click(View v) {
        switch (v.getId()){
            case R.id.button_xitong1:{
                //匿名启动
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://www.baidu.com");
                intent.setData(uri);
                startActivity(intent);
                break;
            }

            case R.id.button_xitong2:{
                //匿名启动
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
               intent.setType("image/*");
                startActivity(intent);
                break;
            }
            case R.id.button_xitong3:{
                //匿名启动
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"45678");
                startActivity(intent);
                break;
            }
            case R.id.button_xitong4:{
                //匿名启动
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("tel:15338826129");
                intent.setData(uri);
                startActivity(intent);
                break;
            }
        }



    }




}

