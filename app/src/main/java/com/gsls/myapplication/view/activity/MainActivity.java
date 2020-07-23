package com.gsls.myapplication.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.gsls.myapplication.R;
import com.gsls.myapplication.model.LoginBean;
import com.gsls.myapplication.presenter.LoginPresenter;
import com.gsls.myapplication.presenter.base.INetworkRequest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, INetworkRequest {

    private LoginPresenter loginPresenter;

    private EditText et_user;
    private EditText et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_user = findViewById(R.id.et_user);
        et_pass = findViewById(R.id.et_pass);

        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_1://登录
                loginPresenter.login(new LoginBean(et_user.getText().toString(), et_pass.getText().toString()));
                break;

            case R.id.btn_2://注册
                loginPresenter.register(new LoginBean(et_user.getText().toString(), et_pass.getText().toString()));
                break;
        }

    }


    @Override
    public void showLoading() {
        Log.i("GT_", "开始加载请求数据");
    }


    @Override
    public void dismissLoading() {
        Log.i("GT_", "请求数据完毕");
    }
}