package com.gsls.myapplication.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.gsls.myapplication.model.AppDomeData;
import com.gsls.myapplication.model.LoginBean;
import com.gsls.myapplication.presenter.base.INetworkRequest;

public class LoginPresenter {

    private INetworkRequest iNetworkRequest;
    private Activity activity;

    public LoginPresenter(INetworkRequest iNetworkRequest) {
        this.iNetworkRequest = iNetworkRequest;
        activity = (Activity) iNetworkRequest;
    }

    public void login(final LoginBean loginBean) {
        iNetworkRequest.showLoading();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (AppDomeData.userName.equals(loginBean.getUserName()) && AppDomeData.passWrod.equals(loginBean.getPassWord())) {
                                Toast.makeText(activity, "登录成功", Toast.LENGTH_SHORT).show();
                                iNetworkRequest.dismissLoading();
                            } else {
                                Toast.makeText(activity, "登录失败", Toast.LENGTH_SHORT).show();
                                iNetworkRequest.dismissLoading();
                            }

                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public void register(final LoginBean loginBean) {
        iNetworkRequest.showLoading();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if ("".equals(loginBean.getUserName()) || "".equals(loginBean.getPassWord())) {
                                Toast.makeText(activity, "注册的账号密码不能为空", Toast.LENGTH_SHORT).show();
                                iNetworkRequest.dismissLoading();
                            } else {
                                AppDomeData.userName = loginBean.getUserName();
                                AppDomeData.passWrod = loginBean.getPassWord();
                                Toast.makeText(activity, "注册成功", Toast.LENGTH_SHORT).show();
                                iNetworkRequest.dismissLoading();
                            }
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}
