package com.example.xiaobao.android_one.home12.day7;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/7/5.
 */


public class MyViews extends View {


    private Bitmap mBitmap;
    private Matrix matrix = new Matrix();
    private float sx = 0.0f; //设置倾斜度
    private int width,height;//位图宽高
    private float scale = 1.0f;//缩放比例
    private int method = 0;


    public MyViews(Context context) {
        this(context, null);
    }


    public MyViews(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public MyViews(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        width = mBitmap.getWidth();
        height = mBitmap.getHeight();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (method){
            case 0:
                matrix.reset();
                break;
            case 1:
                sx += 0.1;
                break;
            case 2:
                sx -= 0.1;
                break;
            case 3:
                if(scale < 2.0){
                    scale += 0.1;
                }
                break;
            case 4:
                if(scale > 0.5){
                    scale -= 0.1;
                }
                break;
        }

        matrix.setSkew(sx,0);
        Bitmap bitmap = Bitmap.createBitmap(mBitmap,0,0,width,height,matrix,true);

        matrix.setScale(scale,scale);
        bitmap = Bitmap.createBitmap(bitmap,0,0,width,height,matrix,true);

        //根据原始位图与Matrix创建新图片
        canvas.drawBitmap(bitmap,matrix,null);    //绘制新位图
    }


    public void setMethod(int i){
        method = i;
        postInvalidate();
    }

}

