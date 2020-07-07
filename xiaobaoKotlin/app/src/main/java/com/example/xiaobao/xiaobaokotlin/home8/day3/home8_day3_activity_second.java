package com.example.xiaobao.xiaobaokotlin.home8.day3;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;


public class home8_day3_activity_second extends Activity {

    public String TAG = "home8_day1_activity_second";

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day3_secondview);
        Log.i(TAG, "onCreate: ");
        textView = findViewById(R.id.textview);
        imageView = findViewById(R.id.image);

        Intent intent = getIntent();
        if (intent != null){
            String root = intent.getStringExtra("root");
            if (root.equals("button1")){
                String name = intent.getStringExtra("name");
                int age = intent.getIntExtra("age",0);
                textView.setText("name="+name+"  age="+age);
            } else if (root.equals("button2")){
                String name = intent.getStringExtra("name");
                int age = intent.getIntExtra("age",0);
                textView.setText("name="+name+"  age="+age);
            }else if (root.equals("button3")){
                Person person = (Person) intent.getSerializableExtra("person");
                textView.setText(person.toString());
            }else if (root.equals("button4")){
                Bitmap bitmap = (Bitmap) intent.getParcelableExtra("bitmap");
                imageView.setImageBitmap(bitmap);
            }
        }
    }

}

