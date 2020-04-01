package com.example.sxs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class DialogActivity extends BaseActivity {
    private static final String TAG = "ActivityDialog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);
        Log.d(TAG, "Task id is " + getTaskId());
    }
}
