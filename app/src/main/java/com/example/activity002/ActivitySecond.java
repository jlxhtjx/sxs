package com.example.activity002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitySecond extends AppCompatActivity {
    private static final String TAG = "Debug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*传入Activity_First的值.
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d(TAG, "2nd: "+data);*/
        Button buttonSecond = findViewById(R.id.button_2);
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello 1st man");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello Activity_First");
        setResult(RESULT_OK, intent);
        finish();
    }
}
