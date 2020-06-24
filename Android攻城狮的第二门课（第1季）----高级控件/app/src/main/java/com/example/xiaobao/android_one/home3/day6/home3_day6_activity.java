package com.example.xiaobao.android_one.home3.day6;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home3.day6.home3_day6_activity;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day6_activity extends Activity implements View.OnClickListener {

    Intent intent1;
    Intent intent2;
    MyBindService service;
    ServiceConnection conn = new ServiceConnection(){

//        当启动源跟Service的连接意外丢失的时候调用这个方法
//        比如当Service奔溃了或者强行杀死了
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
//        当启动源跟Service成功连接以后自动调用这个方法
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            service = ((MyBindService.MyBinder)iBinder).getService();
        }

        @Override
        public void onBindingDied(ComponentName name) {

        }
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day6_mainview);
        initevent();
    }

    private void initevent() {
        findViewById(R.id.home3_day6_button1).setOnClickListener(this);
        findViewById(R.id.home3_day6_button2).setOnClickListener(this);
        findViewById(R.id.home3_day6_button3).setOnClickListener(this);
        findViewById(R.id.home3_day6_button4).setOnClickListener(this);
        findViewById(R.id.home3_day6_button5).setOnClickListener(this);
        findViewById(R.id.home3_day6_button6).setOnClickListener(this);
        findViewById(R.id.home3_day6_button7).setOnClickListener(this);
    }

    public void doclick(View view){
        Toast.makeText(this, "43567890", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home3_day6_button1:{
                intent1 = new Intent(this,MyStartService.class);
                startService(intent1);
                break;
            }
            case R.id.home3_day6_button2:{
                stopService(intent1);
                break;
            }
            case R.id.home3_day6_button3:{
                intent2 = new Intent(this,MyBindService.class);
                bindService(intent2,conn, Service.BIND_AUTO_CREATE);
                break;
            }
            case R.id.home3_day6_button4:{
                service.play();
                break;
            }
            case R.id.home3_day6_button5:{
                service.pause();
                break;
            }
            case R.id.home3_day6_button6:{
                service.pervious();
                break;
            }
            case R.id.home3_day6_button7:{
                service.next();
                break;
            }
            case R.id.home3_day6_button8:{
                unbindService(conn);
                break;
            }
            default:
                break;
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
//        stopService(intent1);
    }
}
