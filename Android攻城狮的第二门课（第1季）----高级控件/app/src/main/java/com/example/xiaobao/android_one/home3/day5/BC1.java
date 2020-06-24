package com.example.xiaobao.android_one.home3.day5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by xiaobao on 2020/6/15.
 */

public class BC1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        System.out.println("BC1 收到消息:"+s);
        Bundle bundle = new Bundle();
        bundle.putString("test","广播处理的数据");
        setResultExtras(bundle);
    }
}
