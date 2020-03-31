package com.example.sxs;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MySerActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MySerActivity";
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button startService = findViewById(R.id.btn_MySer_str);
        Button stopService = findViewById(R.id.btn_MySer_stop);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);

        Button bindService = findViewById(R.id.bind_MyService);
        Button unbindService = findViewById(R.id.unbind_MyService);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);

        Button startIntentService = findViewById(R.id.start_intent_service);
        startIntentService.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_MySer_str:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent);
                break;
            case R.id.btn_MySer_stop:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            case R.id.bind_MyService:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, conn, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_MyService:
                unbindService(conn);
                break;
            case R.id.start_intent_service:
                Log.d(TAG, "Thread id is"+Thread.currentThread().getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
                break;
            default:
                break;

        }


    }
}
