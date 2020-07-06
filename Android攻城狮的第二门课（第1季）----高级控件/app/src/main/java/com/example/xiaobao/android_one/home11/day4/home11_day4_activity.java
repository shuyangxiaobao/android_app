package com.example.xiaobao.android_one.home11.day4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/3.
 */


@EActivity(R.layout.home11_day4_firstview)
public class home11_day4_activity extends Activity {

    @ViewById
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    public void init() {
        imageView.setImageLevel(0);
    }

    @Click(R.id.button1)
    public void button1_click(Button button) {
        imageView.setImageLevel(4);
        Toast.makeText(this, "111", Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.button2)
    public void button2_click(Button button) {
        imageView.setImageLevel(9);
        Toast.makeText(this, "222", Toast.LENGTH_SHORT).show();


    }


}
