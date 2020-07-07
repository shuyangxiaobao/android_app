package com.example.xiaobao.xiaobaokotlin.home5.day6;

import android.os.Environment;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by xiaobao on 2020/6/22.
 */

public class UploadThread extends Thread {
    private String fileName;
    private String url;

    public UploadThread(String fileName, String url) {
        this.fileName = fileName;
        this.url = url;
    }

    @Override
    public void run() {
        uploadHttpClient();
//

//        httpUpload();
    }
    private void uploadHttpClient(){

        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        File parent = Environment.getExternalStorageDirectory();
        File fileAbs = new File(parent, "xlp_20200622.jpg");
        FileBody fileBody = new FileBody(fileAbs);

        MultipartEntity muti = null;
        muti = new MultipartEntity();
        muti.addPart("file",fileBody);
        post.setEntity(muti);
        try {
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



        private void httpUpload(){
        String boundary = "----WebKitFormBoundarySBybRWAY56IATYLB";
        String prefix = "--";
        String end = "\r\n";
        try {
            URL httpUrl = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) httpUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(prefix + boundary + end);
            out.writeBytes("Content-Disposition: form-data;" + "name=\"file\";filename=\"" + "xlp_20200622.jpg" + "\"" + end);
            out.writeBytes(end);
            FileInputStream fileInputStream = new FileInputStream(new File(fileName));
            byte[] b = new byte[1024 * 4];
            int len;
            while ((len = fileInputStream.read(b)) != -1) {
                out.write(b, 0, len);
            }
            out.writeBytes(end);
            out.writeBytes(prefix + boundary + prefix + end);
            out.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String str;
            while ((str = reader.readLine()) != null) {
                buffer.append(str);
            }
            System.out.println("response" + buffer.toString());
            if (out != null) {
                out.close();
            }
            if (reader != null) {
                reader.close();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }






}
