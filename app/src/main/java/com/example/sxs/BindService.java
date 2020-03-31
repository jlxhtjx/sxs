package com.example.sxs;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BindService extends Service {
//    about 第一行代码

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
