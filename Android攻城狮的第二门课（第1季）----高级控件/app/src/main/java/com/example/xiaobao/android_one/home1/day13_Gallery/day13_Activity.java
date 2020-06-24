package com.example.xiaobao.android_one.home1.day13_Gallery;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/9.
 */

public class day13_Activity extends Activity implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory {

    private int res[] = {R.drawable.day11_pic1,R.drawable.day11_pic2,R.drawable.day11_pic3,
            R.drawable.day11_pic4,R.drawable.day11_pic5};
    private Gallery gallery;
    private ImagdeAdapter adapter;
    private ImageSwitcher is;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day13_mainview);
        gallery = findViewById(R.id.day13_mainview_galllery);
        is = findViewById(R.id.day13_mainview_is);
        is.setFactory(this);
        is.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        gallery.setOnItemSelectedListener(this);
        adapter = new ImagdeAdapter(res,this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        is.setBackgroundResource(res[i%res.length]);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        image.setScaleType(ImageView.ScaleType.CENTER);
        return  image;
    }
}
