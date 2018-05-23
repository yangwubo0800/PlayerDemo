package com.example.wg.playerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String mVideoPath = "https://media.w3.org/2010/05/sintel/trailer.mp4";
    private String mVideoTitle = "Test Demo";
    private String test = "http://hls.open.ys7.com/openlive/9a16d0fb75be40b29cfe6aee30006a86.hd.m3u8";
    private String test1 = "rtmp://rtmp.open.ys7.com/openlive/9a16d0fb75be40b29cfe6aee30006a86.hd";

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
                VideoActivity.intentTo(MainActivity.this, test1, mVideoTitle);
            }
        });
    }
}
