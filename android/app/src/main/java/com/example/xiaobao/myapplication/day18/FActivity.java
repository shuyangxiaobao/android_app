package com.example.xiaobao.myapplication.day18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.xiaobao.myapplication.R;

/**
 * Created by xiaobao on 2020/6/3.
 */

public class FActivity extends Activity {
    private Button bt1;
    private Button bt2;
    private TextView tx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day18_factivity);
        bt1 = (Button) findViewById(R.id.day18_firstpage_button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FActivity.this, SActivity.class);
                startActivity(intent);
            }
        });

        bt2 = (Button) findViewById(R.id.day18_firstpage_button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FActivity.this, SActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        tx = (TextView) findViewById(R.id.day18_page1_textview);

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode ==2){
            String name = data.getStringExtra("name");
            tx.setText(name);

        }
    }


}
