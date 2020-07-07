package com.example.xiaobao.xiaobaokotlin.home5.day4;

import android.os.Handler;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by xiaobao on 2020/6/21.
 */

public class XmlThread extends Thread {
    private String url;
    private Handler handler;
    private TextView textView;

    public XmlThread(String url, Handler handler, TextView textView) {
        this.url = url;
        this.handler = handler;
        this.textView = textView;
    }

    @Override
    public void run() {
        URL httpUrl = null;
        try {
            httpUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(in, "utf-8");
            int eventType = parser.getEventType();
            final ArrayList<Girl> list = new ArrayList<>();
            Girl girl = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String data = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG: {
                        if ("girl".equals(data)) {
                            girl = new Girl();
                        }
                        if ("name".equals(data)) {
                            girl.setName(parser.nextText());
                        }
                        if ("age".equals(data)) {
                            girl.setAge(Integer.parseInt(parser.nextText()));
                        }
                        if ("school".equals(data)) {
                            girl.setSchool(parser.nextText());
                        }
                        break;
                    }
                    case XmlPullParser.END_TAG:
                        if ("girl".equals(data) && girl != null) {
                            list.add(girl);
                        }
                        break;
                }
                eventType = parser.next();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(list.toString());
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}




