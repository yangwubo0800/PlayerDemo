package com.example.wg.playerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private String TAG = this.getClass().getName();
    private String localFile = "file:///android_asset/main.html";
    //本地视频
    private String localTest = "file:///sdcard/webview_video/VID_20180524_100310.mp4";
    private String videoTitle = "video title";

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = findViewById(R.id.wv);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d(TAG,"=====shouldOverrideUrlLoading url=" + url);
                view.loadUrl(url);
                return false;
                //return super.shouldOverrideUrlLoading(view, url);
            }
        });

        mWebView.loadUrl(localFile);
        mWebView.addJavascriptInterface(new Object(){
            @JavascriptInterface
            public void playVideo(String videoPath) {
                //play video
                Log.d(TAG,"=====playVideo");
                VideoActivity.intentTo(WebViewActivity.this, videoPath, videoTitle);
            }

        }, "index");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
