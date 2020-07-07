package com.example.xiaobao.xiaobaokotlin.home8.day1;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;


public class home8_day1_activity_first extends Activity implements OnClickListener {
    public String TAG = "home8_day1_activity_first";
    private Button button;
    private TextView textView;
    private MediaPlayer mediaPlayer;
    private int positon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day1_firstview);
        button = findViewById(R.id.button);
        button.setOnClickListener(home8_day1_activity_first.this);

        textView = findViewById(R.id.textView);
        textView.setText("234234");

        if (savedInstanceState != null){
            textView.setText(savedInstanceState.getString("name"));
        }
        mediaPlayer = MediaPlayer.create(this,R.raw.sing);
        mediaPlayer.start();



        Log.i(TAG, "onCreate: ");

    }


//    销毁时保存一些状态信息
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name","xiaoming");
        Log.i(TAG, "onSaveInstanceState: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
        if (positon != 0){
            mediaPlayer.seekTo(positon);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            positon = mediaPlayer.getCurrentPosition();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");

//        必须要释放，否则播放器不释放，导致内存泄漏
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(home8_day1_activity_first.this, home8_day1_activity_second.class);
        home8_day1_activity_first.this.startActivity(intent);
    }
}

