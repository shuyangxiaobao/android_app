package com.example.xiaobao.android_one.home1.day08_fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day08_MyFragment3 extends Fragment {
    String TAG = "day08_MyFragment3";


    /*
    * 每次创建都会绘制Fragment的view组件时回掉该方法
    * */
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
        View view = inflater.inflate(R.layout.day08_fragment3, container, false);
        TextView text = (TextView) view.findViewById(R.id.day08_fragment_text);
        text.setText("第一个Fragment");
        Log.i("main", "onCreateView: ");
        return view;
    }

    /*
    * 当Fragment被添加到Activity时候会回调这个方法，并且只调用一次
    *
    * */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "onAttach: ");
    }

    /*
 * 创建Fragment时会回调，并且只调用一次
 *
 * */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }


    /*
    * 创建Fragment启动完成后调用
    * */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");
    }

    /*
    * 启动 Fragment
    * */
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }


    /*
    * 恢复 Fragment 时会被调用，调用 onStart（） 后面一定会调用 onResume（）方法
    *
    * */
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume:---------------------");
    }

    /*
    * 暂停 Fragment
    * */
    @Override
    public void onPause() {
        super.onPause();
    }


    /*
    * 停止 Fragment
    * */
    @Override
    public void onStop() {
        super.onStop();
    }


    /*
    * 销毁Fragment所包含的View组件时
    * */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    /*
    * 销毁Fragment时会被回掉
    * */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /*
    *  当Fragment从Activity中删除时会回调这个方法，并且只调用一次
    * */
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
