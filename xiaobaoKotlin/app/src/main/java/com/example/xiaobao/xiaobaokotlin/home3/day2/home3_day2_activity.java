package com.example.xiaobao.xiaobaokotlin.home3.day2;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home3.day2.*;

/**
 * Created by xiaobao on 2020/6/10.
 */
public class home3_day2_activity extends Activity {
    String TAG = "xlp";

    //    @com.example.xiaobao.xiaobaokotlin.home3.day2.home3_day2_activity
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day2_mainview);


//        demo1();
//        demo2();

        demo3();
    }

    private void demo1() {
        SQLiteDatabase database = openOrCreateDatabase("user.db", MODE_PRIVATE, null);
        database.execSQL("create table if not exists usertb(_id integer primary key autoincrement," +
                "name text not null,age integer not null,sex text not null)");
        database.execSQL("insert into usertb(name,sex,age) values('张三','男',16)");
        database.execSQL("insert into usertb(name,sex,age) values('李四','男',17)");
        database.execSQL("insert into usertb(name,sex,age) values('王武','男',18)");
        Cursor cursor = database.rawQuery("select * from usertb", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.i(TAG, "id = " + cursor.getInt(cursor.getColumnIndex("_id")) + " " + cursor.getColumnIndex("_id"));
                Log.i(TAG, "name = " + cursor.getString(cursor.getColumnIndex("name")) + " " + cursor.getColumnIndex("name"));
                Log.i(TAG, "age = " + cursor.getInt(cursor.getColumnIndex("age")) + " " + cursor.getColumnIndex("age"));
                Log.i(TAG, "sex = " + cursor.getString(cursor.getColumnIndex("sex")) + " " + cursor.getColumnIndex("sex"));
                System.out.println("-----------------");
            }
            cursor.close();
        }
        database.close();

        Log.i("xlp", "onCreate:" + database.getPath());
    }

    private void demo2() {
        SQLiteDatabase database = openOrCreateDatabase("stu.db", MODE_PRIVATE, null);
        database.execSQL("create table if not exists studb(_id integer primary key autoincrement," +
                "name text not null,age integer not null,sex text not null)");
        ContentValues values = new ContentValues();
        values.put("name", "张三丰");
        values.put("sex", "男");
        values.put("age", 19);
        long rowid = database.insert("studb", null, values);


        values.clear();
        values.put("name", "张三峰");
        values.put("sex", "男");
        values.put("age", 20);
        database.insert("studb", null, values);

        values.clear();
        values.put("name", "张三封");
        values.put("sex", "男");
        values.put("age", 21);
        database.insert("studb", null, values);

        values.clear();
        values.put("sex", "女");
        database.update("studb", values, "_id>?", new String[]{"0"});// 将全部id>0的人d的性别改成女
        database.delete("studb", "name like ?", new String[]{"%丰%"});//删除所有名字中带有丰的人

        Cursor cursor = database.query("studb", null, "_id>?", new String[]{"0"},
                null, null, "name");
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.i(TAG, "id = " + cursor.getInt(cursor.getColumnIndex("_id")) + " " + cursor.getColumnIndex("_id"));
                Log.i(TAG, "name = " + cursor.getString(cursor.getColumnIndex("name")) + " " + cursor.getColumnIndex("name"));
                Log.i(TAG, "age = " + cursor.getInt(cursor.getColumnIndex("age")) + " " + cursor.getColumnIndex("age"));
                Log.i(TAG, "sex = " + cursor.getString(cursor.getColumnIndex("sex")) + " " + cursor.getColumnIndex("sex"));
                System.out.println("-----------------");
            }
            cursor.close();
        }
        database.close();
        Log.i("xlp", "onCreate:" + database.getPath());
    }


    private void demo3() {
        DBOpenHelper helper = new DBOpenHelper(home3_day2_activity.this, "stu2.db");
//        helper.getReadableDatabase();// 获取一个只读的数据库，只能查询，不能写入，不能更新
        SQLiteDatabase database = helper.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from user3", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.i(TAG, "id = " + cursor.getInt(cursor.getColumnIndex("_id")) + " " + cursor.getColumnIndex("_id"));
                Log.i(TAG, "name = " + cursor.getString(cursor.getColumnIndex("name")) + " " + cursor.getColumnIndex("name"));
                Log.i(TAG, "age = " + cursor.getInt(cursor.getColumnIndex("age")) + " " + cursor.getColumnIndex("age"));
                Log.i(TAG, "sex = " + cursor.getString(cursor.getColumnIndex("sex")) + " " + cursor.getColumnIndex("sex"));
                System.out.println("-----------------");
            }
            cursor.close();
        }
        database.close();

    }


}
