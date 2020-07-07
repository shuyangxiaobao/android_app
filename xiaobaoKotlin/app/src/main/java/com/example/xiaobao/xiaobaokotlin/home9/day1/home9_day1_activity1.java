package com.example.xiaobao.xiaobaokotlin.home9.day1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

import com.example.xiaobao.xiaobaokotlin.R;

import java.util.List;

import static com.example.xiaobao.xiaobaokotlin.R.string.*;


/**
 * Created by xiaobao on 2020/7/2.
 */


@EActivity(R.layout.home9_day1_firstview)
public class home9_day1_activity1 extends Activity {

    @StringRes
    String name;

    @ViewById(R.id.text1)
    TextView textView1;
    @ViewById(R.id.text2)
    TextView textView2;

    @ViewsById({R.id.text1, R.id.text2})
    List<TextView> list;

    @ViewById
    Button button1;
    @ViewById(R.id.button2)
    Button button2;
    @ViewById
    Button button3;
    @ViewById
    Button button4;
    @ViewById
    Button button5;



    public static final String name_key = "name";
    public static final String age_key = "age";


//    https://github.com/androidannotations/androidannotations/wiki/FirstActivity

    @Click(R.id.button1)
    void button1_click() {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
        Log.i("", "button1_click: ");
    }

    //    单个view添加点击事件
    @Click(R.id.button2)
    void button2_click() {
        Intent intent = new Intent(this, home9_day1_activity2_.class);
        intent.putExtra(name_key, "xiaoming");
        intent.putExtra(age_key, "18");

        startActivity(intent);
    }

    @AfterViews
    public void initUI() {
        button1.setText("MyService-001");
        button2.setText("下一页");
        button3.setText("LongClick");
        button4.setText("listview 页面");
    }

    @AfterViews
    public void setTextview() {
        for (TextView textView : list) {
            textView.setText("xlp");
        }
        System.out.println("add:"+name);
        textView1.setText(name);
    }

    //    多个view一起添加点击事件
    @Click({R.id.text1, R.id.text2})
    public void text_click(View view) {
        Toast.makeText(this, "" + view.getId(), Toast.LENGTH_SHORT).show();
    }

    //    长按点击事件
    @LongClick(R.id.button3)
    public void showToast(View view) {
        Toast.makeText(this, "" + view.getId(), Toast.LENGTH_SHORT).show();
    }

    @Click(R.id.button4)
    public void button_click4(View view) {
        Intent intent = new Intent(this, home9_day1_activity3_.class);

        startActivity(intent);
    }

    @Click(R.id.button5)
    public void button_click5(View view) {
        doSomething();
    }

    @Background
    public void doSomething(){
        Log.i("", "doSomething: "+Thread.currentThread().getId());
        updateUI();

    }

    @UiThread
    public void updateUI(){
        Log.i("", "updateUI: "+Thread.currentThread().getId());

        button5.setText("update UI");
    }




//    http://rap2.taobao.org:38080/app/mock/233798/marketdata

}


