package com.example.xiaobao.xiaobaokotlin.home12.day8;

import android.app.Activity;
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
@EActivity(R.layout.home12_day8_firstview)
public class home12_day8_activity extends Activity {

    @ViewById(R.id.customView)
    home12_day8_customview customView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home12_day8_firstview);

    }

    @AfterViews
    public void init(){
        customView.start();
    }
}
