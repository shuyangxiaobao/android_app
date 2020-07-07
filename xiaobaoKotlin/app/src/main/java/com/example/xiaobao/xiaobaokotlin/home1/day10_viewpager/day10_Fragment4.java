package com.example.xiaobao.xiaobaokotlin.home1.day10_viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/8.
 */

public class day10_Fragment4 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day10_view4, container, false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("main", "onDestroy: 我销毁了");
    }
}
