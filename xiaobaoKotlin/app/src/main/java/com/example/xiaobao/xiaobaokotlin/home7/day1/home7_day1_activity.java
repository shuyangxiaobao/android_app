package com.example.xiaobao.xiaobaokotlin.home7.day1;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Interpolator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xiaobao.xiaobaokotlin.R;


public class home7_day1_activity extends Activity implements OnClickListener {

    private ImageView image;
    private Button scale;
    private Button rotate;
    private Button translate;
    private Button mix;
    private Button alpha;
    private Button continue_btn;
    private Button continue_btn2;
    private Button flash;
    private Button move;
    private Button change;
    private Button layout;
    private Button frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home7_day1_mainview);
        new Thread() {
            @Override
            public void run() {
                super.run();
                image = (ImageView) findViewById(R.id.image);
                scale = (Button) findViewById(R.id.scale);
                rotate = (Button) findViewById(R.id.rotate);
                translate = (Button) findViewById(R.id.translate);
                alpha = (Button) findViewById(R.id.alpha);
                continue_btn = (Button) findViewById(R.id.continue_btn);
                continue_btn2 = (Button) findViewById(R.id.continue_btn2);
                flash = (Button) findViewById(R.id.flash);
                move = (Button) findViewById(R.id.move);
                change = (Button) findViewById(R.id.change);
                layout = (Button) findViewById(R.id.layout);
                frame = (Button) findViewById(R.id.frame);
                scale.setOnClickListener(home7_day1_activity.this);
                rotate.setOnClickListener(home7_day1_activity.this);
                translate.setOnClickListener(home7_day1_activity.this);
                alpha.setOnClickListener(home7_day1_activity.this);
                continue_btn.setOnClickListener(home7_day1_activity.this);
                continue_btn2.setOnClickListener(home7_day1_activity.this);
                flash.setOnClickListener(home7_day1_activity.this);
                move.setOnClickListener(home7_day1_activity.this);
                change.setOnClickListener(home7_day1_activity.this);
                layout.setOnClickListener(home7_day1_activity.this);
                frame.setOnClickListener(home7_day1_activity.this);
            }
        }.start();


    }

    @Override
    public void onClick(View view) {

        boolean isdaima = true;
/**
 * 缩放动画
 */
        Animation loadAnimation;
        switch (view.getId()) {
//              缩放动画
            case R.id.scale: {
                if (isdaima) {

//                    https://blog.csdn.net/zl18603543572/article/details/49237951     Android Animation --ScaleAnimation
                    ScaleAnimation scaleAnimation = new ScaleAnimation(
                            0.0f, 2.0f, 0.0f, 2.0f,
                            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
                    );
                    scaleAnimation.setDuration(2000);
                    scaleAnimation.setRepeatCount(0);
                    scaleAnimation.setRepeatMode(Animation.ZORDER_TOP);
                    scaleAnimation.setInterpolator(new LinearInterpolator());
                    image.startAnimation(scaleAnimation);
                } else {
                    loadAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                    image.startAnimation(loadAnimation);
                }


                break;
            }

//            透明度动画
            case R.id.alpha: {
                if (isdaima) {
//                    通过代码实现
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                    alphaAnimation.setDuration(1000);
                    alphaAnimation.setRepeatCount(1);
                    //倒序重复REVERSE  正序重复RESTART
                    alphaAnimation.setRepeatMode(Animation.REVERSE);
                    image.startAnimation(alphaAnimation);
                } else {
//                    通过加载xml文件
                    loadAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                    image.startAnimation(loadAnimation);
                }

                break;
            }
//             旋转动画
            case R.id.rotate: {
                if (isdaima) {
                    RotateAnimation animation = new RotateAnimation(0.0f,
                            360.0f,Animation.RELATIVE_TO_SELF,
                            0.5f,Animation.RELATIVE_TO_SELF,
                            0.5f);
                    animation.setDuration(2000);
                    image.startAnimation(animation);
                } else {
                    loadAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                    image.startAnimation(loadAnimation);
                }

                break;
            }

            /**
             * 位移坐标动画
             */
            case R.id.translate: {
                if (isdaima) {
                    TranslateAnimation animation = new TranslateAnimation(-80, 100, -80, 100);
                    animation.setDuration(1000);
                    image.startAnimation(animation);
                } else {
                    loadAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                    image.startAnimation(loadAnimation);
                }
                break;
            }


//            续播1
            case R.id.continue_btn: {
                loadAnimation = AnimationUtils
                        .loadAnimation(this, R.anim.translate);
                image.startAnimation(loadAnimation);
                final Animation loadAnimation2 = AnimationUtils.loadAnimation(this,
                        R.anim.rotate);
                loadAnimation.setAnimationListener(new AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation arg0) {
                        // TODO Auto-generated method stub
                        //开始
                    }

                    @Override
                    public void onAnimationRepeat(Animation arg0) {
                        // TODO Auto-generated method stub
                        //重复
                    }

                    @Override
                    public void onAnimationEnd(Animation arg0) {
                        // TODO Auto-generated method stub
                        //结束
                        image.startAnimation(loadAnimation2);
                    }
                });
                break;
            }
/**
 * 续播2
 */
            case R.id.continue_btn2: {
                if (isdaima){
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                    alphaAnimation.setDuration(1000);
                    //倒序重复REVERSE  正序重复RESTART
                    image.startAnimation(alphaAnimation);


//                    RotateAnimation animation = new RotateAnimation(0.0f,
//                            360.0f,Animation.RELATIVE_TO_SELF,
//                            0.5f,Animation.RELATIVE_TO_SELF,
//                            0.5f);
//                    animation.setDuration(2000);
//                    animation.setStartOffset(1000);
//                    image.startAnimation(animation);

                } else {
                    loadAnimation = AnimationUtils.loadAnimation(this,
                            R.anim.continue_anim);
                    image.startAnimation(loadAnimation);
                }




                break;
            }


/**
 * 闪烁
 */
            case R.id.flash: {

                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(5);
                alphaAnimation.setRepeatCount(5);
                //倒序重复REVERSE  正序重复RESTART
                alphaAnimation.setRepeatMode(Animation.RESTART);
                image.startAnimation(alphaAnimation);

                break;
            }

            //            抖动
            case R.id.move: {
                TranslateAnimation translate = new TranslateAnimation(-50, 50,
                        0, 0);
                translate.setDuration(1000);
                translate.setRepeatCount(Animation.INFINITE);
                translate.setRepeatMode(Animation.REVERSE);
                image.startAnimation(translate);

                break;
            }

//            切换动画
            case R.id.change: {
                Intent intent = new Intent(home7_day1_activity.this, MainActivity2.class);
                startActivity(intent);
                //参数1--进入的动画     参入2--缩小方法的动画
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                break;
            }
//            布局动画
            case R.id.layout: {
                Intent intent = new Intent(home7_day1_activity.this, ListActivity.class);
                startActivity(intent);
                break;
            }
//            逐帧动画
            case R.id.frame: {
//                image.setImageResource(R.drawable.anim_list);
                //获取背景，并将其强转成AnimationDrawable
                final AnimationDrawable animationDrawable = (AnimationDrawable) image.getBackground();
                //判断是否在运行
                if(!animationDrawable.isRunning()){
                    //开启帧动画
                    animationDrawable.start();
                }
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Thread.sleep(3000);
                            animationDrawable.stop();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                break;

            }

        }
    }

}

