package com.example.sxs;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CalculatorActivity extends BaseActivity {

    private static final String TAG = "Activity_Calculator";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculator);
    }

    public void oneOnClick(View view) {
        if (view instanceof TextView) {
            String oneText = ((TextView) view).getText().toString();
            Log.d(TAG, "one btn context ==" + oneText);
        }
    }

    public void orangeOnClick(View view) {
        if (view instanceof TextView) {
            String oneText = ((TextView) view).getText().toString();
            Log.d(TAG, "one btn context ==" + oneText);
        }
    }
}
