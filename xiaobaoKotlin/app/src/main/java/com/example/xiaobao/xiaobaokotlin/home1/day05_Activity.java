package com.example.xiaobao.xiaobaokotlin.home1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaobao on 2020/6/4.
 */

public class day05_Activity extends Activity implements AdapterView.OnItemSelectedListener {

    private TextView textView;
    private Spinner spinner;
    private List<String> list;
    private ArrayAdapter<String> adapter;
    private SimpleAdapter simpleAdapter;

    private List<Map<String,Object>> dataList;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day5view);
        textView = (TextView) findViewById(R.id.day5_textview);
        spinner = (Spinner) findViewById(R.id.day5_spinner);
        list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        list.add("南京");
        textView.setText("您选择的城市是北京");
        dataList = new ArrayList<Map<String,Object>>();

        if (false){
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item,
                    list);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }{
            simpleAdapter = new SimpleAdapter(this,getdata(),R.layout.day5item,new String[]{"image","text"},
                    new int[]{R.id.day5item_imageview,R.id.day5item_textview} );
            simpleAdapter.setDropDownViewResource(R.layout.day5item);

            spinner.setAdapter(simpleAdapter);
            spinner.setOnItemSelectedListener(this);

        }



    }

    private List<Map<String,Object>> getdata() {
        for(int i = 0;i<10;i++){
            Map map = new HashMap();
            map.put("image",R.drawable.czc);
            map.put("text","上海"+i);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        textView.setText("您选择的城市是" + dataList.get(i));

        textView.setText("您选择的城市是" + dataList.get(i).get("text"));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void demo(int x) {
        int t = x / 4 % 2;
        int b = 4*t+(1-2*t)*(x%4);
        System.out.println(b * 0.25);
        //        int a = x / 4 % 2 == 0 ? x % 4 : (4 - x % 4);
    }
}
