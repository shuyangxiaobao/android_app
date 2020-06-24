package com.example.xiaobao.android_one.home4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

import java.security.PrivateKey;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home4_day2_activity extends Activity {

    private Handler handler = new Handler();
    private ImageView imageView;
    private int images[] = {R.drawable.day11_pic1, R.drawable.day11_pic2, R.drawable.day11_pic3};
    private int index;
    private MyRunnable myRunnable = new MyRunnable();

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            index++;
            index = index % 3;
            imageView.setImageResource(images[index]);
            handler.postDelayed(myRunnable, 1000);

        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home4_day2_mainview);
        imageView = findViewById(R.id.home4_day2_imageview);
        handler.postDelayed(myRunnable, 1000);
    }


}
