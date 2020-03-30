package com.example.sxs;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


public class ServiceBind extends Service {
    private int count;
    private boolean quit;
    private MyBinder binder = new MyBinder();


    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("ADD2 Service is Binder");
        return binder;
    }

    class MyBinder extends Binder {
        public int getCount() {
            return ServiceBind.this.count;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("ADD2 Service is Created");
        new Thread(() -> {
            while (!quit) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ServiceBind.this.count++;
            }
        }).start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("ADD2 Service is Unbinded");
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        System.out.println("ADD2 Service id Destroy");
    }
}
