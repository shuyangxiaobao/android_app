package com.example.xiaobao.xiaobaokotlin.home3;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

import java.lang.*;
import java.util.ArrayList;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home3_day9_activity extends Activity {

    GestureOverlayView gestureOverlayView;
    @java.lang.Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home3_day9_mainview);
        gestureOverlayView = findViewById(R.id.home3_day9_gesture1);
//        1.找到刚才的预设定的手势文件
//        2.加载那个手势文件中的所有手势
//        3.匹配 识别
        final GestureLibrary library = GestureLibraries.fromRawResource(home3_day9_activity.this, R.raw.gestures);
        library.load();
        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @java.lang.Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
//                读出手势库中内容 识别手势
                ArrayList<Prediction> myGesture = library.recognize(gesture);
                Prediction prediction = myGesture.get(0);
                Toast.makeText(home3_day9_activity.this, ""+prediction.name+" :"+prediction.score+"分", Toast.LENGTH_SHORT).show();

//                if (prediction.score >= 5){
////                    if (prediction.name.equals("exit")){
////                        finish();
////                    } else if (prediction.name.equals("next")){
////                        Toast.makeText(home3_day9_activity.this, "next", Toast.LENGTH_SHORT).show();
////                    }
//
//                    Toast.makeText(home3_day9_activity.this, ""+prediction.name, Toast.LENGTH_SHORT).show();
//
//                } else {
//                    System.out.println("没有手势");
//                }
            }
        });

    }

}
