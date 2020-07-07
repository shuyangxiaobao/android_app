package com.example.xiaobao.xiaobaokotlin.home9.day1;

import android.app.Activity;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/2.
 */

@EActivity(R.layout.home9_day1_secondview)
public class home9_day1_activity2 extends Activity {

    @Extra(home9_day1_activity1.name_key)
    String name;

    @Extra(home9_day1_activity1.age_key)
    String age;


    @ViewById
    TextView textname;
    @ViewById
    TextView textage;


    @AfterViews
    public void initView(){
        textname.setText(name);
        textage.setText(age);
    }


}
