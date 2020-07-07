package com.example.xiaobao.xiaobaokotlin.home3.day5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home3.day5.home3_day5_activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day5_activity extends Activity implements View.OnClickListener {

    List<BroadcastReceiver> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day5_mainview);
        findViewById(R.id.home3_day5_btn1).setOnClickListener(this);
        findViewById(R.id.home3_day5_btn2).setOnClickListener(this);
        findViewById(R.id.home3_day5_btn3).setOnClickListener(this);

        list = new ArrayList<BroadcastReceiver>();
        //                动态注册
//        IntentFilter intentFilter = new IntentFilter("BC1");
//        BC2 bc2 = new BC2();
//        registerReceiver(bc2, intentFilter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home3_day5_btn1: {
                Toast.makeText(this, "发送了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("msg", "这是一条普通广播");
                intent.setAction("BC1");
                sendBroadcast(intent);
                break;
            }
            case R.id.home3_day5_btn2: {
                Toast.makeText(this, "发送了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("msg", "这是一条有序广播");
                intent.setAction("BC1");
                sendOrderedBroadcast(intent, null);
                break;
            }

            case R.id.home3_day5_btn3: {
                Toast.makeText(this, "发送了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.putExtra("msg", "这是一条异步广播");
                intent.setAction("BC_Three");
                sendStickyBroadcast(intent);

                IntentFilter intentFilter = new IntentFilter("BC_Three");
                BC3 bc3 = new BC3();
                registerReceiver(bc3, intentFilter);
                list.add(bc3);
                break;
            }
            default:
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (BroadcastReceiver recriver:list){
            unregisterReceiver(recriver);
        }
    }
}
