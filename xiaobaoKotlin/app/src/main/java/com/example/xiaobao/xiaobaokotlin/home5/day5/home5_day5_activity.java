package com.example.xiaobao.xiaobaokotlin.home5.day5;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home5_day5_activity extends Activity {
    private  int count = 0;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int result = msg.what;
            count += result;
            if (count == 3){
                textView.setText("success!");
            }

        }
    };
    private TextView textView;
    private Button button;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home5_day5_mainview);
        button = findViewById(R.id.home5_day5_button);
        textView = findViewById(R.id.home5_day5_textview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        DownLoad load = new DownLoad(handler);
                        load.downLoadFile("http://t7.baidu.com/it/u=3616242789,1098670747&fm=79&app=86&f=JPEG?w=900&h=1350");
                    }
                }.start();
            }
        });


//        http://t7.baidu.com/it/u=3616242789,1098670747&fm=79&app=86&f=JPEG?w=900&h=1350
//        http://192.168.205.20:8082/img/2.jpg

//        textView = findViewById(R.id.home5_day4_textview);
//        String url = "http://192.168.0.103:8082/girls.xml";
//        new XmlThread(url,handler,textView).start();
    }

}
