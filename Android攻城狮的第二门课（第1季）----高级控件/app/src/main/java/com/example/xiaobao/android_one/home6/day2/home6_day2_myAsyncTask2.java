package com.example.xiaobao.android_one.home6.day2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by xiaobao on 2020/6/28.
 */

public class home6_day2_myAsyncTask2 extends AsyncTask<String,Void,Bitmap> {
    static String TAG = "home6_day2_myAsyncTask";

    private ImageView mImageView;
    private ProgressBar mProgressBar;


    public home6_day2_myAsyncTask2(ImageView mImageView, ProgressBar mProgressBar) {
        this.mImageView = mImageView;
        this.mProgressBar = mProgressBar;
    }

    //    执行后台耗时操作前被调用，通常用户完成一些初始化工作
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

//必须重写，异步执行后台线程将要完成的任务
    @Override
    protected Bitmap doInBackground(String... params) {
        String url = params[0];
        Bitmap bitmap = null;
        URLConnection connection;
        InputStream is;
        try {
            connection = new URL(url).openConnection();
            is = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            Thread.sleep(3000);
            bitmap = BitmapFactory.decodeStream(bis);
            is.close();
            bis.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

//    在doInBackgroun 方法中调用publishProgress方法更新任务的执行进度后，就会触发该方法
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


//    当 doInBackgroun 完成后， 系统会自动调用
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mProgressBar.setVisibility(View.GONE);
        mImageView.setImageBitmap(bitmap);
    }

}
