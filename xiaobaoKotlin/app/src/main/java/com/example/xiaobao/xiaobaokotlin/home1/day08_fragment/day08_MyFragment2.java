package com.example.xiaobao.xiaobaokotlin.home1.day08_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day08_MyFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);

        /*
        *   resource Fragment需要加载的布局文件
        *   root 加载layout的父viewGroup
        *   attachToRoot ： false 不返回父viewGroup
        *
        */
        View view = inflater.inflate(R.layout.day08_fragment2, container, false);
        TextView text = (TextView) view.findViewById(R.id.day08_fragment_text);
        text.setText("动态加载");
        return view;
    }
}
