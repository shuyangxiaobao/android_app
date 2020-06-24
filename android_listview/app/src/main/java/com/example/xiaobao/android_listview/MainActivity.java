package com.example.xiaobao.android_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener {
    private Button btn;
    private ListView listView;
    private ArrayAdapter<String> arr_adapter;
    private SimpleAdapter simp_adapter;

    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demo1();
    }

    public void demo1() {
        listView = (ListView) findViewById(R.id.listview);
//        String[] arr_data = {"111", "222", "333", "111", "222", "333",
//                "111", "222", "333", "111", "222", "333", "111", "222", "333",
//                "111", "222", "333", "111", "222", "333", "111", "222", "333"};
//        arr_adapter = new ArrayAdapter<String>(this,
//                R.layout.support_simple_spinner_dropdown_item,
//                arr_data);
//        listView.setAdapter(arr_adapter);


//        context:上下文
//        data:
//        resource:列表项的布局I
//        from:Map 中所指的键
//        to：绑定数据视图中的ID，与from形成对应关系


        simp_adapter = new SimpleAdapter(this, getData(),
                R.layout.item, new String[]{"pic3", "text3", "zhuli"},
                new int[]{R.id.pic2, R.id.text2, R.id.zhuli});
        listView.setAdapter(simp_adapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);


    }

    private List<Map<String, Object>> getData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("pic3", R.drawable.czc);
            map.put("text3", "苹果主力" + i);
            map.put("zhuli", R.drawable.zhuli);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = "i = " + i + "; l=" + l;
        Map<String, Object> map = dataList.get(i);
        String value = (String) map.get("text3");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
        System.out.println(
                i
        );
//         1 ---->
//         1 ----> 2---->  0
        //0： 停止滚动
        // 1 手按住拖动开始
        //2 屏幕惯性滚动期间

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
//        System.out.println(i+ ":"+i1+":"+i2);

    }


//    //    跳转页面
//    public void demo2() {
//        btn = (Button) findViewById(R.id.button);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction("aaa.bbb.ccc");
//                intent.addCategory("android.intent.category.DEFAULT");
//                startActivity(intent);
//            }
//        });
//    }


}
