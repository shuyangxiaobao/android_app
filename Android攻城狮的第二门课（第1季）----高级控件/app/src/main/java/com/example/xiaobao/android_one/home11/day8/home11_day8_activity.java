package com.example.xiaobao.android_one.home11.day8;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.xiaobao.android_one.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/3.
 */


@EActivity(R.layout.home11_day8_firstview)
public class home11_day8_activity extends Activity {


    @ViewById
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    public void init(){

    }


    @Click(R.id.button1)
    public void button1_click(Button button) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.day11_pic2);
        imageView.setImageDrawable(new CircleDrawable(bitmap));
    }

    @Click(R.id.button2)
    public void button2_click(Button button) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.day11_pic2);
        imageView.setImageDrawable(new RoundDrawable(bitmap));
    }





}
