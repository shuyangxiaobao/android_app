package com.example.xiaobao.android_one.home2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home2_day3_activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_day3_mainview);
        this.initEvent();
    }

    private void initEvent() {
        Button btn1 = (Button) findViewById(R.id.home2_day3_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast1();
            }

        });

        Button btn2 = (Button) findViewById(R.id.home2_day3_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast2();
            }

        });

        Button btn3 = (Button) findViewById(R.id.home2_day3_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast3();
            }

        });

        Button btn4 = (Button) findViewById(R.id.home2_day3_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast4();
            }

        });

    }


    private void showToast1() {
        Toast toast = Toast.makeText(this, "这是一个默认的toast", (Integer) 2000);
        toast.show();

    }

    private void showToast2() {
        Toast toast = Toast.makeText(this, "改变位置的toast", (Integer) 2000);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    //带有图片的toast
    private void showToast3() {
        Toast toast = Toast.makeText(this, "带有图片的toast", (Integer) 2000);
        LinearLayout toastView = (LinearLayout) toast.getView();

        ImageView imageView = new ImageView(this);
        imageView.setMaxWidth(200);
        imageView.setMaxHeight(200);
        imageView.setImageResource(R.drawable.day11_pic1);
        toastView.addView(imageView);
//        toastView.addView(imageView,0);
        toast.show();
    }

    private void showToast4() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.home2_day3_toast_layout, null);
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);

        toast.setView(view);
        toast.show();

        Log.i("xlp", "showToast4: 890");
    }


}
