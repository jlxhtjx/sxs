package com.example.activity002;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_First extends AppCompatActivity {
    private static final String TAG = "Debug";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button_first = findViewById(R.id.button_1);

        /*这是Toast按钮
        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_First.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();
            }
        });
*/
        /*结束按钮
        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
        //跳转Activity_Second
/*        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_first = new Intent(Activity_First.this, Activity_Second.class);
                startActivity(intent_first);
            }
        });*/
        //用Intent跳转到Activity_Second
/*        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".ACTION_START");
                intent.addCategory(".MY_CATEGORY");
                startActivity(intent);
            }
        });*/
        //打开百度网页，http协议调用
        /*button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });*/
        //打开拨号tele，拨打给10086
        /*button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });*/
        //用Intent传递参数
        /*button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "hi, 1st man";
                Intent intent = new Intent(Activity_First.this, Activity_Second.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
                Log.d(TAG, "1st man~");
            }
        });*/
        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_First.this, Activity_Second.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_remove:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
            }
            return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && null != data) {
                String returnData = data.getStringExtra("data_return");
                assert returnData != null;
                Log.d(TAG, returnData);
            }

        }
    }
}
