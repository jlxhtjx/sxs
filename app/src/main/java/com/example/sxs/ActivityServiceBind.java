package com.example.sxs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//link->crazy p453
//有问题，出不来程序？why？
public class ActivityServiceBind extends AppCompatActivity {
    private static final String TAG = "ActivityServiceBind";
    private ServiceBind.MyBinder binder;
    private ServiceConnection connection = new ServiceConnection() {
        //        当该Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//            System.out.println("APP5--Service Connected--");
            Log.d(TAG, " APP5--Service Connected--");
            binder = (ServiceBind.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
//            System.out.println("APP5--Service Disconnected--");
            Log.d(TAG, "APP5--Service Disconnected--");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_bind);
        Button bindBtn = findViewById(R.id.lock_SerBind);
        Button unbindBtn = findViewById(R.id.unlock_SerBind);
        Button bindStatus = findViewById(R.id.SerBind_status);
        Intent intent = new Intent(this, ServiceBind.class);
        bindBtn.setOnClickListener(v -> bindService(intent, connection, Service.BIND_AUTO_CREATE));
        unbindBtn.setOnClickListener(view -> unbindService(connection));
        bindStatus.setOnClickListener(view -> Toast.makeText(ActivityServiceBind.this, "APP5-Service 的count 值为：" + binder.getCount(), Toast.LENGTH_SHORT).show());
    }
}
