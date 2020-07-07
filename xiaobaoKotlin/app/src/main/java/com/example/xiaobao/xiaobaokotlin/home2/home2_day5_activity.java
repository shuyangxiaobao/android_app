package com.example.xiaobao.xiaobaokotlin.home2;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

//import com.example.xiaobao.xiaobaokotlin.home_huizong.MainActivity;
import com.example.xiaobao.xiaobaokotlin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home2_day5_activity extends Activity {

    NotificationManager manager; //通知控制类
    int notfication_ID;
    static final int NOTIFICATION_ID = 0x1123;
    List<Integer> idList;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_day5_mainview);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        idList = new ArrayList<Integer>();
        this.initEvent();
    }

    private void initEvent() {
        Button btn1 = (Button) findViewById(R.id.home2_day5_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast1();
            }

        });

        Button btn2 = (Button) findViewById(R.id.home2_day5_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast2();
            }

        });


    }

    //发送通知
    private void showToast1() {
        notfication_ID++;
        idList.add(notfication_ID);
        System.out.println("23456789");
//        this.sendNotfication();
    }


    //    取消通知
    private void showToast2() {
        if (idList.size() > 0){
            manager.cancel(idList.remove(0));
        }
    }

//    private void sendNotfication() {
//        String channelID = "1";
//        String channelName = "channel_name";
//        Intent intent = new Intent(this, MainActivity.class);
//        PendingIntent pintent = PendingIntent.getActivity(this, 0, intent, 0);
//        Notification.Builder builder = new Notification.Builder(this);
//        builder.setSmallIcon(R.drawable.czc);//设置图标
//        builder.setTicker("hello");//手机状态栏的提示
//        builder.setWhen(System.currentTimeMillis()); //设置时间
//        builder.setContentTitle("通知栏通知"); //设置标题
//        builder.setContentText("我来自NotficationDemo"); //设置通知内容
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            builder.setChannelId("1");
//        }
//        builder.setContentIntent(pintent); //点击后的意图
////        builder.setDefaults(Notification.DEFAULT_SOUND); //设置提示声音
////        builder.setDefaults(Notification.DEFAULT_LIGHTS); //设置指示灯
////        builder.setDefaults(Notification.DEFAULT_VIBRATE); //设置震动
//        builder.setDefaults(Notification.DEFAULT_ALL); //全部
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);
//            manager.createNotificationChannel(channel);
//            builder.setChannelId(channelID);
//        }
//        Notification notification = null;
//        System.out.println(Build.VERSION.SDK_INT);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            notification = builder.build(); // 4.1 以上
//        } else {
//            notification = builder.getNotification();// 以下
//        }
//        manager.notify(notfication_ID, notification);
//    }




}
