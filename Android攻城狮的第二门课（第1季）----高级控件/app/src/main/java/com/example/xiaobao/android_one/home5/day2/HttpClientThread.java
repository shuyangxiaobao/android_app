package com.example.xiaobao.android_one.home5.day2;
//import org.apache.http.client.

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by xiaobao on 2020/6/20.
 */

public class HttpClientThread extends Thread {
    private String url;
    private String name;
    private String age;

    public HttpClientThread(String url) {
        this.url = url;
    }

    public HttpClientThread(String url, String name, String age) {
        this.url = url;
        this.name = name;
        this.age = age;
    }

    private void doHttpClientGet() {
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = null;
        DefaultHttpClient client = new DefaultHttpClient();
        try {
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String content = EntityUtils.toString(response.getEntity());
                System.out.println("content------->" + content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doHttpClientPost() {
        DefaultHttpClient client = new DefaultHttpClient();

        HttpPost post = new HttpPost(url);
        ArrayList<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("name",name));
        list.add(new BasicNameValuePair("age",age));
        try {
            post.setEntity(new UrlEncodedFormEntity(list,"utf-8"));
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String content = EntityUtils.toString(response.getEntity());
                System.out.println("content-------->"+content);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
//        doHttpClientGet();
        doHttpClientPost();
    }
}






















