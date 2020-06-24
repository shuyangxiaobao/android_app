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
import com.example.xiaobao.android_one.home4.home4_day1_activity;
import com.example.xiaobao.android_one.home4.home4_day2_activity;
import com.example.xiaobao.android_one.home4.home4_day3_activity;
import com.example.xiaobao.android_one.home4.*;

import java.util.ArrayList;
import java.util.List;


public class home4_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        arr_data.add("1.Handler post(Runnable)");
        arr_data.add("2.Handler postDelayed(Runnable, long);");
        arr_data.add("3.sendMessage");
        arr_data.add("4.sendMessageDelayed");
        arr_data.add("5.Handler与子线程");
        arr_data.add("第6章 主线程与子线程之间的信息交互");
        arr_data.add("第7章 解析Android中更新UI的几种方式");
        arr_data.add("第8章 非UI线程真的不能更新UI吗");
        arr_data.add("第9章 终章：使用Handler时候遇到的问题");




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
                Intent intent = new Intent(home4_MainActivity.this, home4_day1_activity.class);
                home4_MainActivity.this.startActivity(intent);
                break;
            }
            case 1:{
                Intent intent = new Intent(home4_MainActivity.this, home4_day2_activity.class);
                home4_MainActivity.this.startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(home4_MainActivity.this, home4_day3_activity.class);
                home4_MainActivity.this.startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(home4_MainActivity.this, home4_day4_activity.class);
                home4_MainActivity.this.startActivity(intent);
                break;
            }
            case 4:{
                Intent intent = new Intent(home4_MainActivity.this, home4_day5_activity.class);
                home4_MainActivity.this.startActivity(intent);
                break;
            }
            case 5:{
                Intent intent = new Intent(home4_MainActivity.this, home4_day6_activity.class);
                home4_MainActivity.this.startActivity(intent);
                break;
            }
            case 6:{
                Intent intent = new Intent(home4_MainActivity.this, home4_day7_activity.class);
                home4_MainActivity.this.startActivity(intent);
                break;
            }
            case 7:{
                Intent intent = new Intent(home4_MainActivity.this, home4_day8_activity.class);
                home4_MainActivity.this.startActivity(intent);
                break;
            }
            default:
                break;

        }

    }




}
