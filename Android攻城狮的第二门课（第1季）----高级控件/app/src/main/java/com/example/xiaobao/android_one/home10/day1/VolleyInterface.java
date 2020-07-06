package com.example.xiaobao.android_one.home10.day1;

import android.content.Context;


import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

import java.util.List;

/**
 * Created by xiaobao on 2020/7/3.
 */

public abstract class VolleyInterface {

    public Context context;
    public  Listener<String> listener;
    public  ErrorListener errorListener;



    public VolleyInterface(Context context) {
        this.context = context;
}

    public abstract void onMySuccess(String result);
    public abstract void onMyError(VolleyError error);



    public Listener<String> loadingListener(){
        listener = new Listener<String>() {
            @Override
            public void onResponse(String response) {
                onMySuccess(response);
            }
        };
        return  listener;
    }


    public ErrorListener errorListener(){
        errorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onMyError(error);
            }
        };
        return errorListener;
    }
}











//public abstract class VolleyInterface {
//
//    public Context context;
//    public static Listener<String> listener;
//    public static ErrorListener errorListener;
//
//
//
//    public VolleyInterface(Context context, Listener<String> listener, ErrorListener errorListener) {
//        this.context = context;
//        this.listener = listener;
//        this.errorListener = errorListener;
//    }
//
//    public abstract void onMySuccess(String result);
//    public abstract void onMyError(VolleyError error);
//
//
//
//    public Listener<String> loadingListener(){
//        listener = new Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                onMySuccess(response);
//            }
//        };
//        return  listener;
//    }
//
//
//    public ErrorListener errorListener(){
//        errorListener = new ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                onMyError(error);
//            }
//        };
//        return errorListener;
//    }
//}
