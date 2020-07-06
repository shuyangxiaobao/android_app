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
import com.example.xiaobao.android_one.home11.day1.home11_day1_activity_;
import com.example.xiaobao.android_one.home11.day2.home11_day2_activity_;
import com.example.xiaobao.android_one.home11.day3.home11_day3_activity_;
import com.example.xiaobao.android_one.home11.day4.home11_day4_activity_;
import com.example.xiaobao.android_one.home11.day5.home11_day5_activity_;
import com.example.xiaobao.android_one.home11.day6.home11_day6_activity_;
import com.example.xiaobao.android_one.home11.day7.home11_day7_activity_;
import com.example.xiaobao.android_one.home11.day8.home11_day8_activity_;

import java.util.ArrayList;
import java.util.List;


public class home11_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        arr_data.add("11.1 BitmapDrawable的用法");
        arr_data.add("11.2 LayerDrawable的用法");
        arr_data.add("11.3 StateListDrawable的用法");
        arr_data.add("11.4 LevelListDrawable的用法");
        arr_data.add("11.5 TransitionDrawable的用法");
        arr_data.add("11.6 InsertDrawable的用法");
        arr_data.add("11.7 ClipDrawable的用法");
        arr_data.add("11.8 编写自定义Drawable");



        arr_adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                arr_data);
        listView.setAdapter(arr_adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i+1) {
            case 1: {
                Intent intent = new Intent(home11_MainActivity.this, home11_day1_activity_.class);
                home11_MainActivity.this.startActivity(intent);
                break;
            }
            case 2: {
                Intent intent = new Intent(home11_MainActivity.this, home11_day2_activity_.class);
                home11_MainActivity.this.startActivity(intent);
                break;
            }
            case 3: {
                Intent intent = new Intent(home11_MainActivity.this, home11_day3_activity_.class);
                home11_MainActivity.this.startActivity(intent);
                break;
            }
            case 4: {
                Intent intent = new Intent(home11_MainActivity.this, home11_day4_activity_.class);
                home11_MainActivity.this.startActivity(intent);
                break;
            }
            case 5: {
                Intent intent = new Intent(home11_MainActivity.this, home11_day5_activity_.class);
                home11_MainActivity.this.startActivity(intent);
                break;
            }
            case 6: {
                Intent intent = new Intent(home11_MainActivity.this, home11_day6_activity_.class);
                home11_MainActivity.this.startActivity(intent);
                break;
            }
            case 7: {
                Intent intent = new Intent(home11_MainActivity.this, home11_day7_activity_.class);
                home11_MainActivity.this.startActivity(intent);
                break;
            }
            case 8: {
                Intent intent = new Intent(home11_MainActivity.this, home11_day8_activity_.class);
                home11_MainActivity.this.startActivity(intent);
                break;
            }


            default:
                break;

        }

    }


}
