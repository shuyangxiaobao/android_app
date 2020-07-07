package com.example.xiaobao.xiaobaokotlin.home3.day5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by xiaobao on 2020/6/15.
 */

public class BC2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        System.out.println("BC2 收到消息:"+s);
        Bundle bundle = getResultExtras(true);
        String string = bundle.getString("test");
        System.out.println("得到的处理结果是：" + string);
    }
}
