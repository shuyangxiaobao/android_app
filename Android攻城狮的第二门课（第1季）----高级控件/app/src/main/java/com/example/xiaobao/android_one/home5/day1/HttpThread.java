package com.example.xiaobao.android_one.home5.day1;

import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import android.os.Handler;


/**
 * Created by xiaobao on 2020/6/19.
 */

public class HttpThread extends Thread {

    private String url;
    private WebView webView;
    private Handler handler;

    public HttpThread(String url, WebView webView, Handler handler) {
        this.url = url;
        this.webView = webView;
        this.handler = handler;
    }

//    public HttpThread(String url, WebView webview, Handler handler) {
//    }

    @Override
    public void run() {
        try {
            URL httpUrl = new URL(this.url);
            try {
                HttpURLConnection conn = (HttpURLConnection)httpUrl.openConnection();
                conn.setReadTimeout(5000);
                conn.setRequestMethod("GET");
                final StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String str;
                while((str = reader.readLine()) != null){
                    buffer.append(str);
                    Log.i("001", "str "+str);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        webView.loadData(buffer.toString(),"text/html; charset=utf-8",null);
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









































