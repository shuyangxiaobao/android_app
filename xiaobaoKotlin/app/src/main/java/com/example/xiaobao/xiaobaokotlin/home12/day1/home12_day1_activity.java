package com.example.xiaobao.xiaobaokotlin.home12.day1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by xiaobao on 2020/7/3.
 */
@EActivity(R.layout.home12_day1_firstview)
public class home12_day1_activity extends Activity {

    @ViewById(R.id.imageView)
    ImageView imageView;

    @ViewById(R.id.layout)
    LinearLayout linearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.home12_day1_firstview);
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    public void init(){
        System.out.println("23423");
        Toast.makeText(this, "890", Toast.LENGTH_SHORT).show();

    }
}
