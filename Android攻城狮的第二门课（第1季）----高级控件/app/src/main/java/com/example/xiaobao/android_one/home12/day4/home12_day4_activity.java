package com.example.xiaobao.android_one.home12.day4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.xiaobao.android_one.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/3.
 */
@EActivity(R.layout.home12_day4_firstview)
public class home12_day4_activity extends Activity {

    @ViewById(R.id.imageView)
    ImageView imageView;

    @ViewById(R.id.layout)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    public void init(){


    }
}
