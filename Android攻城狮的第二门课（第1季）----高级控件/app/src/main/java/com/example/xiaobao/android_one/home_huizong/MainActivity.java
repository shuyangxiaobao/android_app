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
        arr_data.add("home7：Android动画基础");
        arr_data.add("home8：Activity");
        arr_data.add("home9：androidannotations框架");
        arr_data.add("home10：Volley框架");
        arr_data.add("home11：各种类型Drawable讲解");
        arr_data.add("home12：Canvas 绘图 和矩阵变换");
        arr_data.add("home13：");
        arr_data.add("home14：");
        arr_data.add("home15：");
        arr_data.add("home16：");
        arr_data.add("home17：");
        arr_data.add("home18：");
        arr_data.add("home19：");
        arr_data.add("home20：");

        


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
            case 6: {
                Intent intent = new Intent(MainActivity.this, home6_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 7: {
                Intent intent = new Intent(MainActivity.this, home7_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 8: {
                Intent intent = new Intent(MainActivity.this, home8_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }

            case 9: {
                Intent intent = new Intent(MainActivity.this, home9_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }

            case 10: {
                Intent intent = new Intent(MainActivity.this, home10_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 11: {
                Intent intent = new Intent(MainActivity.this, home11_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 12: {
                Intent intent = new Intent(MainActivity.this, home12_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 13: {
                Intent intent = new Intent(MainActivity.this, home13_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 14: {
                Intent intent = new Intent(MainActivity.this, home14_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 15: {
                Intent intent = new Intent(MainActivity.this, home15_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 16: {
                Intent intent = new Intent(MainActivity.this, home16_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 17: {
                Intent intent = new Intent(MainActivity.this, home17_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 18: {
                Intent intent = new Intent(MainActivity.this, home18_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 19: {
                Intent intent = new Intent(MainActivity.this, home19_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
            case 20: {
                Intent intent = new Intent(MainActivity.this, home20_MainActivity.class);
                MainActivity.this.startActivity(intent);
                break;
            }
        }
        Toast.makeText(this, i + 1 + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("home8_MainActivity", "onDestroy:  MainActivity");

    }
}
