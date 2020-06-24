package com.example.xiaobao.android_one.home1.day08_fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.RadioGroup;

import com.example.xiaobao.android_one.R;

/**
 * Created by xiaobao on 2020/6/7.
 */

public class day08_fragment_Activity extends Activity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup group;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day08_view);

        group = (RadioGroup) findViewById(R.id.day08_radiogroup);
        group.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.day08_first: {
                Intent intent = new Intent(this, day08_activity2.class);
                startActivity(intent);
                break;
            }
            case R.id.day08_second: {
                day08_MyFragment2 fragment2 = new day08_MyFragment2();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.day08_view_frame, fragment2);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            }
            case R.id.day08_three: {
                Intent intent = new Intent(this, day08_activity3.class);
                startActivity(intent);
                break;
            }
            case R.id.day08_four: {
                Intent intent = new Intent(this, day08_activity4.class);
                startActivity(intent);
                break;
            }
        }
    }
}
