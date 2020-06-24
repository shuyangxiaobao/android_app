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
import com.example.xiaobao.android_one.home5.day1.home5_day1_activity;
import com.example.xiaobao.android_one.home5.day2.home5_day2_activity;
import com.example.xiaobao.android_one.home5.day3.home5_day3_activity;
import com.example.xiaobao.android_one.home5.day4.home5_day4_activity;
import com.example.xiaobao.android_one.home5.day5.*;
import com.example.xiaobao.android_one.home5.day6.*;

import java.util.ArrayList;
import java.util.List;


public class home5_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        arr_data.add("1. HttpUrlConnection介绍");
        arr_data.add("2. post、get传递参数（上）");
        arr_data.add("3. 加载json数据，显示列表");
        arr_data.add("4. xml解析");
        arr_data.add("5. 3-1 android多线程下载网络图片");
        arr_data.add("6. 3-3 http方式实现图片上传");



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
                Intent intent = new Intent(home5_MainActivity.this, home5_day1_activity.class);
                home5_MainActivity.this.startActivity(intent);
                break;
            }
            case 1:{
                Intent intent = new Intent(home5_MainActivity.this, home5_day2_activity.class);
                home5_MainActivity.this.startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(home5_MainActivity.this, home5_day3_activity.class);
                home5_MainActivity.this.startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(home5_MainActivity.this, home5_day4_activity.class);
                home5_MainActivity.this.startActivity(intent);
                break;
            }
            case 4:{
                Intent intent = new Intent(home5_MainActivity.this, home5_day5_activity.class);
                home5_MainActivity.this.startActivity(intent);
                break;
            }
            case 5:{
                Intent intent = new Intent(home5_MainActivity.this, home5_day6_activity.class);
                home5_MainActivity.this.startActivity(intent);
                break;
            }
           default:
               break;

        }

    }




}
