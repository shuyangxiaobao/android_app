package com.example.xiaobao.xiaobaokotlin.home5.day1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by xiaobao on 2020/6/19.
 */

public class HttpThread2 extends Thread {

    private String url;
    private ImageView imageView;
    private Handler handler;

    public HttpThread2(String url, ImageView imageView, Handler handler) {
        this.url = url;
        this.imageView = imageView;
        this.handler = handler;
    }


    @Override
    public void run() {
        try {
            URL httpUrl = new URL(this.url);
            try {
                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
                conn.setReadTimeout(5000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                InputStream in = conn.getInputStream();

                FileOutputStream out = null;
                File downloadFile = null;
                String fileName = String.valueOf(System.currentTimeMillis());
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File parent = Environment.getExternalStorageDirectory();
                    downloadFile = new File(parent, fileName);
                    out = new FileOutputStream(downloadFile);
                }
                byte[] b = new byte[2 * 1024];
                int len;
                if (out != null) {
                    while ((len = in.read(b)) != -1) {
                        out.write(b, 0, len);
                    }

                }

                final Bitmap bitmap = BitmapFactory.decodeFile(downloadFile.getAbsolutePath());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("23456787543234567890");
                        imageView.setImageBitmap(bitmap);
                    }
                });


            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}









































