package com.example.xiaobao.android_one.home12.day8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xiaobao on 2020/7/5.
 */


//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
public class home12_day8_customview extends View {
    private Context mContext;
    //定义一个paint
    private Paint mPaint;
    private float Kscreenwidth = 1000;

    public home12_day8_customview(Context context) {
        this(context, null);
    }

    public home12_day8_customview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public home12_day8_customview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        demo1(canvas);
    }

    /**
     * 常规绘制  以(0,0)作为坐标原点参考点
     *
     * @param canvas
     */
    private void demo1(Canvas canvas) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 绘制画布背景
        canvas.drawColor(Color.parseColor("#88ff0000"));
        //设置画笔颜色
        mPaint.setColor(Color.BLUE);
        //抗锯齿
        mPaint.setAntiAlias(true);
        //设置画笔为空心     如果将这里改为Style.STROKE  这个图中的实线圆柱体就变成了空心的圆柱体
        mPaint.setStyle(Paint.Style.STROKE);

        // 二次贝塞尔曲线
           //1. 首尾未连接 (0,50)是起点  (300,200)是锚点  (600,50)是终点
        Path mPath = new Path();
        mPath.moveTo(0, 50);
        mPath.quadTo(300, 200, 600, 50);
        canvas.drawPath(mPath, mPaint);
            //2. 首尾连接
        mPath.moveTo(0, 300);
        mPath.quadTo(300, 500, 600, 300);
        mPath.close();
        canvas.drawPath(mPath, mPaint);


        // 三次贝塞尔曲线
        // (0,800)是起点  (300,400) (300,1200)是锚点  (600,800)是终点
        // https://cubic-bezier.com/#1,0,.01,1
        mPath.moveTo(0, 800);
        mPath.cubicTo(300, 400, 300, 1200, 600, 800);
        canvas.drawPath(mPath,mPaint);

        // 三次贝塞尔曲线
        mPath.moveTo(0, 1200);
        mPath.cubicTo(300, 800, 300, 1600, 600, 1200);
        mPath.close();
        canvas.drawPath(mPath,mPaint);


    }


}

