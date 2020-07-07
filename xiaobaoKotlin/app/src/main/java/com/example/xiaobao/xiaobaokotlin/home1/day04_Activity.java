package com.example.xiaobao.xiaobaokotlin.home1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaobao on 2020/6/4.
 */

public class day04_Activity extends Activity implements AdapterView.OnItemClickListener {


    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private int[] icon = {R.drawable.snip20200605_41, R.drawable.snip20200605_41, R.drawable.snip20200605_41,
            R.drawable.snip20200605_44, R.drawable.snip20200605_44, R.drawable.snip20200605_44,
            R.drawable.snip20200605_45, R.drawable.snip20200605_45, R.drawable.snip20200605_45};
    private String[] name = {"111", "222", "333", "444", "555", "666", "777", "888", "999"};
    private SimpleAdapter adapter;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day4view);

        gridView = (GridView) findViewById(R.id.gridview);
//        1.准备数据源
//        2.新建适配器
//        3.GridView 加载适配器
//        4.GridView 配置事件监听器
        dataList = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(this, getdata(),
                R.layout.day4item, new String[]{"image", "title"},
                new int[]{R.id.day4imageview, R.id.day4textview});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    private List<Map<String, Object>> getdata() {

        for (int i = 0; i < name.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("title", name[i]);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,name[i],Toast.LENGTH_SHORT).show();
    }
}
