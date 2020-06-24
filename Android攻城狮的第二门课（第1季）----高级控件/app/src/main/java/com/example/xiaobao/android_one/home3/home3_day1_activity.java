package com.example.xiaobao.android_one.home3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day1_activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day1_mainview);
        SharedPreferences per = getSharedPreferences("per", MODE_PRIVATE);
        SharedPreferences.Editor edit = per.edit();
        edit.putString("name", "xiaolaopo");
        edit.putString("name2", "xiaolaopo2");

        edit.putInt("age", 18);
        edit.putFloat("height", (float) 158);
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        set.add("2");
        edit.putStringSet("set", set);


        edit.remove("name2");
        edit.commit();
        System.out.println(per.getString("name", ""));
        System.out.println(per.getInt("age", -1));



        System.out.println(per.getAll());
    }

}
