package com.example.xiaobao.xiaobaokotlin.home1.day15;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/9.
 */

public class day15_Activity extends Activity {
    TextView title_tv;
    private Button button;
    private ViewStub stub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day15_mainview);

        title_tv = findViewById(R.id.common_title_title);
        title_tv.setText("自定义布局");

        button = findViewById(R.id.day15_button);
        stub = findViewById(R.id.day15_stub);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stub.inflate();
            }
        });

    }
}
