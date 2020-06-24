package com.example.xiaobao.android_one.home1.day14_SeekBar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/9.
 */

public class day14_Activity extends Activity implements SeekBar.OnSeekBarChangeListener{

    private SeekBar seekBar;
    private SeekBar seekBar2;
    private SeekBar seekBar3;

    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day14_mainview);
        seekBar = findViewById(R.id.day14_mainview_seekbar);
        seekBar2 = findViewById(R.id.day14_mainview_seekbar2);
        seekBar3 = findViewById(R.id.day14_mainview_seekbar3);

        tv1 = findViewById(R.id.day14_mainview_text1);
        tv2 = findViewById(R.id.day14_mainview_text2);
        seekBar.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3.setOnSeekBarChangeListener(this);

    }

//数值改变
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        tv1.setText("当前数值"+i);
        tv2.setText("正在拖动");
    }

//    开始拖动
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        tv2.setText("开始拖动");

    }

//    停止拖动
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        tv2.setText("停止拖动");

    }
}
