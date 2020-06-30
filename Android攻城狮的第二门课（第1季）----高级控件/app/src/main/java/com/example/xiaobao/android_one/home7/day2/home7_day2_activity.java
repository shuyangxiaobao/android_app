package com.example.xiaobao.android_one.home7.day2;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home7.day1.ListActivity;
import com.example.xiaobao.android_one.home7.day1.MainActivity2;


public class home7_day2_activity extends Activity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home7_day2_mainview);
        imageView = (ImageView) findViewById(R.id.home7_day2_imageView);
    }


    public void click(View v) {
        Toast.makeText(home7_day2_activity.this, "click", Toast.LENGTH_SHORT).show();
    }

    public void move(View v) {
        switch (v.getId()) {
            case R.id.home7_day2_button1: {
                TranslateAnimation animation = new TranslateAnimation(0,
                        200, 0, 0);
                animation.setDuration(1000);
                imageView.startAnimation(animation);
                break;
            }

            case R.id.home7_day2_button2: {
                ObjectAnimator.ofFloat(imageView, "translationX", 0, 200)
                        .setDuration(1000).start();

                break;
            }
            case R.id.home7_day2_button3: {
                ObjectAnimator.ofFloat(imageView, "X", 0, 200)
                        .setDuration(1000).start();

                break;
            }
            case R.id.home7_day2_button4: {
                ObjectAnimator.ofFloat(imageView, "rotation", 0, 360)
                        .setDuration(1000).start();
                break;
            }

            case R.id.home7_day2_button5: {
//                组合动画 多个动画并发执行
                ObjectAnimator.ofFloat(imageView, "rotation", 0, 360)
                        .setDuration(1000).start();
                ObjectAnimator.ofFloat(imageView, "translationX", 0, 200)
                        .setDuration(1000).start();
                ObjectAnimator.ofFloat(imageView, "translationY", 0, 200)
                        .setDuration(1000).start();
                break;
            }
            case R.id.home7_day2_button6: {
                //                组合动画 多个动画并发执行

                PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation", 0, 360f);
                PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX", 0, -100);
                PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY", 0, -100);
                ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2, p3).setDuration(1000).start();
                break;
            }
            case R.id.home7_day2_button7: {
                //                组合动画 多个动画并发执行
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationX", 0, 200f);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200f);
                AnimatorSet set = new AnimatorSet();
                set.playTogether(animator1,animator2,animator3);
                set.setDuration(1000);
                set.start();
                break;
            }
            case R.id.home7_day2_button8: {
                //  组合动画
//                执行顺序： 2，3一起执行，然后 1 执行
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0, 360f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationX", 0, 200f);
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "translationY", 0, 200f);
                AnimatorSet set = new AnimatorSet();
                set.play(animator2).with(animator3);
                set.play(animator1).after(animator2);
                set.setDuration(1000);
                set.start();
                break;
            }
            default:
                break;

        }


    }
}

