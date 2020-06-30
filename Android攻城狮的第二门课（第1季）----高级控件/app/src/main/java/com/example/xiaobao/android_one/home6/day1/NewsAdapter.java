package com.example.xiaobao.android_one.home6.day1;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xiaobao.android_one.R;
import com.example.xiaobao.android_one.home5.day3.HttpImage;
import com.example.xiaobao.android_one.home5.day3.JsonAdapter;
import com.example.xiaobao.android_one.home5.day3.json_model.Person;
import com.example.xiaobao.android_one.home5.day3.json_model.SchoolInfo;

import java.util.List;

/**
 * Created by xiaobao on 2020/6/24.
 */

public class NewsAdapter extends BaseAdapter implements AbsListView.OnScrollListener {
    private List<NewsBean> list;
    private Context context;
    private LayoutInflater inflater;
    private Handler handler = new Handler();
    private ListView listView;
    private ImageLoader imageLoader;
    private int mStart, mEnd;
    public static String[] URLS;

    public NewsAdapter(List<NewsBean> list, Context context, Handler handler, ListView listView) {
        this.list = list;
        this.listView = listView;
        this.listView.setOnScrollListener(this);
        this.context = context;
        this.handler = handler;
        inflater = LayoutInflater.from(context);
        imageLoader = new ImageLoader(listView);
        URLS = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            URLS[i] = list.get(i).newsIconUrl;
        }
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

//        不仅利用了Listview的缓存，更通过 News_Holder 类来实现显示数据的视图的缓存
//        避免多次通过 findViewById 寻找控件

        News_Holder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.home6_day1_item, null);
            holder = new News_Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (News_Holder) convertView.getTag();
        }

        NewsBean news = list.get(position);

        holder.title_view.setText(news.newsTitle);
        holder.content_view.setText(news.newsContent);
        holder.imageView.setTag(news.newsIconUrl + "xlp");

//        holder.imageView.setImageResource(R.mipmap.ic_launcher);

//        有以下两种方式异步加载图片
//        new HttpImage(holder.imageView,news.newsIconUrl,handler).start();

        imageLoader.showImageByAsyncTask(holder.imageView, news.newsIconUrl);
        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE) {
            imageLoader.loadImages(mStart, mEnd);
//            加载可见项
        } else {
//            停止任务
            imageLoader.cancelAllTasks();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        boolean refresh = false;
        if (mEnd == 0) {
            refresh = true;
        }
        mStart = firstVisibleItem;
        mEnd = firstVisibleItem + visibleItemCount;
//        首次启动预加载
        if (refresh && visibleItemCount > 0) {
            imageLoader.loadImages(mStart, mEnd);
        }
    }

    class News_Holder {
        private TextView title_view;
        private TextView content_view;
        private ImageView imageView;

        public News_Holder(View view) {
            imageView = (ImageView) view.findViewById(R.id.home6_day1_item_imageview);
            title_view = (TextView) view.findViewById(R.id.home6_day1_item_title);
            content_view = (TextView) view.findViewById(R.id.home6_day1_item_content);
        }
    }


}
