package com.example.xiaobao.xiaobaokotlin.home11.day3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.xiaobao.xiaobaokotlin.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/3.
 */


@EActivity(R.layout.home11_day3_firstview)
public class home11_day3_activity extends Activity {


    @ViewById
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Click(R.id.button)
    public void button_click(Button button){
        button.setSelected(!button.isSelected());
    }

}
