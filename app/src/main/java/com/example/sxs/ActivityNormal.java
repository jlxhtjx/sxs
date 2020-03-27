package com.example.sxs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityNormal extends BaseActivity {

    private static final String TAG = "ActivityNormal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Task id is " + getTaskId());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_normal);
        Button btn_backMain = findViewById(R.id.back_main);
        btn_backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityNormal.this, ActivityDialog.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
