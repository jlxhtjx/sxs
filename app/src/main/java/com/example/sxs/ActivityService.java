package com.example.sxs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityService extends AppCompatActivity {

    private ServiceBind.MyBinder binder;
    private ServiceConnection conn = new ServiceConnection() {
        //当该Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("--Service Connected--");
            binder = (ServiceBind.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("--Service Disconnected--");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 /*       setContentView(R.layout.activity_service);
        Button startService = findViewById(R.id.btn_start_ser);
        Button stopService = findViewById(R.id.btn_stop_ser);
        Intent intent = new Intent(this, ServiceFirst.class);
        startService.setOnClickListener(view -> startService(intent));
        stopService.setOnClickListener(view -> stopService(intent));

        Button getSerStatus = findViewById(R.id.btn_getSerStatus);
        Button bindBn = findViewById(R.id.btn_bindBn);
        Button unbindBn = findViewById(R.id.btn_unbindBn);
        Intent intentSec = new Intent(this, ServiceBind.class);
        bindBn.setOnClickListener(view -> bindService(intentSec, conn, Service.BIND_AUTO_CREATE));
        unbindBn.setOnClickListener(view -> unbindService(conn));
        getSerStatus.setOnClickListener(view -> Toast.makeText(ActivityService.this,
                "Service 的count值为：" + binder.getCount(), Toast.LENGTH_SHORT).show());
*/
    }
}
