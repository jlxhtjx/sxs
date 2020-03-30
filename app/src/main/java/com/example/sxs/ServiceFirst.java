package com.example.sxs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class ServiceFirst extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("ADD1:Service is Created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        System.out.println("ADD1:Service is Started");
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("ADD1:Service is Stop.");
    }
}
