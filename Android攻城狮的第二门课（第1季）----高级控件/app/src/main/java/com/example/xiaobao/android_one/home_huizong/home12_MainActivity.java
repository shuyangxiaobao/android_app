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
import com.example.xiaobao.android_one.home12.day1.home12_day1_activity_;
import com.example.xiaobao.android_one.home12.day2.home12_day2_activity_;
import com.example.xiaobao.android_one.home12.day3.home12_day3_activity_;
import com.example.xiaobao.android_one.home12.day4.home12_day4_activity_;
import com.example.xiaobao.android_one.home12.day5.home12_day5_activity_;
import com.example.xiaobao.android_one.home12.day6.home12_day6_activity_;
import com.example.xiaobao.android_one.home12.day7.home12_day7_activity;
import com.example.xiaobao.android_one.home12.day8.home12_day8_activity_;

import java.util.ArrayList;
import java.util.List;


public class home12_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        arr_data.add("12.1 Canvas 绘图");
        arr_data.add("12.2 贝塞尔曲线");
        arr_data.add("12.3 自定义手指轨迹画板");
        arr_data.add("12.4 自定义手指轨迹画板(贝塞尔曲线)");
        arr_data.add("12.5 水波纹效果");
        arr_data.add("12.6 rQuadTo 和 quadTo 区别");
        arr_data.add("12.7 Matrix(矩阵)变换");
        arr_data.add("12.8 ");



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
                Intent intent = new Intent(home12_MainActivity.this, home12_day1_activity_.class);
                home12_MainActivity.this.startActivity(intent);
                break;
            }
            case 2: {
                Intent intent = new Intent(home12_MainActivity.this, home12_day2_activity_.class);
                home12_MainActivity.this.startActivity(intent);
                break;
            }
            case 3: {
                Intent intent = new Intent(home12_MainActivity.this, home12_day3_activity_.class);
                home12_MainActivity.this.startActivity(intent);
                break;
            }
            case 4: {
                Intent intent = new Intent(home12_MainActivity.this, home12_day4_activity_.class);
                home12_MainActivity.this.startActivity(intent);
                break;
            }
            case 5: {
                Intent intent = new Intent(home12_MainActivity.this, home12_day5_activity_.class);
                home12_MainActivity.this.startActivity(intent);
                break;
            }
            case 6: {
                Intent intent = new Intent(home12_MainActivity.this, home12_day6_activity_.class);
                home12_MainActivity.this.startActivity(intent);
                break;
            }
            case 7: {
                Intent intent = new Intent(home12_MainActivity.this, home12_day7_activity.class);
                home12_MainActivity.this.startActivity(intent);
                break;
            }
            case 8: {
                Intent intent = new Intent(home12_MainActivity.this, home12_day8_activity_.class);
                home12_MainActivity.this.startActivity(intent);
                break;
            }




            default:
                break;

        }

    }


}
