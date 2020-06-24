package com.example.xiaobao.android_one.home_huizong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home1.day02_activity;
import com.example.xiaobao.android_one.home1.day03_Activity;
import com.example.xiaobao.android_one.home1.day04_Activity;
import com.example.xiaobao.android_one.home1.day05_Activity;
import com.example.xiaobao.android_one.home1.day06_Activity;
import com.example.xiaobao.android_one.home1.day7.day07_webview_Activity;
import com.example.xiaobao.android_one.home1.day08_fragment.day08_fragment_Activity;
import com.example.xiaobao.android_one.home1.day10_viewpager.day10_Activity;
import com.example.xiaobao.android_one.home1.day11_viewFlipper.day11_Activity;
import com.example.xiaobao.android_one.home1.day12_scrollview.day12_Activity;
import com.example.xiaobao.android_one.home1.day13_Gallery.day13_Activity;
import com.example.xiaobao.android_one.home1.day14_SeekBar.day14_Activity;
import com.example.xiaobao.android_one.home1.day15.day15_Activity;


public class home1_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        arr_data.add("第1章 解读AndroidManifest配置文件");
        arr_data.add("第2章 使用ListView显示信息列表");
        arr_data.add("第3章 使用DatePicker以及TimePicker显示当前日期和时间");
        arr_data.add("第4章 使用GridView以表格形式显示多张图片");
        arr_data.add("第5章 使用Spinner实现下拉列表");
        arr_data.add("第6章 使用ProgressBar实现进度条");
        arr_data.add("第7章 使用WebView显示网页");
        arr_data.add("第8章 Fragment基础概述");
        arr_data.add("第9章 Fragment与Activity通信");
        arr_data.add("第10章 使用ViewPager实现导航");
        arr_data.add("第11章 使用ViewFlipper实现屏幕切换动画效果");
        arr_data.add("第12章 使用ScrollView实现滚动效果");
        arr_data.add("第13章 使用Gallery和ImageSwitcher制作图片浏览器");
        arr_data.add("第14章 使用SeekBar制作可拖动的进度条");
        arr_data.add("第15章 Android布局优化（大结局）");


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
                Intent intent = new Intent();
                intent.setAction("day01");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
                break;
            }
            case 1:{
                Intent intent = new Intent(home1_MainActivity.this, day02_activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 2:{
                Intent intent = new Intent(home1_MainActivity.this, day03_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 3:{
                Intent intent = new Intent(home1_MainActivity.this, day04_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 4:{
                Intent intent = new Intent(home1_MainActivity.this, day05_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 5:{
                Intent intent = new Intent(home1_MainActivity.this, day06_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 6:{
                Intent intent = new Intent(home1_MainActivity.this, day07_webview_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 7:{
                Intent intent = new Intent(home1_MainActivity.this, day08_fragment_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 8:{
                Intent intent = new Intent(home1_MainActivity.this, day08_fragment_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 9:{
                Intent intent = new Intent(home1_MainActivity.this, day10_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 10:{
                Intent intent = new Intent(home1_MainActivity.this, day11_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 11:{
                Intent intent = new Intent(home1_MainActivity.this,day12_Activity.class );
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 12:{
                Log.i("main", "onItemClick: "+i);
                Log.i("xlp", "onItemClick: "+i);
                Intent intent = new Intent(home1_MainActivity.this,day13_Activity.class );
                home1_MainActivity.this.startActivity(intent);
                for (int t = 0; t< 100;t++){
                    System.out.println(t);
                }
                break;
            }
            case 13:{
                Intent intent = new Intent(home1_MainActivity.this,day14_Activity.class );
                home1_MainActivity.this.startActivity(intent);
                break;
            }
            case 14:{
                Intent intent = new Intent(home1_MainActivity.this, day15_Activity.class);
                home1_MainActivity.this.startActivity(intent);
                break;
            }
        }


        Toast.makeText(this, i+1+"", Toast.LENGTH_SHORT).show();
    }




}
