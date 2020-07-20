package com.example.xiaobao.xiaobaokotlin.home11.day6;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.example.xiaobao.xiaobaokotlin.R;

import org.androidannotations.annotations.EActivity;

/**
 * Created by xiaobao on 2020/7/3.
 */


@EActivity(R.layout.home11_day6_firstview)
public class home11_day6_activity extends Activity {


    LinearLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home11_day6_firstview);

    }

}
