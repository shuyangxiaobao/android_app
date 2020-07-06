package com.example.xiaobao.android_one.home12.day3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by xiaobao on 2020/7/5.
 */


//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
public class home12_day3_customview extends View {
    private Path mPath = new Path();

    public home12_day3_customview(Context context) {
        super(context);
    }

    public home12_day3_customview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mPath.moveTo(event.getX(), event.getY());
                System.out.println("ACTION_DOWN");
                return true;
            }
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(), event.getY());
                invalidate();
                System.out.println("ACTION_MOVE");

                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        System.out.println("onDraw");
        super.onDraw(canvas);
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(false);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawPath(mPath, paint);
    }

    public void reset() {
        mPath.reset();
        invalidate();
    }
}

