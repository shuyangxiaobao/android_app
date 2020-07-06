package com.example.xiaobao.android_one.home12.day4;

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
public class home12_day4_customview extends View {
    private Path mPath = new Path();

    private float mPreX,mPreY;

    public home12_day4_customview(Context context) {
        super(context);
    }

    public home12_day4_customview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                mPath.moveTo(event.getX(),event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                float end_x = (mPreX + event.getX())/2;
                float end_y = (mPreY + event.getY())/2;
                mPath.quadTo(mPreX,mPreY,end_x,end_y);
                mPreX = event.getX();
                mPreY = event.getY();
                invalidate(); // 直接调用invalidate()方法，请求重新draw()，但只会绘制调用者本身。
            }
            break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("onDraw");
        Paint paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(false);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        canvas.drawPath(mPath,paint);
    }

    public void reset() {
        mPath.reset();
        invalidate();
    }

}

