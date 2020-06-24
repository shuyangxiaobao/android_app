package com.example.xiaobao.android_one.home1.day11_viewFlipper;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/8.
 */

public class day11_Activity extends Activity {

    private ViewFlipper flipper;
    private int[] resID = {R.drawable.day11_pic1, R.drawable.day11_pic2, R.drawable.day11_pic3, R.drawable.day11_pic4};
    private float startX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day11_mainview);

        flipper = findViewById(R.id.day11_mainview_flipper);
//        动态导入的方式为 ViewFlipper 加入子view
        for (int i = 0; i < resID.length; i++) {
            flipper.addView(getImageView(resID[i]));
        }

////  为 ViewFlipper 添加动画效果
//        flipper.setInAnimation(this, R.anim.left_in);
//        flipper.setOutAnimation(this, R.anim.left_out);
////     ViewFlipper视图切换的时间间隔
//        flipper.setFlipInterval(300000);
////        开始播放
//        flipper.startFlipping();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
//            手指落下
            case MotionEvent.ACTION_DOWN:{
                startX = event.getX();
                break;
            }
//            手指滑动
            case MotionEvent.ACTION_MOVE:{
                if (event.getX()-startX > 100){
//                    向右滑动
                    flipper.setInAnimation(this,R.anim.left_in);
                    flipper.setOutAnimation(this,R.anim.left_out);
                    flipper.showPrevious();
                    System.out.println("右");

                    break;
                }

                if (event.getX()-startX < -100){
//                    向左滑动
                    flipper.setInAnimation(this,R.anim.right_in);
                    flipper.setOutAnimation(this,R.anim.right_out);
                    flipper.showNext();
                    System.out.println("左");
                    break;
                }
                break;
            }
//            手指离开
            case MotionEvent.ACTION_UP:{
                break;
            }
        }


//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:{
//
//                break;
//            }
//            case MotionEvent.ACTION_MOVE:{
//
//                break;
//
//
//            }
//            case MotionEvent.ACTION_DOWN:{
//
//                break;
//
//
//            }
//        }
        return super.onTouchEvent(event);
    }

    private View getImageView(int res) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(res);
        return imageView;
    }
}
