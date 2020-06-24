package com.example.xiaobao.android_one.home1.day08_fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day08_MyFragment5 extends Fragment {
    private String code = "thank you,Avtivity!";
    MyListener listener;

    public interface MyListener{
       public void thank(String code);
    }

    @Override
    public void onAttach(Activity activity) {
        listener = (MyListener) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.day08_fragment3, container, false);
        TextView tv = (TextView) view.findViewById(R.id.day08_fragment_text);
        String text = getArguments().get("name") + "";
        tv.setText(text);
        Toast.makeText(getActivity(), "接收到数据", Toast.LENGTH_LONG).show();
        listener.thank(code);
        return view;
    }
}
