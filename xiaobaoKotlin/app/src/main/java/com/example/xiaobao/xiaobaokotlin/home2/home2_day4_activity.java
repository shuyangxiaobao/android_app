package com.example.xiaobao.xiaobaokotlin.home2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

/**
 * Created by xiaobao on 2020/6/10.
 */

public class home2_day4_activity extends Activity {
    String[] single_list = {"男","女"};
    String[] multi_list = {"男生","女生","篮球","足球"};
    String[] item_list = {"项目经理","策划","ios","android"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_day4_mainview);
        this.initEvent();
    }

    private void initEvent() {
        Button btn1 = (Button) findViewById(R.id.home2_day4_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast1();
            }

        });

        Button btn2 = (Button) findViewById(R.id.home2_day4_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast2();
            }

        });

        Button btn3 = (Button) findViewById(R.id.home2_day4_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast3();
            }

        });

        Button btn4 = (Button) findViewById(R.id.home2_day4_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast4();
            }

        });

        Button btn5 = (Button) findViewById(R.id.home2_day4_btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast5();
            }

        });

    }

//    确认对话框
    private void showToast1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("确认对话框");
        builder.setIcon(R.drawable.day11_pic1);
        builder.setMessage("message");
        builder.setPositiveButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(home2_day4_activity.this,"sure",(Integer)2000).show();
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(home2_day4_activity.this,"cancel",(Integer)2000).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.create().show();

    }

//    单选按钮对话框
    private void showToast2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择性别");
        builder.setIcon(R.drawable.day11_pic1);
        builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(home2_day4_activity.this, single_list[i]+"", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    //    多选按钮对话框
    private void showToast3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("爱好");
        builder.setIcon(R.drawable.day11_pic1);
        builder.setMultiChoiceItems(multi_list, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b){
                    Toast.makeText(home2_day4_activity.this,"我喜欢"+ multi_list[i], Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(home2_day4_activity.this, "我不喜欢"+multi_list[i], Toast.LENGTH_SHORT).show();

                }

            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });



        builder.create().show();
    }


//    设置列表对话框
    private void showToast4() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("部门列表");
        builder.setIcon(R.drawable.day11_pic1);

        builder.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(home2_day4_activity.this, "我打了"+item_list[i], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });



        builder.create().show();
    }


    //    自定义对话框
    private void showToast5() {

        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.home2_day4_dialog_layout, null);



        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("自定义对话框");
        builder.setIcon(R.drawable.day11_pic1);
        builder.setView(view);

        builder.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(home2_day4_activity.this, "我打了"+item_list[i], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });



        builder.create().show();
    }


}
