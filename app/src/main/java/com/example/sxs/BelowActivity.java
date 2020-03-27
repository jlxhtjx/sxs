package com.example.sxs;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BelowActivity extends Activity {
    /*这个Activity是用来继承Activity的，因为AppcompatActivity有的theme不兼容，所以
    Activity_Other->BaseActivity(AppCompatActivity)->BelowActivity(Activity)*/
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
