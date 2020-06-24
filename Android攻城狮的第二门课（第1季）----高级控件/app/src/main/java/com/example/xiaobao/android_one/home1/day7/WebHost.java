package com.example.xiaobao.android_one.home1.day7;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by xiaobao on 2020/6/23.
 */

public class WebHost {

    public Context context;

    public WebHost(Context context) {
        this.context = context;
    }


    @JavascriptInterface
    public void callJs(){
        Toast.makeText(context, "call from js", Toast.LENGTH_SHORT).show();
        System.out.println("11111111111111");
    }
}
