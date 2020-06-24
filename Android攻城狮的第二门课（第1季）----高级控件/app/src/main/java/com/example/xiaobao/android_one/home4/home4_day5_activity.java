package com.example.xiaobao.android_one.home4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by xiaobao on 2020/6/18.
 */

public class home4_day5_activity extends Activity {
    private TextView text;
    private HandlerThread thread_two;
    private Handler handler;





    class MyThread extends Thread {
        public Handler handler;
        private Looper looper;

        @Override
        public void run() {
            Looper.prepare();
            looper = Looper.myLooper();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    System.out.println("MyThread---子线程-----currentThread" + Thread.currentThread());
                }
            };
            Looper.loop();
        }
    }

    private MyThread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        demo2();

    }



    public void demo1(){
//        会奔溃，所以引出 demo2 知识
        TextView textView = new TextView(this);
        textView.setText("hello handler");
        setContentView(textView);

        thread = new MyThread();
        thread.start();

        handler = new Handler(thread.looper){
            @Override
            public void handleMessage(Message msg) {
                System.out.println(msg);
            }
        };
        handler.sendEmptyMessage(1);
    }

    public void demo2(){
        text = new TextView(this);
        text.setText("handler thread");
        setContentView(text);
        thread_two = new HandlerThread("handler thread");
        thread_two.start();
        handler = new Handler(thread_two.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                System.out.println("当前是子线程，用来执行耗时操作");
                System.out.println("currentThread-------->"+Thread.currentThread());
            }
        };

        handler.sendEmptyMessage(1);

    }
}
