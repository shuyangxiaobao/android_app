package com.example.xiaobao.android_one.home6.day1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home5.day1.HttpThread2;


/**
 * Created by xiaobao on 2020/6/10.
 */

public class home6_day1_activity extends Activity {

    private WebView webview;
    private ImageView imageView;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home5_day1_mainview);
        Toast.makeText(this, "home5_day1_activity", Toast.LENGTH_SHORT).show();

        webview = (WebView) findViewById(R.id.webview);
        imageView = (ImageView) findViewById(R.id.image);

        new HttpThread2("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592589789538&di=3813df20f8265df207a2a1ebffc2fdbb&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fpic%2F2%2F37%2F2486529675.jpg",imageView,handler).start();

//        new HttpThread("https://www.pgyer.com",webview,handler).start();

    }

}
