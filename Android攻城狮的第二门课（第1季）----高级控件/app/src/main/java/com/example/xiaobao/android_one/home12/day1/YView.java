package com.example.xiaobao.android_one.home12.day1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xiaobao on 2020/7/5.
 */


//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
//  https://blog.csdn.net/weixin_41729259/article/details/88344177
public class YView extends View {
    private Context mContext;
    //定义一个paint
    private Paint mPaint;
    private float Kscreenwidth = 1000;

    public YView(Context context) {
        this(context, null);
    }

    public YView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public YView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawNomal(canvas);
        drawTest(canvas);
//        drawDial(canvas);
    }

    /**
     * 常规绘制  以(0,0)作为坐标原点参考点
     *
     * @param canvas
     */
    private void drawNomal(Canvas canvas) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        // 绘制画布背景
        canvas.drawColor(Color.parseColor("#88ff0000"));

        //设置画笔颜色
        mPaint.setColor(Color.BLUE);

        //抗锯齿
        mPaint.setAntiAlias(true);

        //设置画笔为空心     如果将这里改为Style.STROKE  这个图中的实线圆柱体就变成了空心的圆柱体
        mPaint.setStyle(Paint.Style.STROKE);

        //绘制直线
        canvas.drawLine(50, 50, 210, 50, mPaint);

        //绘制矩形(空心)
        canvas.drawRect(50, 60, 150, 160, mPaint);

        //绘制矩形(实心)
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(50, 170, 150, 270, mPaint);


        // 画矩形(空心)
        mPaint.setColor(Color.YELLOW);
        RectF r = new RectF(50, 280, 200, 430);
        canvas.drawRect(r, mPaint);

        // 画空心圆
        mPaint.setStyle(Paint.Style.STROKE); //style 修改为画线模式
        mPaint.setStrokeWidth(5);
        canvas.drawCircle(100, 490, 50, mPaint);

        // 画实心圆
        mPaint.setStyle(Paint.Style.FILL); // style 修改为填充模式
        // mPaint.setColor(Color.parseColor("#ffffffff"));
        canvas.drawCircle(100, 600, 50, mPaint);

        // 画椭圆
        RectF oval = new RectF(50, 660, 100, 760);
        canvas.drawOval(oval, mPaint);

        // 画圆角矩形
        RectF rect = new RectF(50, 770, 100, 870);
        canvas.drawRoundRect(rect, 15, 15, mPaint);

        //绘制弧形
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        //椭圆弧形(实心)
        RectF re1 = new RectF(0, 880, 100, 1030);
        canvas.drawArc(re1, -90, 270, false, mPaint);

        RectF re2 = new RectF(0, 1040, 100, 1190);
        canvas.drawArc(re2, -90, 270, true, mPaint);

        RectF re3 = new RectF(0, 1200, 100, 1350);
        canvas.drawArc(re3, 0, 270, false, mPaint);

        RectF re4 = new RectF(0, 1360, 100, 1510);
        canvas.drawArc(re4, 0, 270, true, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        //椭圆弧形
        RectF re5 = new RectF(110, 880, 210, 1030);
        canvas.drawArc(re5, -90, 270, false, mPaint);

        RectF re6 = new RectF(110, 1040, 210, 1190);
        canvas.drawArc(re6, -90, 270, true, mPaint);

        RectF re7 = new RectF(110, 1200, 210, 1350);
        canvas.drawArc(re7, 0, 270, false, mPaint);

        RectF re8 = new RectF(110, 1360, 210, 1510);
        canvas.drawArc(re8, 0, 270, true, mPaint);


        //设置Path路径
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(3);
        Path path = new Path();
        path.moveTo(320, 100);
        path.lineTo(520, 100);
        canvas.drawPath(path, mPaint);
        mPaint.setStrokeWidth(1);
        mPaint.setTextSize(25);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#ff000000"));
        canvas.drawTextOnPath("以下是用Path绘制", path, 10, -10, mPaint);
        mPaint.setStrokeWidth(2);

        // 绘制圆路径
        mPaint.setStyle(Paint.Style.STROKE);
        path.addCircle(420, 210, 100, Path.Direction.CW);
        canvas.drawPath(path, mPaint);

        //三角形
        path.moveTo(420, 320);
        path.lineTo(370, 420);
        path.lineTo(470, 420);
        path.close();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, mPaint);

        //三角形
        path.moveTo(420, 430);
        path.lineTo(370, 530);
        path.lineTo(470, 530);
        path.close();
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, mPaint);

        //把开始的点和最后的点连接在一起，构成一个封闭梯形
        path.moveTo(400, 540);//绘画基点
        path.lineTo(440, 540);
        path.lineTo(470, 640);
        path.lineTo(370, 640);
        //如果是Style.FILL的话，不设置close,也没有区别，可是如果是STROKE模式， 如果不设置close,图形不封闭。当然，你也可以不设置close，再添加一条线，效果一样。
        path.close();
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, mPaint);

        //        canvas.save();

        path.moveTo(Kscreenwidth / 2, 0);
        path.lineTo(Kscreenwidth / 2, 2000);
        canvas.drawPath(path, mPaint);
        mPaint.setStrokeWidth(1);


        // 颜色渐变
        // 参数一为渐变起初点坐标x位置，参数二为y轴位置，参数三和四分辨对应渐变终点,
        // 其中参数new int[]{startColor, midleColor,endColor}是参与渐变效果的颜色集合，
        // 其中参数new float[]{0 , 0.5f, 1.0f}是定义每个颜色处于的渐变相对位置，
        // 这个参数可以为null，如果为null表示所有的颜色按顺序均匀的分布
        // Shader.TileMode三种模式
        // REPEAT:沿着渐变方向循环重复
        // CLAMP:如果在预先定义的范围外画的话，就重复边界的颜色
        // MIRROR:与REPEAT一样都是循环重复，但这个会对称重复
        Shader mShader = new LinearGradient(385, 650, 430, 810,
                new int[]{Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW},
                null, Shader.TileMode.CLAMP);
        mPaint.setShader(mShader);// 用Shader中定义定义的颜色来话
        mPaint.setStyle(Paint.Style.FILL);
        Path path1 = new Path();
        path1.moveTo(370, 810);
        path1.lineTo(430, 810); //右下
        path1.lineTo(415, 650);
        path1.lineTo(385, 650);//左上
        path1.close();
        canvas.drawPath(path1, mPaint);

        // 椭圆
        mPaint.setStyle(Paint.Style.STROKE);
        path.addOval(370, 820, 420, 920, Path.Direction.CW);
        canvas.drawPath(path, mPaint);

        // 圆
        path.addCircle(400, 1000, 40, Path.Direction.CW);
        canvas.drawPath(path, mPaint);

        // addPath 路径
        Path path2 = new Path();
        path.addCircle(400, 1090, 40, Path.Direction.CW);
        path.addPath(path2);
        canvas.drawPath(path, mPaint);

        // 椭圆弧
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addArc(400, 1150, 480,1300,0,220);
        }
        path.close();
        canvas.drawPath(path, mPaint);


        canvas.save();

    }

    /**
     * 绘制方法练习
     *
     * @param canvas
     */
    private void drawTest(Canvas canvas) {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        //平移测试
        canvas.translate(550, 50);
        canvas.drawRect(new Rect(0, 0, 100, 100), mPaint);

        canvas.translate(0, 110);
        canvas.drawRect(new Rect(0, 0, 120, 120), mPaint);

        //缩放测试
        canvas.save(); // 保存画布状态
        canvas.translate(0, 140);
        canvas.scale(0.5f, 0.5f);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(new Rect(0, 0, 280, 280), mPaint);
        // 画布状态回滚
        canvas.restore();

        //旋转测试
        canvas.save();
        canvas.translate(0, 150);
        canvas.drawRect(new Rect(0, 0, 200, 200), mPaint);
        mPaint.setColor(Color.RED);
        canvas.rotate(45, 200, 200);
        canvas.drawRect(new Rect(0, 0, 200, 200), mPaint);
        canvas.restore();

        //画布错切 三角函数tan的值
        canvas.translate(0, 400);
        canvas.drawRect(new Rect(0, 0, 400, 400), mPaint);
        // y 方向上倾斜45 度
        canvas.translate(0, 400);
        canvas.skew(0, 1);
        mPaint.setColor(0xffffffff);
        canvas.drawRect(new Rect(0, 0, 400, 400), mPaint);
    }
}

