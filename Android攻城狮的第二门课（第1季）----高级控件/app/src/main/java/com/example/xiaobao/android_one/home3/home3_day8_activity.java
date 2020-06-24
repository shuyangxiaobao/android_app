package com.example.xiaobao.android_one.home3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day8_activity extends Activity {
    private ImageView imageview;
    GestureDetector mygestureDetector;

    class myGestureListener extends GestureDetector.SimpleOnGestureListener {
        @java.lang.Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > 50) {
                Toast.makeText(home3_day8_activity.this, "从右往左滑", Toast.LENGTH_SHORT).show();
            } else if (e2.getX() - e1.getX() > 50) {
                Toast.makeText(home3_day8_activity.this, "从左往右滑", Toast.LENGTH_SHORT).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day8_mainview);

        imageview = findViewById(R.id.home3_day8_imageview);
        mygestureDetector = new GestureDetector(new myGestureListener());
        imageview.setOnTouchListener(new View.OnTouchListener() {
            @java.lang.Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mygestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

}
