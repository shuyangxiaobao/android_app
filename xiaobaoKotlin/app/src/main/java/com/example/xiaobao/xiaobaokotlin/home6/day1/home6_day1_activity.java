package com.example.xiaobao.xiaobaokotlin.home6.day1;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.xiaobao.xiaobaokotlin.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiaobao on 2020/6/10.
 */

public class home6_day1_activity extends Activity {
    private ListView listView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private Handler handler2 = new Handler();
    private static String http_URL = "http://www.imooc.com/api/teacher?type=4&num=30";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home6_day1_mainview);
        listView = findViewById(R.id.home6_day1_mainview_listview);
        new NewsAsyncTask().execute(http_URL);
    }


//    根据url获取json数据
    private ArrayList<NewsBean> getJsonData(String url) {
        ArrayList<NewsBean> list = new ArrayList<>();
        try {
            InputStream stream = new URL(url).openStream();
            String jsonString = readStream(stream);
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                NewsBean newsBean = new NewsBean();
                newsBean.newsIconUrl = jsonObject1.getString("picSmall");
                newsBean.newsTitle = jsonObject1.getString("name");
                newsBean.newsContent = jsonObject1.getString("description");
                list.add(newsBean);
            }
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


    /*
    * 解析网页返回的数据（把二进制转化为json字符串）
    *
    * */
    private String readStream(InputStream is) {
        InputStreamReader reader = null;
        String result = "";
        try {
            reader = new InputStreamReader(is, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    //实现网络的异步访问
    class NewsAsyncTask extends AsyncTask<String, Void, List<NewsBean>> {
        @Override
        protected List<NewsBean> doInBackground(String... strings) {
            ArrayList<NewsBean> jsonData = getJsonData(strings[0]);
            System.out.println(Thread.currentThread()+"00000000000000"+"当前是子线程");
            return jsonData;
        }


        @Override
        protected void onPostExecute(final List<NewsBean> newsBeans) {
            super.onPostExecute(newsBeans);
            NewsAdapter adapter = new NewsAdapter(newsBeans, home6_day1_activity.this, handler, listView);
            listView.setAdapter(adapter);
            System.out.println(Thread.currentThread()+"111111111111111111"+"当前是主线程");

        }
    }

}
