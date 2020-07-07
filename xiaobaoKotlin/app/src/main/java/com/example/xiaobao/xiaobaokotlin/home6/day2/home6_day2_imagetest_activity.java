package com.example.xiaobao.xiaobaokotlin.home6.day2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.xiaobao.xiaobaokotlin.R;


/**
 * Created by xiaobao on 2020/6/10.
 */

public class home6_day2_imagetest_activity extends Activity {
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private static String URL_String = "http://img.mukewang.com/5518bbe30001c32006000338-300-170.jpg";



    private Handler handler = new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home6_day2_imagetest);
        mImageView = findViewById(R.id.home6_day2_imageview);
        mProgressBar = findViewById(R.id.home6_day2_progressbar);
        demo2();

    }


    public void demo1(){
        home6_day2_myAsyncTask task = new home6_day2_myAsyncTask();
        task.execute();
    }

    public void demo2(){
        home6_day2_myAsyncTask2 task = new home6_day2_myAsyncTask2(mImageView,mProgressBar);
        task.execute(URL_String);
    }

}
