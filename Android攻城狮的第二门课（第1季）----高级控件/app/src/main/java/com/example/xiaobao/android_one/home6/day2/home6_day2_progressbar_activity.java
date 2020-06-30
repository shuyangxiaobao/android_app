package com.example.xiaobao.android_one.home6.day2;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.xiaobao.android_one.R;


/**
 * Created by xiaobao on 2020/6/10.
 */

public class home6_day2_progressbar_activity extends Activity {
    private ProgressBar mProgressBar;
    private MyAsyncTask3 mTask;


    private Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home6_day2_progressbar);
        mProgressBar = findViewById(R.id.home6_day2_progressbar_progressbar);
        mTask = new MyAsyncTask3();
        mTask.execute();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            mTask.cancel(true);
        }

    }

    class MyAsyncTask3 extends AsyncTask<Void, Integer, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            System.out.println("这是子线程");
//            模拟进度更新
            for (int i = 0; i <= 100; i++) {
                if (isCancelled()) {
                    break;
                }
                publishProgress(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (isCancelled()) {
                return;
            }
            System.out.println("这是主线程");
            mProgressBar.setProgress(values[0]);
        }

    }


}
