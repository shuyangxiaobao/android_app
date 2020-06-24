package com.example.xiaobao.android_one.home1.day7;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xiaobao on 2020/6/23.
 */

public class Home1Day7_httpThread extends Thread {
    private String url;

    public Home1Day7_httpThread(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        URL httpUrl = null;
        FileOutputStream out = null;
        try {
            System.out.println("开始下载");

            httpUrl = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            InputStream in = connection.getInputStream();
            File downloadFile;
            File sdFile;
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                downloadFile = Environment.getExternalStorageDirectory();
                sdFile = new File(downloadFile,"test.apk");
                out = new FileOutputStream(sdFile);

            }

            byte[] b = new byte[6*1024];
            int len = 0;
            while ((len = in.read(b))!= -1){
                if (out != null){
                    out.write(b,0,len);
                }
            }
            if (out != null){
                out.close();
            }
            if (in != null){
                in.close();
            }
            System.out.println("下载成功");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
