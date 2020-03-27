package com.example.sxs;

import android.annotation.SuppressLint;
import android.os.Message;
import android.os.Handler;

import androidx.annotation.Nullable;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;


public class ActivityThread extends BaseActivity implements View.OnClickListener {

    private TextView text;
    private static final String TAG = "ActivityThread";
    public static final int UPDATE_TEXT = 1;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == UPDATE_TEXT) {

                text.setText("Nice to meet you");
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_thread);
        text = findViewById(R.id.thread_text);
        Button changeText = findViewById(R.id.thread_changeText);
        changeText.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.thread_changeText:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);

                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
