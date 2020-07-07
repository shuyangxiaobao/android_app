package com.example.xiaobao.xiaobaokotlin.home1.day08_fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day08_activity4 extends Activity implements day08_MyFragment5.MyListener {

    private EditText editText;
    private Button send;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.day08_activity4_view);
        editText = (EditText) findViewById(R.id.day08_activity4_view_editText);

        send = (Button) findViewById(R.id.day08_activity4_view_send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                day08_MyFragment5 fragment5 = new day08_MyFragment5();
                Bundle bundle = new Bundle();
                bundle.putString("name",text);
                fragment5.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                beginTransaction.add(R.id.layout,fragment5,"fragment5");
                beginTransaction.commit();
                Toast.makeText(day08_activity4.this, "向Fragment发送数据", Toast.LENGTH_LONG).show();
            }
        });

        FragmentManager fragmentManager = getFragmentManager();
        day08_MyFragment frag = (day08_MyFragment)fragmentManager.findFragmentById(R.id.frag);
        frag.setAaa("fragment静态传值");


    }

    @Override
    public void thank(String code) {
        Toast.makeText(this, "已成功接收到"+code, Toast.LENGTH_LONG).show();
    }
}
