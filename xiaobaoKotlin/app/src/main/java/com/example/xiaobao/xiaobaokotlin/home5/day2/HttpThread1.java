package com.example.xiaobao.xiaobaokotlin.home5.day2;

import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Properties;


/**
 * Created by xiaobao on 2020/6/19.
 */

public class HttpThread1 extends Thread {

    private String url;
    private String name;
    private String age;


    public HttpThread1(String url, String name, String age) {
        this.url = url;
        this.name = name;
        this.age = age;
    }

    private void doGet() {
        try {
            url = url + "?name=" + URLEncoder.encode(name,"utf-8") + "&age=" + age;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            URL httpUrl = new URL(this.url);
            try {
                HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
                conn.setReadTimeout(5000);
                conn.setRequestMethod("GET");
                final StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String str;
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }

                System.out.println("result:" + buffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void doPost(){
        try {
            Properties properties = System.getProperties();
            properties.list(System.out);

            URL httpurl = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection)httpurl.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(5000);
            OutputStream outputStream = connection.getOutputStream();
            String content = "name="+name +"&age="+age;
            outputStream.write(content.getBytes());
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String str;
            while ((str=reader.readLine())!= null){
                sb.append(str);
            }
            System.out.println(sb.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

//        doGet();
        doPost();
    }

}









































