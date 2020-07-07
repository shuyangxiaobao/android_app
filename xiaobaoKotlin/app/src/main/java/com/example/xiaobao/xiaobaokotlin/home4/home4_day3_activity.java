package com.example.xiaobao.xiaobaokotlin.home4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home4_day3_activity extends Activity {

//    发送message 带参数
    private Handler handler1 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            textView.setText("" + msg.arg1 + msg.arg2 + msg.obj);
        }
    };

    private Handler handler2 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(home4_day3_activity.this, ""+1, Toast.LENGTH_SHORT).show();
            return false;

//            return true 消息拦截，下面的不执行

        }
    }){
        public void handleMessage(Message msg) {
            Toast.makeText(home4_day3_activity.this, ""+2, Toast.LENGTH_SHORT).show();

        }
    };

    private ImageView imageView;
    private TextView textView;
    private int images[] = {R.drawable.day11_pic1, R.drawable.day11_pic2, R.drawable.day11_pic3};
    private int index;
    private MyRunnable myRunnable = new MyRunnable();

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            index++;
            index = index % 3;
            imageView.setImageResource(images[index]);
            handler1.postDelayed(myRunnable, 1000);

        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home4_day3_mainview);
        imageView = findViewById(R.id.home4_day3_imageview);
        textView = findViewById(R.id.home4_day3_textview1);

        handler1.postDelayed(myRunnable, 1000);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    send3();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    public void doclick(View view){
        switch (view.getId()){
            case R.id.home4_day3_button1:{
                //暂停
                handler1.removeCallbacks(myRunnable);
                break;
            }
            case R.id.home4_day3_button2:{
                handler2.sendEmptyMessage(1);
                break;
            }
            default:
                break;
        }
    }



    private void send1() {
        Message message = new Message();
        message.arg1 = 88;
        message.arg2 = 100;
        Person person = new Person();
        person.age = 18;
        person.name = "xiaolaopo";
        message.obj = person;
        handler1.sendMessage(message);
    }
    private void send2() {
        Message message = handler1.obtainMessage();
        message.arg1 = 88;
        message.arg2 = 100;
        Person person = new Person();
        person.age = 18;
        person.name = "xiaolaopo";
        message.obj = person;
        handler1.sendMessage(message);
    }
    private void send3() {
        Message message = handler1.obtainMessage();
        message.arg1 = 88;
        message.arg2 = 100;
        Person person = new Person();
        person.age = 18;
        person.name = "xiaolaopo";
        message.obj = person;
        message.sendToTarget();
    }


    class Person {
        private int age;
        private String name;

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


}
