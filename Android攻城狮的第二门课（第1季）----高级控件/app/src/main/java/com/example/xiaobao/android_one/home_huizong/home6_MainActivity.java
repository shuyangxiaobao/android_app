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
import com.example.xiaobao.android_one.home6.day1.home6_day1_activity;
import com.example.xiaobao.android_one.home6.day2.home6_day2_activity;
import com.example.xiaobao.android_one.home6.day3.home6_day3_activity;
import com.example.xiaobao.android_one.home6.day4.home6_day4_activity;
import com.example.xiaobao.android_one.home6.day5.home6_day5_activity;

import java.util.ArrayList;
import java.util.List;


public class home6_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        arr_data.add("6.1 Android必学-异步加载");
        arr_data.add("6.2 Android必学-AsyncTask基础");
        arr_data.add("Android必学-BaseAdapter的使用与优化");

        arr_adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data);
        listView.setAdapter(arr_adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0: {
                Intent intent = new Intent(home6_MainActivity.this, home6_day1_activity.class);
                home6_MainActivity.this.startActivity(intent);
                break;
            }
            case 1: {
                Intent intent = new Intent(home6_MainActivity.this, home6_day2_activity.class);
                home6_MainActivity.this.startActivity(intent);
                break;
            }
            case 2: {
                Intent intent = new Intent(home6_MainActivity.this, home6_day3_activity.class);
                home6_MainActivity.this.startActivity(intent);
                break;
            }
            case 3: {
                Intent intent = new Intent(home6_MainActivity.this, home6_day4_activity.class);
                home6_MainActivity.this.startActivity(intent);
                break;
            }
            case 4: {
                Intent intent = new Intent(home6_MainActivity.this, home6_day5_activity.class);
                home6_MainActivity.this.startActivity(intent);
                break;
            }
            default:
                break;

        }

    }


}
