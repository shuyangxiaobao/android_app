package com.example.xiaobao.android_one.home9.day1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xiaobao on 2020/7/2.
 */

public class MyAdapter extends BaseAdapter {
    public List<String> list;
    private Context context;

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = list.get(position);
        TextView textView = new TextView(context);
        textView.setText(name);
        textView.setHeight(100);
        textView.setPadding(20,0,0,0);
        return textView;
    }
}
