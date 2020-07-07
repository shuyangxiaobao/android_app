package com.example.xiaobao.xiaobaokotlin.home4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/18.
 */

public class home4_day6_activity extends Activity implements View.OnClickListener {


//    主线程的handler
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Message message = new Message();
            System.out.println("main handle");
//            向子线程发送消息
            threadHandler.sendMessageDelayed(message,1000);
        }
    };

    private Handler threadHandler;

    private Button sendButton;
    private Button stopButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home4_day6_mainview);
        sendButton = findViewById(R.id.home4_day6_button_send);
        stopButton = findViewById(R.id.home4_day6_button_stop);
        sendButton.setOnClickListener(home4_day6_activity.this);
        stopButton.setOnClickListener(home4_day6_activity.this);

        HandlerThread thread = new HandlerThread("handlerThread");
        thread.start();
//       创建子线程的handler
        threadHandler = new Handler(thread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                Message message = new Message();
                System.out.println("thread handle");
//                向主线程发送消息
                handler.sendMessageDelayed(message,1000);
            }
        };

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home4_day6_button_send:{
                handler.sendEmptyMessage(1);


                break;
            }
            case R.id.home4_day6_button_stop:{
                handler.removeMessages(1);
                handler = null;
                break;
            }
            default:
                break;
        }

    }
}







































