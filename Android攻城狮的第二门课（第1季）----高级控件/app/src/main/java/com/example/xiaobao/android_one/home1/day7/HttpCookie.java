package com.example.xiaobao.android_one.home1.day7;

import android.os.Handler;
import android.os.Message;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/6/23.
 */

public class HttpCookie extends Thread {

    private Handler handler;

    public HttpCookie(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://192.168.0.102:8082/index.jsp");
        ArrayList<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("name","nates"));
        list.add(new BasicNameValuePair("age","12"));
        try {
            post.setEntity(new UrlEncodedFormEntity(list));
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200){
                AbstractHttpClient absClient = (AbstractHttpClient) client;
                List<Cookie> cookies = absClient.getCookieStore().getCookies();
                for (Cookie cookie:cookies){
                    System.out.println("name="+cookie.getName()+"age="+cookie.getValue());
                    Message message = new Message();
                    System.out.println("cookie----------"+cookie);
                    message.obj = cookie.toString();
                    handler.sendMessage(message);
                    return;
                }
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
