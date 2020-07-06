package com.example.xiaobao.android_one.home_huizong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home8.day1.home8_day1_activity_first;
import com.example.xiaobao.android_one.home8.day2.home8_day2_activity_first;
import com.example.xiaobao.android_one.home8.day3.home8_day3_activity_first;
import com.example.xiaobao.android_one.home8.day4.home8_day4_activity_first;
import com.example.xiaobao.android_one.home8.day5.home8_day5_activity_first;

import java.util.ArrayList;
import java.util.List;


public class home8_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button btn;
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;
    private List<String> arr_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home1_activity_main);
        demo1();
        System.out.println("++++++++++++:"+getTaskId());

    }

    public void demo1() {
        listView = (ListView) findViewById(R.id.listview);
        arr_data = new ArrayList<String>();
        arr_data.add("8.1 Activity生命周期 以及 横竖屏切换");
        arr_data.add("8.2 启动Activity方式");
        arr_data.add("8.3 Activity数据交换");
        arr_data.add("8.4 taskid");
        arr_data.add("8.5 启动模式");

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
                Intent intent = new Intent(home8_MainActivity.this, home8_day1_activity_first.class);
                home8_MainActivity.this.startActivity(intent);
                break;
            }
            case 1: {
                Intent intent = new Intent(home8_MainActivity.this, home8_day2_activity_first.class);
                home8_MainActivity.this.startActivity(intent);
                break;
            }

            case 2: {
                Intent intent = new Intent(home8_MainActivity.this, home8_day3_activity_first.class);
                home8_MainActivity.this.startActivity(intent);
                break;
            }
            case 3: {
                Intent intent = new Intent(home8_MainActivity.this, home8_day4_activity_first.class);
                home8_MainActivity.this.startActivity(intent);
                break;
            }
            case 4: {
                Intent intent = new Intent(home8_MainActivity.this, home8_day5_activity_first.class);
                home8_MainActivity.this.startActivity(intent);
                break;
            }



            default:
                break;

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("home8_MainActivity", "onDestroy:  home8_MainActivity");
    }
}
