package com.example.xiaobao.android_one.home5.day3;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home5.day3.json_model.Person;
import com.example.xiaobao.android_one.home5.day3.json_model.Result;
import com.example.xiaobao.android_one.home5.day3.json_model.SchoolInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home5_day3_activity extends Activity {
    private Handler handler = new Handler();
    private ListView listView;
    private JsonAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home5_day3_mainview);
        listView = (ListView) findViewById(R.id.home5_day3_listview);
        adapter = new JsonAdapter(this);
        String url = "http://192.168.0.107:8082/day15_response_war_exploded/JsonServlet";
        new HttpJson(url,this,listView,adapter,handler).start();



//        initJsonData();
    }

    private void initJsonData() {
        Result result = new Result();
        result.setResult(1);
        ArrayList<Person> list = new ArrayList<>();
        result.setPersonData(list);

        SchoolInfo schoolInfo1 = new SchoolInfo();
        schoolInfo1.setSchool_name("北大1");

        SchoolInfo schoolInfo2 = new SchoolInfo();
        schoolInfo2.setSchool_name("北大2");

        SchoolInfo schoolInfo3 = new SchoolInfo();
        schoolInfo3.setSchool_name("北大3");

        SchoolInfo schoolInfo4 = new SchoolInfo();
        schoolInfo4.setSchool_name("北大4");


        Person person1 = new Person("xiaoming", 15, "http://baidu.com");
        ArrayList<SchoolInfo> schoolInfos1 = new ArrayList<>();
        schoolInfos1.add(schoolInfo1);
        schoolInfos1.add(schoolInfo2);
        person1.setSchoolInfo(schoolInfos1);

        Person person2 = new Person("xiaoming", 15, "http://baidu.com");
        ArrayList<SchoolInfo> schoolInfos2 = new ArrayList<>();
        schoolInfos2.add(schoolInfo3);
        schoolInfos2.add(schoolInfo4);
        person2.setSchoolInfo(schoolInfos2);

        list.add(person1);
        list.add(person2);

//        Gson gson = new Gson();
//        System.out.println(gson.toJson(result));

        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writeValueAsString(result);
            System.out.println("json"+json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        try {
            JsonNode result1;
            result1 = mapper.readTree(json);
            System.out.println("result1:😄😄😄😄"+result1.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
