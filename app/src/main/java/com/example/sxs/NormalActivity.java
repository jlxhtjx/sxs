package com.example.sxs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NormalActivity extends BaseActivity {

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
                Intent intent = new Intent(NormalActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        Button btn_toDead = findViewById(R.id.all_over);
        btn_toDead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CollectorActivity.finishAll();
                Log.d(TAG, "Dead-Normal-finishAll");
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        CollectorActivity.finishAll();
        Log.d(TAG, "Dead-N-Destroy");
    }
}
