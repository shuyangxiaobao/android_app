package com.example.xiaobao.android_one.home3.day3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home3.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day3_activity extends Activity {

    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day3_mainview);
        demo1();

        initEvents();
    }

    private void initEvents() {

        findViewById(R.id.home3_day3_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demo1();
                demo2();
            }
        });


        findViewById(R.id.home3_day3_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = findViewById(R.id.home2_day3_edittext);
                writeFiles(editText.getText().toString());
                try {
                    String s = readFiles();
                    Toast.makeText(home3_day3_activity.this, s, Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }


    private void demo1() {
//        需要到手机设置里面打开这个app的 Storage 权限
        File file = new File("/mnt/sdcard/12");
        System.out.println("file=" + file + "🐶🐶🐶🐶");

        if (!file.exists()) {
            try {
                file.createNewFile();
                Toast.makeText(this, "创建文件", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建失败");
            }
        } else {
            Toast.makeText(this, "文件已经存在", Toast.LENGTH_SHORT).show();
        }

//        file.delete();

    }

    private void demo2() {

        File file1 = this.getFilesDir();//这个目录是当前应用程序默认的数据存储目录
        System.out.println("file1=" + file1 + "🐶🐶🐶🐶");


        //这个目录是当前应用程序默认的缓存文件的存储目录，把一些不是很重要的文件在此创建使用，
//        当手机内存不足的时候，系统会自动删除APP的cache 目录的数据。
        File file2 = this.getCacheDir();
        System.out.println("file2=" + file2 + "🐶🐶🐶🐶");

        File file3 = this.getDir("imooc", MODE_PRIVATE);

        System.out.println("file3=" + file3 + "🐶🐶🐶🐶");


//        可以得到外部的存储位置，该位置的数据跟内置的使用是一样的。
//        如果APP卸载了，这里面的数据会自动清除掉
        File file4 = this.getExternalCacheDir();
        System.out.println("file4=" + file4 + "🐶🐶🐶🐶");


    }

    //    写入文件
    public void writeFiles(String content) {
        try {
            FileOutputStream outputStream = openFileOutput("a.txt", MODE_PRIVATE);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//   读取文件
    public String readFiles() throws IOException {
        String content = null;
        try {
            FileInputStream fis = openFileInput("a.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            content = baos.toString();
            fis.close();
            baos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content;
    }


}
