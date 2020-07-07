package com.example.xiaobao.xiaobaokotlin.home3.day4;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home3.*;

import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;

import android.view.View;


/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day4_activity extends Activity {
    private String TAG = "day4";

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day4_mainview);

        findViewById(R.id.home3_day4_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chaxun();
            }
        });

        findViewById(R.id.home3_day4_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xinzeng();
            }
        });


    }


    private void chaxun(){
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI, new String[]{ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts.HAS_PHONE_NUMBER}, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getColumnIndex("_id");
                Log.i(TAG, "_id = " + cursor.getInt(cursor.getColumnIndex("_id")) + " " + cursor.getColumnIndex("_id"));
                Log.i(TAG, "display_name = " + cursor.getString(cursor.getColumnIndex("display_name")) + " " + cursor.getColumnIndex("name"));
                Log.i(TAG, "has_phone_number = " + cursor.getString(cursor.getColumnIndex("has_phone_number")) + " " + cursor.getColumnIndex("name"));
                System.out.println("-------------------------------------------");
                Cursor cursor1 = resolver.query(Phone.CONTENT_URI,
                        new String[]{Phone.NUMBER, Phone.TYPE},
                        null, null, null);
                if (cursor1 != null) {
                    while (cursor1.moveToNext()) {
                        int type = cursor1.getInt(cursor1.getColumnIndex(Phone.TYPE));
                        if (type == Phone.TYPE_HOME) {
                            Log.i(TAG, "家庭电话" + cursor1.getString(cursor1.getColumnIndex(Phone.NUMBER)));
                        } else if (type == Phone.TYPE_MOBILE) {
                            Log.i(TAG, "家庭手机" + cursor1.getString(cursor1.getColumnIndex(Phone.NUMBER)));
                        }
                    }
                    cursor1.close();
                }

                Cursor cursor2 = resolver.query(Email.CONTENT_URI,
                        new String[]{Email.DATA, Email.TYPE},
                        null, null, null);
                if (cursor2 != null) {
                    while (cursor2.moveToNext()) {
                        int type = cursor2.getInt(cursor2.getColumnIndex(Email.TYPE));
                        if (type == Email.TYPE_WORK) {
                            System.out.println("type = " + type);
                            Log.i(TAG, "工作邮箱" + cursor2.getString(cursor2.getColumnIndex(Email.DATA)));
                        } else if (type == Email.TYPE_HOME) {
                            Log.i(TAG, "家庭邮箱" + cursor2.getString(cursor2.getColumnIndex(Email.DATA)));
                        }
                    }
                    cursor2.close();
                }
            }
            cursor.close();
        }
    }


    private void xinzeng() {
        ContentResolver resolver = getContentResolver();
//        向联系人中插入一行数据
        ContentValues values = new ContentValues();
        Uri uri = resolver.insert(RawContacts.CONTENT_URI, values);
        long raw_contact_id = ContentUris.parseId(uri);
        values.clear();
//        插入人名
        values.put(StructuredName.RAW_CONTACT_ID,raw_contact_id);
        values.put(StructuredName.DISPLAY_NAME,"xiaoxue");
        values.put(StructuredName.MIMETYPE,StructuredName.CONTENT_ITEM_TYPE);
        uri = resolver.insert(Data.CONTENT_URI,values);
//        插入电话信息
        values.clear();
        values.put(Phone.RAW_CONTACT_ID,raw_contact_id);
        values.put(Phone.NUMBER,"123456789090");
        values.put(Phone.MIMETYPE,Phone.CONTENT_ITEM_TYPE);
        resolver.insert(Data.CONTENT_URI,values);



    }


}





































