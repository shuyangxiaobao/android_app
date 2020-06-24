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
import com.example.xiaobao.android_one.home1.day02_activity;
import com.example.xiaobao.android_one.home2.home2_day3_activity;
import com.example.xiaobao.android_one.home2.*;

import java.util.ArrayList;
import java.util.List;


public class home2_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        arr_data.add("第1章 使用Debug方式调试程序");
        arr_data.add("第2章 使用LogCat方式调试程序");
        arr_data.add("第3章 使用Toast动态显示信息");
        arr_data.add("第4章 使用AlertDialog实现提示框");
        arr_data.add("第5章 使用Notification实现状态通知栏的通知");
        arr_data.add("第6章 使用OptionsMenu实现选项菜单");
        arr_data.add("第7章 使用ContextMenu实现上下文菜单");
        arr_data.add("第8章 使用SubMenu创建子菜单");


        arr_adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data);
        listView.setAdapter(arr_adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i+1) {
            case 1:{
                Intent intent = new Intent();
                intent.setAction("day01");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(home2_MainActivity.this, day02_activity.class);
                home2_MainActivity.this.startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(home2_MainActivity.this, home2_day3_activity.class);
                home2_MainActivity.this.startActivity(intent);
                break;
            }
            case 4:{
                Intent intent = new Intent(home2_MainActivity.this, home2_day4_activity.class);
                home2_MainActivity.this.startActivity(intent);
                break;
            }
            case 5:{
                Intent intent = new Intent(home2_MainActivity.this, home2_day5_activity.class);
                home2_MainActivity.this.startActivity(intent);
                break;
            }
            case 6:{
                Intent intent = new Intent(home2_MainActivity.this, home2_day6_activity.class);
                home2_MainActivity.this.startActivity(intent);
                break;
            }
            case 7:{
                Intent intent = new Intent(home2_MainActivity.this, home2_day7_activity.class);
                home2_MainActivity.this.startActivity(intent);
                break;
            }
            case 8:{
                Intent intent = new Intent(home2_MainActivity.this, home2_day8_activity.class);
                home2_MainActivity.this.startActivity(intent);
                break;
            }

        }


//        Toast.makeText(this, i+1+"", Toast.LENGTH_SHORT).show();
    }




}
