package com.example.xiaobao.android_one.home12.day7;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xiaobao.android_one.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/3.
 */
public class home12_day7_activity extends Activity {

    private MyViews myViews;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home12_day7_firstview);
        initUI();
    }





    public void initUI(){
        myViews= (MyViews) findViewById(R.id.activity_myview_myview);


        //重置
        textView1= (TextView) findViewById(R.id.activity_myview_textview1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViews.setMethod(0);
            }
        });


        //左倾
        textView2= (TextView) findViewById(R.id.activity_myview_textview2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViews.setMethod(1);
            }
        });


        //右倾
        textView3= (TextView) findViewById(R.id.activity_myview_textview3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViews.setMethod(2);
            }
        });


        //放大
        textView4= (TextView) findViewById(R.id.activity_myview_textview4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViews.setMethod(3);
            }
        });


        //缩小
        textView5= (TextView) findViewById(R.id.activity_myview_textview5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViews.setMethod(4);
            }
        });
    }



}
