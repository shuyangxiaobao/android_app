package com.example.xiaobao.xiaobaokotlin.home1.day7;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaobao.xiaobaokotlin.R;

//import android.net.Uri;

//import java.net.URL;

/**
 * Created by xiaobao on 2020/6/4.
 */


public class day07_webview_Activity extends Activity implements View.OnClickListener {
    private String url = "http://192.168.0.102:8082/index.jsp";
    private WebView webView;
    private ProgressDialog dialog;

    private Button backButt;
    private Button refreshButt;
    private TextView textView;


    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            String cookie = (String) msg.obj;
            CookieSyncManager.createInstance(day07_webview_Activity.this);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("http://192.168.0.102:8082",msg.obj.toString());
            CookieSyncManager.getInstance().sync();
            webView.loadUrl("http://192.168.0.102:8082/index.jsp");



        }
    };


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day7view);
        init();
        initUI();
    }

    private void initUI() {
        backButt = findViewById(R.id.home1_day7_back);
        refreshButt = findViewById(R.id.home1_day7_refresh);
        textView = findViewById(R.id.home1_day7_textview);
        backButt.setOnClickListener(this);
        refreshButt.setOnClickListener(this);

    }


    //调用外部浏览器打开网址
    private void fun1() {
        Uri parse = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, parse);
        startActivity(intent);

    }

    @SuppressLint("JavascriptInterface")
    private void init() {

        webView = findViewById(R.id.day07_webview);
        webView.setDownloadListener(new MyDownload());

//        Webview 加载外部资源
//        webView.loadUrl(url);

//        加载本地图片
//        webView.loadUrl("file:///android_asset/build/index.html");

        if (true) {
            webView.loadUrl(url);

        } else {
            webView.loadUrl("file:///android_asset/build/index.html");
        }



//        启用支持Javascript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

//        webview 加载页面优先使用缓存
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

        webView.addJavascriptInterface(new WebHost(this),"js");


        webView.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override

            //        覆盖webviewm默认通过第三方或者系统浏览器打开网页的行为，使得网页可以在webview中打开
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                Uri requestUrl = request.getUrl();

                System.out.println(day07_webview_Activity.this.url);
               if (requestUrl.toString().endsWith("start")){
                   Toast.makeText(day07_webview_Activity.this, "自定义协议", Toast.LENGTH_SHORT).show();
                   return true;
               }


                view.loadUrl(requestUrl.toString());
                //                返回值时true的时候控制网页在webview中打开，如果为false 调用系统浏览器或者第三方浏览器
                return super.shouldOverrideUrlLoading(view, request);
            }



            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                view.loadUrl("file:///android_asset/error.html");
//                webView.setVisibility(View.GONE); //隐藏webview

            }
        });


        webView.setWebChromeClient(new WebChromeClient() {
            @Override

//            获取网页标题
            public void onReceivedTitle(WebView view, String title) {
                System.out.println("title:" + title);
                textView.setText("" + title);

//                url = "http://sowhat.gdown.baidu.com/e7c843541b27af40e94563c1d58fe1cd/5ef1a1d7/appsearch_AndroidPhone_v9.4.1.2(1.0.81.196)_1015530k.apk?filename=百度手机助手→ClassIn.apk&suffix=8MxSqIMm-9gZa-ioga2ukzMhA6NcJAja6PVm8_PLv8gra2khzMAd6tJJmqI24DjckpE9kjugvt_OOB8ujuvgija4X8zzRxYhI5LeoNy8wj6rPePZ9lw3qky1LI_Uh2kgofAzz9JpxqtHp-kQrJxno9RgQzINRQRw6Ieq8gNlv8y_uXkj0rFgqNkpEo5KJFC9zav1ioaDs8_lMsOCrkWtPzMgm6kfyeu5N4mGqzMY3ofz5m659Ns08_CV2kpOyAoWfJLiI_u32I_-CviN6heaYkyBwkYQRv8QNOBjigu3vzgma2tHguvF8_amvi_R4viQ_OANiY4AEz_6aBzu_yeF_qqqB&suffixstart=8456972&suffixlens=345";
// 方式1：自定义下载
//     new Home1Day7_httpThread(url).start();

//                方式2：调用系统下载
//                Uri uri = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
            }

            //            进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                System.out.println("newProgress"+newProgress);
//                if (newProgress == 100) {
//                    closeDialog();
//                } else {
//                    openDidlog(newProgress);
//                }
            }

        });

        new HttpCookie(handler).start();



    }

    private void openDidlog(int newProgress) {
        if (dialog == null) {
            dialog = new ProgressDialog(this);
            dialog.setTitle("我是title");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setProgress(newProgress);
            dialog.show();
        } else {
            dialog.setProgress(newProgress);
            dialog.show();
        }

    }

    private void closeDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            dialog = null;
        }

    }


    //    改写物理按键--返回按键的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            Toast.makeText(this, webView.getUrl(), Toast.LENGTH_SHORT).show();
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            }
        } else {
            System.exit(0);
        }
        return true;
    }


    //    点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home1_day7_back: {
                finish();
                break;
            }
            case R.id.home1_day7_refresh: {
                webView.reload();
                break;
            }
            default:
                break;
        }

    }


    class MyDownload implements DownloadListener {
        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {

            url = "http://sowhat.gdown.baidu.com/e7c843541b27af40e94563c1d58fe1cd/5ef1a1d7/appsearch_AndroidPhone_v9.4.1.2(1.0.81.196)_1015530k.apk?filename=百度手机助手→ClassIn.apk&suffix=8MxSqIMm-9gZa-ioga2ukzMhA6NcJAja6PVm8_PLv8gra2khzMAd6tJJmqI24DjckpE9kjugvt_OOB8ujuvgija4X8zzRxYhI5LeoNy8wj6rPePZ9lw3qky1LI_Uh2kgofAzz9JpxqtHp-kQrJxno9RgQzINRQRw6Ieq8gNlv8y_uXkj0rFgqNkpEo5KJFC9zav1ioaDs8_lMsOCrkWtPzMgm6kfyeu5N4mGqzMY3ofz5m659Ns08_CV2kpOyAoWfJLiI_u32I_-CviN6heaYkyBwkYQRv8QNOBjigu3vzgma2tHguvF8_amvi_R4viQ_OANiY4AEz_6aBzu_yeF_qqqB&suffixstart=8456972&suffixlens=345";
            System.out.println("url------------->" + url);
            if (url.endsWith(".apk") || true) {


//                new Home1Day7_httpThread(url).start();
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        }
    }


}


//        webView.reload();   刷新

//    finish(); 返回上一页，结束本页