package com.example.xiaobao.android_one.home1.day08_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day08_MyFragment extends Fragment {

    private String aaa;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

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
        View view = inflater.inflate(R.layout.day08_fragment, container, false);
        TextView text = (TextView) view.findViewById(R.id.day08_fragment_text);
        Button button = view.findViewById(R.id.day08_fragment_button);

        text.setText("静态加载Fragment");

        button.setText("获取内容");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = getAaa();
                Toast.makeText(getActivity(), "value="+value, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
