package com.example.xiaobao.android_one.home7.day5;


import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

import java.util.ArrayList;
import java.util.List;


public class home7_day5_activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home7_day5_mainview);

    }

    public void click(final View view) {
        if (true) {
            final Button button = (Button) view;
            final ValueAnimator animator = ValueAnimator.ofInt(0, 100);
            animator.setDuration(30000);
            animator.setInterpolator(new BounceInterpolator());
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Integer value = (Integer) animator.getAnimatedValue();
                    button.setText("" + value);
                }
            });
            animator.start();
        } else {
            PointF point1 = new PointF(0, 0);
            PointF point2 = new PointF(100, 100);

            ValueAnimator animator = ValueAnimator.ofObject(new TypeEvaluator<PointF>() {
                @Override
                public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                    System.out.println(startValue.toString() + endValue.toString());
                    ObjectAnimator.ofFloat(view, "translationY", 0, fraction * 100)
                            .setDuration(0).start();
                    return null;
                }
            }, point1, point2);
            animator.setDuration(3000);
            animator.start();

        }
    }
}

