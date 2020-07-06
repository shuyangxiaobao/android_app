package com.example.xiaobao.android_one.home8.day2;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.xiaobao.android_one.R;


public class home8_day2_activity_second extends Activity {

    public String TAG = "home8_day1_activity_second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day2_secondview);
        Log.i(TAG, "onCreate: ");
    }

}

