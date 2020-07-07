package com.example.xiaobao.xiaobaokotlin.home10.day1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.xiaobao.xiaobaokotlin.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaobao on 2020/7/3.
 */

@EActivity(R.layout.home10_day1_firstview)
public class home10_day1_activity extends Activity {

    @ViewById(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.home10_day1_firstview);
    }


    @Click(R.id.button1)
    public void button1_click(Button button){
        String url = "http://rap2.taobao.org:38080/app/mock/233798/marketdata";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                 请求成功
                Toast.makeText(home10_day1_activity.this, "" + response, Toast.LENGTH_SHORT).show();

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //                 请求失败
                Toast.makeText(home10_day1_activity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        request.setTag("001get");
        MyApplication.getHttpQueues().add(request);
    }

    @Click(R.id.button2)
    public void button2_click(Button button){
        String url = "http://rap2.taobao.org:38080/app/mock/233798/marketdata";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        jsonObjectRequest.setTag("002get");
        MyApplication.getHttpQueues().add(jsonObjectRequest);
    }

    @Click(R.id.button3)
    public void button3_click(Button button){
        String url = "http://rap2.taobao.org:38080/app/mock/233798/testpost";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                 请求成功
                Toast.makeText(home10_day1_activity.this, "" + response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //                 请求失败
                Toast.makeText(home10_day1_activity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("name","xiaoming");
                return map;
//                return super.getParams();
            }
        };
        request.setTag("001post");
        MyApplication.getHttpQueues().add(request);
    }

    @Click(R.id.button4)
    public void button4_click(Button button){
        String url = "http://rap2.taobao.org:38080/app/mock/233798/testpost";
        Map<String,String> map = new HashMap<>();
        map.put("name","xiaoming");
        JSONObject jsonObject = new JSONObject(map);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(home10_day1_activity.this,"4444:" +response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        jsonObjectRequest.setTag("002post");
        MyApplication.getHttpQueues().add(jsonObjectRequest);
    }


    @Click(R.id.button5)
    public void button5_click(Button button){
        String url = "http://rap2.taobao.org:38080/app/mock/233798/marketdata";

        VolleyRequest.RequestGet(this, url, "get003", new VolleyInterface(this) {
            @Override
            public void onMySuccess(String result) {
                Toast.makeText(home10_day1_activity.this, "555:"+result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMyError(VolleyError error) {

            }
        });
    }


    @Click(R.id.button6)
    public void button6_click(Button button){
        String url = "http://rap2.taobao.org:38080/app/mock/233798/testpost";
        Map<String,String> map = new HashMap<>();
        map.put("name","xiaoming");
        VolleyRequest.RequestPost(this,url,"post003",map,new VolleyInterface(this) {
            @Override
            public void onMySuccess(String result) {
                Toast.makeText(home10_day1_activity.this,"666:"+result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMyError(VolleyError error) {

            }
        });
    }

    @Click(R.id.button7)
    public void button7_click(Button button){
        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=" +
                "b9999_10000&sec=1593798915282&di=e61c5d8bc5f1cd0dee649d875f64" +
                "4c38&imgtype=0&src=http%3A%2F%2Fwww.bgzkw.com%2Fupload" +
                "s%2F110318%2F2_141426_1.jpg";
        ImageRequest imageRequest =  new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(home10_day1_activity.this, "error:"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) ;

        MyApplication.getHttpQueues().add(imageRequest);

    }






    //    Volley与Activity生命周期的联动
    @Override
    protected void onStop() {
        super.onStop();
        MyApplication.getHttpQueues().cancelAll("001get");
        MyApplication.getHttpQueues().cancelAll("002get");
        MyApplication.getHttpQueues().cancelAll("001post");
        MyApplication.getHttpQueues().cancelAll("002post");
    }
}
