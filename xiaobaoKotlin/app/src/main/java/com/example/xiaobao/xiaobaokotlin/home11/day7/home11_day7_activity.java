package com.example.xiaobao.xiaobaokotlin.home11.day7;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.xiaobao.xiaobaokotlin.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/3.
 */


@EActivity(R.layout.home11_day7_firstview)
public class home11_day7_activity extends Activity {

    @ViewById
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @AfterViews
    public void init(){
        ClipDrawable drawable = (ClipDrawable) imageView.getDrawable();
        drawable.setLevel(5000);
        // 10000 时全部显示
    }
}
