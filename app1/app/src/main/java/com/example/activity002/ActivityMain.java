package com.example.activityLiftCycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends AppCompatActivity {

    private static final String TAG = "ActivityMain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnStartNormal = (Button) findViewById(R.id.btn_start_normalActivity);
        Button btnStartDialog = (Button) findViewById(R.id.btn_start_dialogActivity);
        btnStartNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this, ActivityNormal.class);
                startActivity(intent);
            }

        });

        btnStartDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityMain.this, ActivityDialog.class);

                startActivity(intent);
                Log.e(TAG, "onCreate: gogogo?" );
            }
        });
        Log.d(TAG, "onCreate");
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
        Log.d(TAG, "onPause 111");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop 222");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart 333");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy 444");
    }
}
