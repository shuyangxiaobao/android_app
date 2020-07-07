package com.example.xiaobao.xiaobaokotlin.home1.day12_scrollview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/9.
 */

public class day12_Activity extends Activity implements View.OnClickListener {
    private TextView textView;
    private ScrollView scrollView;
    private Button up_btn;
    private Button down_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day12_mainview);
        textView = findViewById(R.id.day12_mainview_content);
        textView.setText(getResources().getString(R.string.content));

        scrollView = findViewById(R.id.day12_mainview_scrollview);
        up_btn = findViewById(R.id.day12_mainview_up);
        down_btn = findViewById(R.id.day12_mainview_down);
        up_btn.setOnClickListener(this);
        down_btn.setOnClickListener(this);

//        隐藏垂直方向滚动条
        scrollView.setVerticalScrollBarEnabled(false);

        //        隐藏水平方向滚动条
        scrollView.setHorizontalScrollBarEnabled(false);

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_MOVE:{
                        /*
                        * (1) getScrollY() ---滚动条滑动的距离
                        * （2）getMeasureHeight()
                        * (3)getHeight()
                        * */

                        if (scrollView.getScrollY() == 0){
                            Log.d("main", "onTouch: 顶部");
                        }

//                        底部状态
//                        Textview的总高度<=屏幕的高度+滚动条的滚动距离
                        if (scrollView.getChildAt(0).getMeasuredHeight() <= scrollView.getHeight() + scrollView.getScrollY()){
                            Log.d("main", "onTouch: 底部");
                            textView.append(getResources().getString(R.string.content));
                        }


                        break;
                    }

                }

                return false;
            }
        });

    }

    @Override
    public void onClick(View view) {

//        scrollTo 以滚动视图起始位置开始计算的

//        scrollBy相对上一次的位置，去滚动
        switch (view.getId()){
            case R.id.day12_mainview_up:{
                scrollView.scrollBy(0,-30);
                break;
            }

            case R.id.day12_mainview_down:{
                scrollView.scrollBy(0,30);

                break;
            }
        }

    }
}
