package com.example.xiaobao.xiaobaokotlin.home5.day3;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaobao.xiaobaokotlin.R;
import com.example.xiaobao.xiaobaokotlin.home5.day3.json_model.Person;
import com.example.xiaobao.xiaobaokotlin.home5.day3.json_model.SchoolInfo;

import java.util.List;

/**
 * Created by xiaobao on 2020/6/21.
 */

public class JsonAdapter extends BaseAdapter {
    private List<Person> list;
    private Context context;
    private LayoutInflater inflater;
    private Handler handler=  new Handler();

    public JsonAdapter(List<Person> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);

    }

    public JsonAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<Person> data){
        this.list = data;
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
        Holder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.home5_day3_item, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        Person person = list.get(position);
        holder.name.setText(person.getName());
        holder.age.setText(person.getAge() + "");

        List<SchoolInfo> schoolInfo_list = person.getSchoolInfo();
        holder.school1.setText(schoolInfo_list.get(0).getSchool_name());
        holder.school2.setText(schoolInfo_list.get(1).getSchool_name());
        new HttpImage(holder.imageView,person.getUrl(),handler).start();

        return convertView;
    }

    class Holder {
        private TextView name;
        private TextView age;
        private TextView school1;
        private TextView school2;
        private ImageView imageView;

        public Holder(View view) {
            imageView = (ImageView) view.findViewById(R.id.home5_day3_item_imageview);
            name = (TextView) view.findViewById(R.id.home5_day3_itemtextview1);
            age = (TextView) view.findViewById(R.id.home5_day3_itemtextview2);
            school1 = (TextView) view.findViewById(R.id.home5_day3_itemtextview3);
            school2 = (TextView) view.findViewById(R.id.home5_day3_itemtextview4);
        }
    }


}
