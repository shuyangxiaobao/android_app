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
import com.example.xiaobao.android_one.home7.day1.home7_day1_activity;
import com.example.xiaobao.android_one.home9.day1.home9_day1_activity1_;


import java.util.ArrayList;
import java.util.List;


public class home9_MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
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
        arr_data.add("9.1 androidannotations");
        arr_data.add("9.2 androidannotations");
        arr_data.add("9.3 androidannotations");
        arr_data.add("9.4 androidannotations");


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
                Intent intent = new Intent(home9_MainActivity.this, home9_day1_activity1_.class);
                home9_MainActivity.this.startActivity(intent);
                break;
            }




            default:
                break;

        }

    }


}
