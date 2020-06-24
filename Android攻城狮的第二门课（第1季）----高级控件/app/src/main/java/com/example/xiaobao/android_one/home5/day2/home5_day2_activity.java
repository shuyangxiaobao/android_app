package com.example.xiaobao.android_one.home5.day2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home5_day2_activity extends Activity {
    private EditText name;
    private EditText age;
    private Button regist;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home5_day2_mainview);

        initEvent();
    }

    public void initEvent() {

        name = findViewById(R.id.home5_day2_name);
        age = findViewById(R.id.home5_day2_age);
        regist = findViewById(R.id.home5_day2_registerButton);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               demo3();
            }
        });

    }

    private void demo1(){
        String url = "http://192.168.0.103:8082/MyServlet";
        new HttpThread1(url,name.getText().toString(),age.getText().toString()).start();
    }

    private void demo2(){
        // doHttpClientGet   get请求
        String url_client = "http://192.168.0.103:8082/MyServlet?name="+name.getText().toString()+"&age="+age.getText().toString();
        new HttpClientThread(url_client).start();
    }
    private void demo3(){
//        doHttpClientPost post请求
        String url = "http://192.168.0.103:8082/MyServlet";
        new HttpClientThread(url,name.getText().toString(),age.getText().toString()).start();
    }

}
