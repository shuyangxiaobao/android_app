package com.example.xiaobao.xiaobaokotlin.home9.day1;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaobao on 2020/7/2.
 */

@EActivity(R.layout.home9_day1_threeview)
public class home9_day1_activity3 extends Activity {

    @ViewById(R.id.listview)
    ListView listView;



    @AfterViews
    public void init(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("xlp:"+i);
        }
        MyAdapter adapter = new MyAdapter(list, this);
        listView.setAdapter(adapter);
    }

    @ItemClick(R.id.listview)
    public void listviewItemClick(int index){
        Toast.makeText(this, ""+index, Toast.LENGTH_SHORT).show();
    }

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(matrix[0][0]);
            int count = matrix.length;

            int a1 = 1;
            int a2 = 0;
            int b1 = 0;
            int b2 = 1;
            int j = 0;
            while (list.size() != k-1){
                int a = matrix[a2][a1];
                int b = matrix[b2][b1];
                if (a<b){
                    list.add(a);
                    a1++;
                    a2+=a1/count;
                    a1=a1%count;
                } else {
                    list.add(b);
                    b1++;
                    b2+=b1/count;
                    b1=b1%count;
                }
            }

            return list.get(k-1);
        }

    }




}


