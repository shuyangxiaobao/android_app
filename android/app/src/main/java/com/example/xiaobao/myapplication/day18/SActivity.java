package com.example.xiaobao.myapplication.day18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.xiaobao.myapplication.R;

/**
 * Created by xiaobao on 2020/6/3.
 */

public class SActivity extends Activity {
    private Button bt1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day18_sactivity);

      bt1 = (Button)findViewById(R.id.day18_page2_button);
      bt1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent();
              intent.putExtra("name","小明");
              setResult(2,intent);
              finish();
          }
      });

    }
}
