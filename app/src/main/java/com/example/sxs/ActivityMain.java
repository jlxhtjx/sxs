package com.example.sxs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends BaseActivity {

    private static final String TAG = "ActivityMain";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is " + getTaskId());
        setContentView(R.layout.layout_main);
        if (savedInstanceState != null) {
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
        }
        Button startNormalActivity = findViewById(R.id.start_normal_activity);
        startNormalActivity.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, ActivityNormal.class);
            startActivity(intent);
            Log.d(TAG, "Dead-Main-create");
        });
        Button startDialogActivity = findViewById(R.id.start_dialog_activity);
        startDialogActivity.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, ActivityDialog.class);
            startActivity(intent);
        });
        Button startStandardTest = findViewById(R.id.btn_stand);
        startStandardTest.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, ActivityMain.class);
            startActivity(intent);
        });
        Button startSingleTopTest = findViewById(R.id.btn_singleTop);
        startSingleTopTest.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, ActivityNormal.class);
            startActivity(intent);
        });
        Button jumpToThread = findViewById(R.id.jump_toThreadAct);
        jumpToThread.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, ActivityThread.class);
            startActivity(intent);
        });
        Button jumpToRelative1 = findViewById(R.id.to_relative1_layout);
        jumpToRelative1.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, activity_relative_test.class);
            startActivity(intent);
        });
        Button jumpToRelative2 = findViewById(R.id.to_relative2_layout);
        jumpToRelative2.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, activity_relative_test2.class);
            startActivity(intent);
        });
        Button jumpToCalculator = findViewById(R.id.btn_toCalculator);
        jumpToCalculator.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, Activity_Calculator.class);
            startActivity(intent);
        });
        Button jumpToQqLogin = findViewById(R.id.btn_qqLogin);
        jumpToQqLogin.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, activity_qqLogin.class);
            startActivity(intent);
        });
        Button btnStartSer = findViewById(R.id.jumpToService);
        btnStartSer.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, ActivityService.class);
            startActivity(intent);
        });
        Button btnMySer = findViewById(R.id.jumpToMySer);
        btnMySer.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, MySerActivity.class);
            startActivity(intent);
        });
        Button btnBroadcast = findViewById(R.id.jumpToBroadcast);
        btnBroadcast.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, ActivityBroadcast.class);
            startActivity(intent);
        });
        Button jumpToCrazySerBind = findViewById(R.id.jumpToCrazyServiceBind);
        jumpToCrazySerBind.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityMain.this, ActivityServiceBind.class);
            startActivity(intent);
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
