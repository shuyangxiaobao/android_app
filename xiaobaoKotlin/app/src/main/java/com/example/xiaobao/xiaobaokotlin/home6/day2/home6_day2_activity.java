package com.example.xiaobao.xiaobaokotlin.home6.day2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.xiaobao.xiaobaokotlin.R;


/**
 * Created by xiaobao on 2020/6/10.
 */

public class home6_day2_activity extends Activity {


    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home6_day2_mainview);
    }

    public void doclick(View view) {
        switch (view.getId()) {
            case R.id.home6_day2_button1: {
                Intent intent = new Intent(home6_day2_activity.this, home6_day2_imagetest_activity.class);
                home6_day2_activity.this.startActivity(intent);
                break;
            }

            case R.id.home6_day2_button2: {
                Intent intent = new Intent(home6_day2_activity.this, home6_day2_progressbar_activity.class);
                home6_day2_activity.this.startActivity(intent);
                break;
            }

            default: break;
        }

    }


}
