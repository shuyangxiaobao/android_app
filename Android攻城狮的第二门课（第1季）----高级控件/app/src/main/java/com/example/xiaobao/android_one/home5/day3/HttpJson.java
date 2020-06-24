package com.example.xiaobao.android_one.home5.day3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ListView;

import com.example.xiaobao.android_one.home5.day3.json_model.Person;
import com.example.xiaobao.android_one.home5.day3.json_model.SchoolInfo;

import org.apache.http.HttpConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/6/21.
 */

public class HttpJson extends Thread {
    private String url;
    private Context context;
    private ListView listView;
    private JsonAdapter adapter;
    private Handler handler;

    public HttpJson(String url, Context context, ListView listView, JsonAdapter adapter, Handler handler) {
        this.url = url;
        this.context = context;
        this.listView = listView;
        this.adapter = adapter;
        this.handler = handler;
    }

    @Override
    public void run() {
        URL httpUrl;
        try {
            httpUrl = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String str;
            while ((str = reader.readLine()) != null) {
                buffer.append(str);
            }
            final List<Person> data = parseJson(buffer.toString());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    adapter.setData(data);
                    listView.setAdapter(adapter);
                }
            });

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Person> parseJson(String json) {
        JSONObject object = null;
        List<Person> list = new ArrayList<>();

        try {
            object = new JSONObject(json);
            int result = object.getInt("result");
            if (result == 1) {
                JSONArray personData = object.getJSONArray("personData");
                for (int i = 0; i < personData.length(); i++) {
                    Person person = new Person();
                    list.add(person);
                    JSONObject person_object = personData.getJSONObject(i);
                    String name = person_object.getString("name");
                    String url = person_object.getString("url");
                    int age = person_object.getInt("age");
                    person.setName(name);
                    person.setAge(age);
                    person.setUrl(url);
                    JSONArray schoolInfo_list_object = person_object.getJSONArray("schoolInfo");
                    List<SchoolInfo> schoolInfo_list = new ArrayList<SchoolInfo>();
                    for (int j = 0; j < schoolInfo_list_object.length(); j++) {

                        JSONObject jsonObject = schoolInfo_list_object.getJSONObject(j);
                        String school_name = jsonObject.getString("school_name");
                        SchoolInfo schoolInfo = new SchoolInfo();
                        schoolInfo.setSchool_name(school_name);
                        schoolInfo_list.add(schoolInfo);
                    }
                    person.setSchoolInfo(schoolInfo_list);
                }
                return list;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<Person> o = null;
        return o;
    }
}
