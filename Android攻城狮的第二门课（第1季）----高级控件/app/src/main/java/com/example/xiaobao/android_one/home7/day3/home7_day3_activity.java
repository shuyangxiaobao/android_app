package com.example.xiaobao.android_one.home7.day3;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;


public class home7_day3_activity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home7_day3_mainview);
//        imageView = (ImageView) findViewById(R.id.home7_day_imageView);
    }


    public void click(View v) {
        Toast.makeText(home7_day3_activity.this, "click", Toast.LENGTH_SHORT).show();
    }

    public void move(View v) {
        switch (v.getId()){
            case R.id.home7_day3_button1:{
                ObjectAnimator animator = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
                animator.setDuration(1000);
                animator.addListener(new Animator.AnimatorListener(){

                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Toast.makeText(home7_day3_activity.this, "111", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.start();
                break;
            }

            case R.id.home7_day3_button2:{
                ObjectAnimator animator = ObjectAnimator.ofFloat(v, "alpha", 0f, 1f);
                animator.setDuration(1000);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        Toast.makeText(home7_day3_activity.this, "2222", Toast.LENGTH_SHORT).show();
                    }
                });
                animator.start();

            }

            default:{
                break;
            }





            }
    }
}

