package com.example.xiaobao.android_one.home6.day1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.xiaobao.android_one.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.sleep;

/**
 * Created by xiaobao on 2020/6/25.
 */

public class ImageLoader {
    public ImageView imageView;
    private String url;
    private LruCache<String, Bitmap> mCaches; // 缓存图片
    public ListView mListView;
    private Set<NewsAsyncTask> mTask;


    public ImageLoader(ListView listView) {
        mListView = listView;
        mTask = new HashSet<>();
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 4;
        mCaches = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
//                每次存入缓存的时候调用
                System.out.println("😄😂😄😂😄😂😄😂😄😂😄😂😄😂😄😂" + key);
                return value.getByteCount();
            }
        };

    }

    public void showImageByAsyncTask(ImageView imageView, String url) {
//        Bitmap bitmap = getBitmapFromCache(url);


        Bitmap bitmap = getBitmapFromCache(url);
        if (bitmap == null) {
            imageView.setImageResource(R.mipmap.ic_launcher);
//            new NewsAsyncTask(url).execute(url);
        } else {
            imageView.setImageBitmap(bitmap);
        }

//        new NewsAsyncTask(imageView,url).execute(url);

    }


    //    添加到缓存
    public void addBitmapToCache(String url, Bitmap bitmap) {
        if (getBitmapFromCache(url) == null) {
            mCaches.put(url, bitmap);
        }
    }

    public Bitmap getBitmapFromCache(String url) {
        return mCaches.get(url);
    }

    public ImageLoader(ImageView imageView, String url) {
        this.imageView = imageView;
        this.url = url;
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 4;
        mCaches = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                System.out.println("😄😂😄😂😄😂😄😂😄😂😄😂😄😂😄😂" + key);
                return value.getByteCount();
            }
        };
    }

//    根据图片地址获取图片的 bitmap
    private Bitmap getBitmapFromURL(String urlString) {
        final URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
//            sleep(500);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void loadImages(int start,int end){
        for (int i = start; i < end; i++) {
            String url = NewsAdapter.URLS[i];
            Bitmap bitmap = getBitmapFromCache(url);
            if (bitmap == null) {
                NewsAsyncTask task = new NewsAsyncTask(url);
                task.execute(url);
                mTask.add(task);
            } else {
                ImageView imageview = (ImageView) mListView.findViewWithTag(url+"xlp");
                imageview.setImageBitmap(bitmap);
            }

        }
    }

    public void cancelAllTasks(){
        if (mTask != null){
            for (NewsAsyncTask task:mTask
                 ) {
                task.cancel(false);
            }
        }
    }


    private class NewsAsyncTask extends AsyncTask<String, Void, Bitmap> {
        private String url;

        public NewsAsyncTask(String url) {
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            Bitmap bitmap = getBitmapFromCache(url);
            if (bitmap == null) {
                bitmap = getBitmapFromURL(url);
                addBitmapToCache(url, bitmap);
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
//            ImageView imageview = (ImageView) mListView.findViewWithTag(url);
//            String str = imageView.getTag().toString();
//            if (str.equals(url.toString())) {
                ImageView imgView = (ImageView) mListView.findViewWithTag(url+"xlp");
                if (imgView != null && bitmap != null){
                    imgView.setImageBitmap(bitmap);
                }
                mTask.remove(this);
//            }
        }
    }


}
