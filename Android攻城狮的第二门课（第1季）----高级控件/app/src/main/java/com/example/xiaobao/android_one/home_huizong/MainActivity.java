package com.example.xiaobao.android_one.home_huizong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Button btn;
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;
    private List<String> arr_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.root);
        demo1();
    }

    public void demo1() {
        listView = (ListView) findViewById(R.id.root_listview);
        arr_data = new ArrayList<String>();
        arr_data.add("Android入门篇）");
        arr_data.add("home1：Android（第1季）----高级控件");
        arr_data.add("home2：Android（第2季）---消息提示和菜单");
        arr_data.add("home3：Android (第3季）----四大组件与存储");
        arr_data.add("home4：Android面试常客Handler详解");
        arr_data.add("home5：Android中的Http通信");
        arr_data.add("home6：ListView的常见使用模式");

        


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

                break;
            }
            case 1: {
                Intent intent = new Intent(MainActivity.this, home1_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 2: {
                Intent intent = new Intent(MainActivity.this, home2_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 3: {
                Intent intent = new Intent(MainActivity.this, home3_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 4: {
                Intent intent = new Intent(MainActivity.this, home4_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 5: {
                Intent intent = new Intent(MainActivity.this, home5_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }


        }


        Toast.makeText(this, i + 1 + "", Toast.LENGTH_SHORT).show();
    }


}
