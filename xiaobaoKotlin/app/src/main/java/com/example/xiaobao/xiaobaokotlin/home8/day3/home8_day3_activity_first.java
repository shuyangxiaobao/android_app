package com.example.xiaobao.xiaobaokotlin.home8.day3;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home8.day2.home8_day2_activity_second;


public class home8_day3_activity_first extends Activity {
    public String TAG = "home8_day1_activity_first";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day3_firstview);
    }


    public void click(View v) {
        switch (v.getId()){
            case R.id.button1:{
                Intent intent = new Intent(home8_day3_activity_first.this,
                        home8_day3_activity_second.class);
                intent.putExtra("root","button1");
                intent.putExtra("name","xiaoming");
                intent.putExtra("age",17);
                startActivity(intent);
                break;
            }

            case R.id.button2:{
                Intent intent = new Intent(home8_day3_activity_first.this,
                        home8_day3_activity_second.class);
                Bundle bundle = new Bundle();
                bundle.putString("root","button2");
                bundle.putString("name","小明");
                bundle.putInt("age",23);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.button3:{
                Intent intent = new Intent(home8_day3_activity_first.this,
                        home8_day3_activity_second.class);
                Bundle bundle = new Bundle();
                bundle.putString("root","button3");
                Person person = new Person("小李", 18, "上海");
                bundle.putSerializable("person",person);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
            case R.id.button4:{
//传递较大数据时，会奔溃
                Intent intent = new Intent(home8_day3_activity_first.this,
                        home8_day3_activity_second.class);
                Bundle bundle = new Bundle();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
                bundle.putParcelable("bitmap",bitmap);
                bundle.putString("root","button4");
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            }
        }



    }




}

