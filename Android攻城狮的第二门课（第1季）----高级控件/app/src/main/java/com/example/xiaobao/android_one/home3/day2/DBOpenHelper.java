package com.example.xiaobao.android_one.home3.day2;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xiaobao on 2020/6/13.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

//    首次创建数据库的时候调用 一般把建库建表的操作放到里面
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists user3(_id integer primary key autoincrement," +
                "name text not null,age integer not null,sex text not null)");
        sqLiteDatabase.execSQL("insert into user3(name,sex,age) values('张三','男',16)");
    }

//    当数据库版本发生变化的时候，会自动执行。
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
