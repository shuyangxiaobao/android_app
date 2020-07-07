package com.example.xiaobao.xiaobaokotlin.home8.day4;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;


public class home8_day4_activity_first extends Activity {
    public String TAG = "home8_day4_activity_first";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day4_firstview);
        System.out.println("0000000000:"+getTaskId());

//        adb shell dumpsys activity   查看Activity 任务栈



/**



  android:process=":home8_day4_activity_first"   可以创建一个进程，跟当前app并列

                <activity
        android:name=".home8.day4.home8_day4_activity_first"
        android:process=":home8_day4_activity_first"
        android:theme="@style/Theme.AppCompat.DayNight">
            <intent-filter>
                <action android:name="home8_day4_activity_first" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>

 **/
    }


    public void click(View v) {
        switch (v.getId()){
            case R.id.button1:{
                Log.i(TAG, "onCreate: "+"home8_day4_activity_first taskid"+getTaskId());
                System.out.println("111111111");

                Intent intent = new Intent(home8_day4_activity_first.this,
                        home8_day4_activity_second.class);
                intent.putExtra("root","button1");
                intent.putExtra("name","xiaoming1111");
                intent.putExtra("age",17);
                startActivity(intent);
                break;
            }
        }
    }
}

