package com.example.xiaobao.android_one.home8.day5;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home8.day3.Person;


public class home8_day5_activity_second extends Activity {

    public String TAG = "home8_day4_activity_second";

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day5_secondview);
        Log.i(TAG, "onCreate: ");
        textView = findViewById(R.id.textview);


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent: 222222222");    }

    public void click(View v) {
        Intent intent = new Intent(this, home8_day5_activity_first.class);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 22222222222");
    }
}

