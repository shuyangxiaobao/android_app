package com.example.xiaobao.xiaobaokotlin.home1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/4.
 */


public class day06_Activity extends Activity implements View.OnClickListener {
    private ProgressBar progress;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView textView;
    private ProgressDialog progressDialog;
    private Button show;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.day6view);
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(false);
        setProgress(7000);
        init();
    }

    private void init() {
        progress = findViewById(R.id.day6_horizonprogressbar);
        add = findViewById(R.id.day6view_add);
        reduce = findViewById(R.id.day6view_reduce);
        reset = findViewById(R.id.day6view_reset);
        textView = findViewById(R.id.day6_textview);
        show = findViewById(R.id.day6_show);

        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);
        show.setOnClickListener(this);

       showdata();


    }
    public void showdata(){
        int first = progress.getProgress();

        int second = progress.getSecondaryProgress();

        int max = progress.getMax();
        textView.setText("第1进度百分比：" + (int) (first / (float) max * 100) + "% 第2进度百分比" + (int) (second / (float) max * 100) + "%");
    }




    @Override
    public void onClick(View view) {
        System.out.println("12345621345678");
        switch (view.getId()) {
            case R.id.day6view_add: {
                System.out.println("1111");

                progress.incrementProgressBy(10);
                progress.incrementSecondaryProgressBy(10);
                break;

            }
            case R.id.day6view_reduce: {
                System.out.println("222");

                progress.incrementProgressBy(-10);
                progress.incrementSecondaryProgressBy(-10);
                break;


            }
            case R.id.day6view_reset: {
                System.out.println("333");

                progress.setProgress(50);
                progress.setSecondaryProgress(80);
                break;

            }
            case  R.id.day6_show:{
                /**
                 *页面显示风格
                 */
                progressDialog = new ProgressDialog(this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("我是title");
                progressDialog.setMessage("我是message");
                progressDialog.setIcon(R.drawable.czc);
                /**
                 *设定关于ProgressBar的y一些属性
                 */
                progressDialog.setMax(100);
                progressDialog.incrementProgressBy(50);
                progressDialog.setIndeterminate(false);
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(day06_Activity.this, "欢迎👏", Toast.LENGTH_SHORT).show();
                    }
                });

                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "ppp", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(day06_Activity.this, "欢迎👏", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.setCancelable(true);
                progressDialog.show();

            }
        }
        showdata();
    }
}
