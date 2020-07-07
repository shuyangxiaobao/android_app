package com.example.xiaobao.xiaobaokotlin.home3;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.xiaobao.xiaobaokotlin.R;

import java.lang.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day0_activity extends Activity {
    @java.lang.Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day0_mainview);
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

        Set<String> keySet = per.getAll().keySet();
        System.out.println("--------开始-----------");
        for (String key:keySet){
            System.out.println(per.getString(key,""));
        }
        System.out.println("---------结束----------");

        System.out.println(per.getAll());

    }

}
