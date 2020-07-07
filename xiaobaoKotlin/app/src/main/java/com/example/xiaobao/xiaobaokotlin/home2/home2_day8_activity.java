package com.example.xiaobao.xiaobaokotlin.home2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home2_day8_activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_day8_mainview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //        方式1：通过代码动态添加
//        SubMenu file = menu.addSubMenu("文件");
//        file.add(1,1,1,"新建");
//        file.add(1,2,1,"打开");
//        file.add(1,3,1,"保存");
//        file.setHeaderTitle("文件操作");
//        file.setHeaderIcon(R.drawable.czc);
//
//        SubMenu edit = menu.addSubMenu("编辑");
//        edit.add(2,1,1,"复制");
//        edit.add(2,2,1,"粘贴");
//        edit.add(2,3,1,"剪切");
//        edit.setHeaderTitle("编辑操作");
//        edit.setHeaderIcon(R.drawable.czc);

        //        方式2：通过布局添加
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home2_day8_main,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast toast = Toast.makeText(this, "" + item.getTitle() , Toast.LENGTH_SHORT);
        System.out.println("getGroupId"+
                item.getGroupId() + "getItemId"+item.getItemId());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return super.onOptionsItemSelected(item);
    }
}
