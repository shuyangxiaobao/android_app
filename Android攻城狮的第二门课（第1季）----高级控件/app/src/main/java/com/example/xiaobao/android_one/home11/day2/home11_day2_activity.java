package com.example.xiaobao.android_one.home11.day2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import com.example.xiaobao.android_one.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by xiaobao on 2020/7/3.
 */


@EActivity(R.layout.home11_day2_firstview)
public class home11_day2_activity extends Activity {


    LinearLayout layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
