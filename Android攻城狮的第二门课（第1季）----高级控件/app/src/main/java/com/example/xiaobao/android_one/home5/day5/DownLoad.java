package com.example.xiaobao.android_one.home5.day5;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import org.apache.http.protocol.HTTP;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by xiaobao on 2020/6/21.
 */

public class DownLoad {
    private Handler handler;

    public DownLoad(Handler handler) {
        this.handler = handler;
    }

    private Executor threadPool = Executors.newFixedThreadPool(3);

    static class DownLoadRunnable implements Runnable {
        private String url;
        private String fileName;
        private long start;
        private long end;
        private Handler handler;

        public DownLoadRunnable(String url, String fileName, long start, long end, Handler handler) {
            this.url = url;
            this.fileName = fileName;
            this.start = start;
            this.end = end;
            this.handler = handler;
        }

        @Override
        public void run() {
            URL httpUrl = null;
            try {
                httpUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
                connection.setReadTimeout(5000);
                connection.setRequestProperty("Range", "bytes=" + start + "-" + end);
                connection.setRequestMethod("GET");
                RandomAccessFile access = new RandomAccessFile(new File(fileName), "rwd");
                access.seek(start);
                InputStream in = connection.getInputStream();
                byte[] b = new byte[1024 * 4];
                int len = 0;
                while ((len = in.read(b)) != -1) {
                    access.write(b, 0, len);
                }
                if (access != null) {
                    access.close();
                }
                if (in != null) {
                    in.close();
                }
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }


    public void downLoadFile(String url) {
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");
            int count = connection.getContentLength();
            int block = count / 3;
            String fileName = getFileName(url);
            File parent = Environment.getExternalStorageDirectory();
            File fileDownLoad = new File(parent, fileName);

            /*
            *
            * 11/3  3
            * 第1个线程 0-2
            * 第2个线程 3-5
            * 第3个线程 6-10
            * */
            for (int i = 0; i < 3; i++) {
                long start = i * block;
                long end = (i + 1) * block - 1;
                if (i == 2) {
                    end = count;
                }
                DownLoadRunnable runnable = new DownLoadRunnable(url, fileDownLoad.getAbsolutePath(), start, end,handler);
                threadPool.execute(runnable);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName(String url) {
        return "xlp_20200622.jpg";
    }


}
