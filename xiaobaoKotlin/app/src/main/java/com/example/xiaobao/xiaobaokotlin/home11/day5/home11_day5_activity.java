package com.example.xiaobao.xiaobaokotlin.home11.day5;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/3.
 */


@EActivity(R.layout.home11_day5_firstview)
public class home11_day5_activity extends Activity {


    @ViewById
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home11_day5_firstview);

    }

    @AfterViews
    public void init() {
        imageView.setImageLevel(0);
    }

    @Click(R.id.button1)
    public void button1_click(Button button) {
        TransitionDrawable drawable = (TransitionDrawable)imageView.getDrawable();
        drawable.startTransition(3000);
    }

    @Click(R.id.button2)
    public void button2_click(Button button) {
        TransitionDrawable drawable = (TransitionDrawable)imageView.getDrawable();
        drawable.reverseTransition(3000);
    }

}
