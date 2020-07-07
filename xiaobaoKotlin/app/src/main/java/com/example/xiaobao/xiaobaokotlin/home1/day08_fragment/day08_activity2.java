package com.example.xiaobao.xiaobaokotlin.home1.day08_fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day08_activity2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_activity2_view);

        Button button = findViewById(R.id.day08_fragment_button);
        button.setText("改变");

        final TextView tv = findViewById(R.id.day08_fragment_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int origin =  new Integer(tv.getText().toString());
               tv.setText((origin+1)+"");
//                tv.setText("我是被更改的值");
            }
        });
    }
}
