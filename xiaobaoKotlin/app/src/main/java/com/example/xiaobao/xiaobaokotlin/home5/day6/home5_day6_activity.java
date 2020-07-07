package com.example.xiaobao.xiaobaokotlin.home5.day6;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home5.day5.DownLoad;

import java.io.File;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home5_day6_activity extends Activity {

    private Button button;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home5_day6_mainview);
        button = findViewById(R.id.home5_day6_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String url = "http://192.168.0.107:8082/day15_response_war_exploded/UploadServlet";
                        File file = Environment.getExternalStorageDirectory();
                        File fileAbs = new File(file, "xlp_20200622.jpg");
                        String fileName = fileAbs.getAbsolutePath();
                        new UploadThread(fileName,url).start();
                    }
                }).start();


            }
        });


//        http://192.168.205.20:8082/day15_response_war_exploded/UploadServlet


    }

}
