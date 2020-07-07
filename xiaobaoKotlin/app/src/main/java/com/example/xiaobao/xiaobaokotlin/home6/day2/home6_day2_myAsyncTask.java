package com.example.xiaobao.xiaobaokotlin.home6.day2;

import android.os.AsyncTask;
import android.util.Log;


/**
 * Created by xiaobao on 2020/6/28.
 */

public class home6_day2_myAsyncTask extends AsyncTask<Void,Void,Void> {
    
    static String TAG = "home6_day2_myAsyncTask";


//    执行后台耗时操作前被调用，通常用户完成一些初始化工作
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i(TAG, "onPreExecute: ");
    }

//必须重写，异步执行后台线程将要完成的任务
    @Override
    protected Void doInBackground(Void... voids) {
        Log.i(TAG, "doInBackground: ");
        publishProgress();
        return null;
    }


//    在doInBackgroun 方法中调用publishProgress方法更新任务的执行进度后，就会触发发该方法
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Log.i(TAG, "onProgressUpdate: ");
    }


//    当 doInBackgroun 完成后， 系统会自动调用
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.i(TAG, "onPostExecute: ");
    }

}
