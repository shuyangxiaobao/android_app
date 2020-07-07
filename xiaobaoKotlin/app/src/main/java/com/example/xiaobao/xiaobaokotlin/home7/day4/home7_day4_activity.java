package com.example.xiaobao.xiaobaokotlin.home7.day4;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home7.day3.home7_day3_activity;

import java.util.ArrayList;
import java.util.List;


public class home7_day4_activity extends Activity implements View.OnClickListener{
    private int[] res = {R.id.home7_day4_image1,R.id.home7_day4_image2,
            R.id.home7_day4_image3,R.id.home7_day4_image4,R.id.home7_day4_image5};
    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home7_day4_mainview);
        for (int i = 0; i < res.length; i++) {
            ImageView imageview = (ImageView)findViewById(res[i]);
            imageview.setOnClickListener(this);
            imageViewList.add(imageview);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home7_day4_image1:{
                if (flag){
                    startAnim();
                } else {
                    closeAnim();
                }
                break;
            }
            default:
                Toast.makeText(this, ""+v.getId(), Toast.LENGTH_SHORT).show();
                break;
        }

    }

    private void closeAnim() {
        for (int i = 0; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", i * 110f, 0f);
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i*300);
            animator.start();
        }
        flag = true;
    }

    private void startAnim() {
        for (int i = 0; i < res.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", 0f, i * 110);
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i*300);
            animator.start();
        }
        flag = false;
    }
}

