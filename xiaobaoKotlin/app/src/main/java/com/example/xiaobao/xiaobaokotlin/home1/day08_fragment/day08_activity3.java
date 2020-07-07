package com.example.xiaobao.xiaobaokotlin.home1.day08_fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day08_activity3 extends Activity {

    private Button button;
    private Fragment frag;
    private boolean flag = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_activity3_view);
        init();
        button = findViewById(R.id.day08_activity3_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                if (flag){
                    day08_MyFragment4 fragment4 = new day08_MyFragment4();
                    beginTransaction.replace(R.id.layout,fragment4);

                } else {
                    day08_MyFragment3 fragment3 = new day08_MyFragment3();
                    beginTransaction.replace(R.id.layout,fragment3);
                }
                flag = !flag;
                beginTransaction.commit();
            }
        });


//
//        Button button = findViewById(R.id.day08_fragment_button);
//        button.setText("改变");
//
//        final TextView tv = findViewById(R.id.day08_fragment_text);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               int origin =  new Integer(tv.getText().toString());
//               tv.setText((origin+1)+"");
////                tv.setText("我是被更改的值");
//            }
//        });
    }

    private void init() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        day08_MyFragment3 fragment3 = new day08_MyFragment3();
        beginTransaction.add(R.id.layout,fragment3);
        beginTransaction.commit();
    }
}
