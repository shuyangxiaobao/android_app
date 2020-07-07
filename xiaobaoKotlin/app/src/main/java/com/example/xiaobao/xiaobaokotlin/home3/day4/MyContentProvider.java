package com.example.xiaobao.xiaobaokotlin.home3.day4;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by xiaobao on 2020/6/14.
 */

public class MyContentProvider extends ContentProvider {

//   ContentProvider 创建时被调用
    @Override
    public boolean onCreate() {
        return false;
    }

    //    根据uri查询selection指定的条件匹配的所有记录，并且可以指定查询哪些列，以什么方式排序
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        return null;
    }


//    返回当前uri的MIME类型，如果该URI对应的数据可能包括多条记录，那么MIME类型字符串就是以vnd.android.dir/开头
//    如果该URI对应的数据可能只有一条记录，那么MIME类型字符串就是以  vnd.android.cursor.item/  开头

    @Override
    public String getType(Uri uri) {
        return null;
    }

    //    根据uri插入contentValues对应的数据
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }


//    根据uri删除selection指定的条件匹配的所有记录
    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

//    根据uri修改selection指定的条件匹配的所有记录
    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
