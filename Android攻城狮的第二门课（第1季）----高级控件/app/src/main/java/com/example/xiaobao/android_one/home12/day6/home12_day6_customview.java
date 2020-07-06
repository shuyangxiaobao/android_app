package com.example.xiaobao.android_one.home12.day6;

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
public class home12_day6_customview extends View {
    private Context mContext;
    //定义一个paint
    private Paint mPaint;
    private float Kscreenwidth = 1000;

    public home12_day6_customview(Context context) {
        this(context, null);
    }

    public home12_day6_customview(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public home12_day6_customview(Context context, AttributeSet attrs, int defStyleAttr) {
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

        // quadTo
        Path mPath = new Path();
        mPath.moveTo(200, 200);
        mPath.quadTo(300, 300, 400, 200);
        mPath.quadTo(500, 100, 600, 200);
        canvas.drawPath(mPath, mPaint);

        // rQuadTo
        mPath.moveTo(200, 600);
        for (int i = 0; i < 5; i++) {
            mPath.rQuadTo(100,100,200,0);
            mPath.rQuadTo(100,-100,200,0);
        }
        canvas.drawPath(mPath,mPaint);
    }


}

