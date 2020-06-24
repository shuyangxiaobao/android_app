package com.example.xiaobao.android_one.home1.day13_Gallery;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by xiaobao on 2020/6/9.
 */

public class ImagdeAdapter extends BaseAdapter {
    private int[] res;
    private Context context;

    public ImagdeAdapter(int[] res, Context context) {
        this.res = res;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
//        return res.length;
    }

    @Override
    public Object getItem(int i) {
        return res[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.i("main", "i="+i+"🐶🐶🐶🐶  index = "+ i%res.length);
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(res[i%res.length]);
        imageView.setLayoutParams(new Gallery.LayoutParams(187,333));

        imageView.setScaleType(ImageView.ScaleType.FIT_XY); // 横向 XY 轴拉伸
        return imageView;
    }
}
