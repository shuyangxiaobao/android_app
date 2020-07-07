package com.example.xiaobao.xiaobaokotlin.home2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home2_day6_activity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_day6_mainview);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //导入菜单布局
//        getMenuInflater().inflate(R.menu.home2_day6_main, menu);

        MenuItem item = menu.add(1, 100, 1, "11111");
        item.setTitle("跳转页面");
        item.setIcon(R.drawable.czc);//api>11不显示图标
        menu.add(1,101,1,"22222");
        menu.add(1,102,1,"33333");
        menu.add(1,103,1,"44444");
        menu.add(1,104,1,"55555");


        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 100:{
                Intent intent = new Intent(this, home2_day5_activity.class);
                item.setIntent(intent);
            }

        }

        Toast.makeText(this, "title="+item.getTitle()+"; getItemId="+item.getItemId(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }







}
