package com.example.xiaobao.android_one.home_huizong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home3.*;
import com.example.xiaobao.android_one.home3.day2.home3_day2_activity;
import com.example.xiaobao.android_one.home3.day3.home3_day3_activity;
import com.example.xiaobao.android_one.home3.day4.home3_day4_activity;
import com.example.xiaobao.android_one.home3.day5.home3_day5_activity;
import com.example.xiaobao.android_one.home3.day6.home3_day6_activity;
import com.example.xiaobao.android_one.home3.day7.home3_day7_activity;

import java.util.ArrayList;
import java.util.List;


public class home3_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button btn;
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;
    private List<String> arr_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home1_activity_main);
        demo1();
    }

    public void demo1() {
        listView = (ListView) findViewById(R.id.listview);
        arr_data = new ArrayList<String>();
        arr_data.add("3.0 第0章 四大组件之Activity");
        arr_data.add("3.1 第1章 数据存储之SharedPreferences");
        arr_data.add("3.2 第2章 数据存储之SQLite");
        arr_data.add("3.3 第3章 数据存储之文件存储");
        arr_data.add("3.4 第4章 四大组件之ContentProvider");
        arr_data.add("3.5 第5章 四大组件之BroadcastReceiver");
        arr_data.add("3.6 第6章 四大组件之Service");
        arr_data.add("3.7 第7章 Android中常用的系统服务");
        arr_data.add("3.8 第8章 使用GestureDetector进行手势识别");
        arr_data.add("3.9 第9章 使用GestureOverlayView进行手势识别");



        arr_adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data);
        listView.setAdapter(arr_adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day0_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 1:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day1_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day2_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day3_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 4:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day4_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 5:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day5_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 6:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day6_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 7:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day7_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 8:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day8_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
            case 9:{
                Intent intent = new Intent(home3_MainActivity.this, home3_day9_activity.class);
                home3_MainActivity.this.startActivity(intent);
                break;
            }
        }

    }




}
