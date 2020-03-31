package com.example.sxs;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    private static final String TAG = "MyService";

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d(TAG, "startDownload: executed");
        }

        public int getProgress() {
            Log.d(TAG, "getProgress: executed");
            return 0;
        }


    }

    private DownloadBinder mBinder = new DownloadBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate:executed ");
        Intent intent = new Intent(this, MySerActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        String channel = "test_channel";
        Notification notification = new NotificationCompat.Builder(this, channel)
                .setContentTitle("This is content title")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            assert nm != null;
            nm.createNotificationChannel(new NotificationChannel(channel, "My channel", NotificationManager.IMPORTANCE_HIGH));
        }
        startForeground(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: executed");
        new Thread(new Runnable() {
            @Override
            public void run() {
//                不要忘了关线程
                stopSelf();
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: executed");
    }


}
