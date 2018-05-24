package com.example.wg.playerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //https
    private String mVideoPath = "https://media.w3.org/2010/05/sintel/trailer.mp4";
    private String mVideoTitle = "Test Demo";


    //本地视频
    private String localTest = "file:///sdcard/webview_video/VID_20180524_100310.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt  = (Button)findViewById(R.id.jump_video);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent it = new Intent();
////                it.putExtra("videoPath", mVideoPath);
////                it.setClass(MainActivity.this, VideoActivity.class);
////                startActivity(it);
                VideoActivity.intentTo(MainActivity.this, localTest, mVideoTitle);
            }
        });

        Button webview  = (Button)findViewById(R.id.jump_webview);
        webview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, WebViewActivity.class);
                startActivity(it);
            }
        });
    }
}
