package com.example.xiaobao.android_one.home8.day5;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home8.day3.Person;
import com.example.xiaobao.android_one.home8.day3.home8_day3_activity_second;


public class home8_day5_activity_first extends Activity {
    public String TAG = "home8_day4_activity_first";
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day5_firstview);
        Log.i(TAG, "onCreate: ");
    }


    /*

    https://blog.csdn.net/mr_jingfu/article/details/79077613
            android:launchMode="standard"
            android:launchMode="singleTop"
            android:launchMode="singleTask"
            android:launchMode="singleInstance"

    */



    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent: 1111111111");
    }

    public void click(View v) {
        if (v.getId() == R.id.button1){
            Intent intent = new Intent(this, home8_day5_activity_first.class);
            startActivity(intent);
        } else if (v.getId() == R.id.button2){
            Intent intent = new Intent(this, home8_day5_activity_second.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 11111111111");
    }
}

