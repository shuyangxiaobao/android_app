package com.example.xiaobao.myapplication;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,View.OnClickListener{
final String TAG = "tag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.day06();
//        this.day07();
//        this.day08();
//        this.day09();
//        day10();
//        day11();
//        day12();
//        day13();
//        day14();
//        day15();
//        day16();
//        day17();

        day21();
//        将布局xml文件引入到activity当中
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.layout);
//        setContentView(R.layout.day05_button);

    }

    public void day06(){
        setContentView(R.layout.day06_buttonclick);
        Button button1 = (Button)findViewById(R.id.buttonclick1);

        /*
        * 方式1 匿名类
        * */
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("匿名类方式........");
            }
        });

        /*
        * 方式2 外部类
        * */
        button1.setOnClickListener(new MyOnClickListener(){
            @Override
            public void onClick(View view) {
                super.onClick(view);
                System.out.println("外部类外部类外部类外部类外部类");
            }
        });

        /*
        * 方式3 通过实现一个接口的方式实现监听事件
        * */
        button1.setOnClickListener(this);
    }




    public void day07(){
        setContentView(R.layout.day07_textview);
    }

    @Override
    public void onClick(View view) {
        System.out.println("第三种方式");
    }

    public void day08() {
        setContentView(R.layout.day08_autocompletetextview);

        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        String[] res = {"beijing1", "beijing2", "beijing3", "beijing4", "shenzhen1", "shenzhen2", "shenzhen3", "shenzhen4"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, res);
        acTextView.setAdapter(adapter);

        MultiAutoCompleteTextView mutilTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
        mutilTextView.setAdapter(adapter);
        mutilTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }


    public void day09() {
        setContentView(R.layout.day09_togglebutton);
        ToggleButton toggButt = (ToggleButton)findViewById(R.id.toggleButton);
        ImageView img = (ImageView)findViewById(R.id.imageView);
        toggButt.setOnCheckedChangeListener(this);
    }


    public void day10() {
        setContentView(R.layout.day10_checkbox);
        final CheckBox checkbox = (CheckBox)findViewById(R.id.checkbox1);
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public static final String TAG = "234";

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String s = checkbox.getText().toString();
                if (b){
                    System.out.println(s);
                }
//                Log.i("tag", s);
//                Log.i(TAG, "onCheckedChanged: erw");
            }
        });

    }

    public void day11(){
        setContentView(R.layout.day11_radiobutton);
        RadioGroup group = (RadioGroup)findViewById(R.id.RadioGroup1);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radiobutton1:{
                        System.out.println("111111");
                        Log.i("tag", "onCheckedChanged: 11111111");
                        break;
                    }
                    case R.id.radiobutton2:{
                        System.out.println("22222");
                        break;

                    }
                    case R.id.radiobutton3:{
                        System.out.println("33333");
                        break;

                    }
                }
            }
        });
    }


    public void day12(){
        setContentView(R.layout.day12_linearlayout);

    }

    public void day13(){
        setContentView(R.layout.day13_relativelayout);

    }


    public void day14(){
        setContentView(R.layout.day14_framelayout);

    }

    public void day15(){
        setContentView(R.layout.day15_absolutelayout);
    }

    public void day16(){
        setContentView(R.layout.day16_tablelayout);
    }

    public void day17(){
        setContentView(R.layout.day17_life);

        Button viewById = (Button)findViewById(R.id.day17_lifebutton1);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                MainActivity.this.startActivity(intent);

            }
        });
    }

    public void day21(){
        setContentView(R.layout.day21_linearlayout);
    }



    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        ImageView img = (ImageView)findViewById(R.id.imageView);
        if (b){
            img.setBackgroundResource(R.mipmap.on);

        } else {
            img.setBackgroundResource(R.mipmap.off);

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

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
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
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
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }
}










class MyOnClickListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        view.setAlpha((float) 0.5);
    }
}


