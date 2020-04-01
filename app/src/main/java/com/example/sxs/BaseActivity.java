package com.example.sxs;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class BaseActivity extends BelowActivity {
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());
        Log.d(TAG, "Dead-Base-create");
        CollectorActivity.addActivity(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Dead-Base-Destroy");
        CollectorActivity.removeActivity(this);
    }
}
