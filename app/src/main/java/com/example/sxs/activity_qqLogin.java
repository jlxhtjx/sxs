package com.example.sxs;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class activity_qqLogin extends BaseActivity {

    private static final String TAG = "activity_qqLogin";
    private EditText account;
    private EditText qqpassword;
    private Button qqLogin;
    private File cacheDir;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_qq_login);
        //先找到控件
        initView();
        initListener();
    }

    private void initListener() {
        qqLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlerLoginEvent();
                Log.d(TAG, "onClick: 点击了登录按钮");
            }
        });
    }

    private void handlerLoginEvent() {
        //第三步
        String accountText = account.getText().toString();
        String passwdText = qqpassword.getText().toString();
        if (TextUtils.isEmpty(accountText)) {
            Toast.makeText(this, "账号不可为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwdText)) {
            Toast.makeText(this, "密码不可为空", Toast.LENGTH_SHORT).show();
            return;
        }
        saveUserInfo(accountText, passwdText);
        Log.d(TAG, "qq:" + accountText);
        Log.d(TAG, "passwd:" + passwdText);
    }

    private void saveUserInfo(String accountText, String passwdText) {
        Log.d(TAG, "saveUserInfo: 保存用户信息");
        File fileDir = this.getFilesDir();
        File saveFile = new File(fileDir, "info.txt");
        cacheDir = this.getCacheDir();
        Log.d(TAG, "缓存文件路径: " + cacheDir);
        Log.d(TAG, "fileDirPath=" + fileDir.toString());
        try {
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(saveFile);
            fos.write((accountText + "xxx" + passwdText).getBytes());
            fos.close();
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*
    这个方法我们用来找到对应的控件
     */

    private void initView() {
        account = this.findViewById(R.id.et_qqlogin_account);
        qqpassword = this.findViewById(R.id.et_qqlogin_passwd);
        qqLogin = this.findViewById(R.id.btn_qq_login);
    }
}
