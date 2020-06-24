package com.example.xiaobao.android_one.home5.day3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xiaobao on 2020/6/21.
 */

public class HttpImage extends Thread {

    private ImageView imageView;
    private String url;
    private Handler handler;

    public HttpImage(ImageView imageView, String url, Handler handler) {
        this.imageView = imageView;
        this.url = url;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            handler.post(new Runnable() {
                @Override
                public void run() {
                   imageView.setImageBitmap(bitmap);
                }
            });


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
