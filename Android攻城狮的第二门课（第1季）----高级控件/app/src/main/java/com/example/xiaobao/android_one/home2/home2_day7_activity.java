package com.example.xiaobao.android_one.home2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home2_day7_activity extends Activity {
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_day7_mainview);
        showListView();

    }

    private void showListView() {
        listView = (ListView) findViewById(R.id.home2_day7_listview);
        arr_adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, getData());
        listView.setAdapter(arr_adapter);
        this.registerForContextMenu(listView);


    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu,v,menuInfo);
//        设置menu 显示内容
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.drawable.czc);

//        组  id  排序  标题
//        menu.add(1,1,1,"复制");


//        方式1：通过代码动态添加
        menu.add(1,1,1,"复制");
        menu.add(1,2,1,"粘贴");
        menu.add(1,3,1,"剪切");
        menu.add(1,4,1,"重命名");

//        方式2：通过布局添加
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home2_day7_main,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Toast.makeText(this, "点击了"+item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case 1:{

            }

        }
        return super.onContextItemSelected(item);
    }

    private List<String> getData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("文件" + (i + 1));
        }
        return list;
    }
}
