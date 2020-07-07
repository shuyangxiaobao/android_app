package com.example.xiaobao.xiaobaokotlin.home8.day4;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home8.day3.Person;


public class home8_day4_activity_second extends Activity {

    public String TAG = "home8_day4_activity_second";

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home8_day4_secondview);
        Log.i(TAG, "onCreate: ");
        textView = findViewById(R.id.textview);
        imageView = findViewById(R.id.image);
        System.out.println("11111111111:"+getTaskId());


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

