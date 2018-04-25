package com.example.myrxjava.ui.login;

import android.text.TextUtils;
import android.util.Log;

import com.example.myrxjava.api.LoginApi;
import com.example.myrxjava.constract.LoginContract;
import com.example.myrxjava.entity.UserInfo;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wenyingzhi on 2018/4/23.
 */

public class LoginPresenter extends LoginContract.LoginBasePresenter {

    @Inject
    public LoginApi loginApi;

    @Inject
    public LoginPresenter() {

    }

    @Override
    public void login() {
        String pass = mView.getPass();
        String user = mView.getUser();
        if (TextUtils.isEmpty(pass)) {
            mView.showToastMsg("请输入账号！");
        } else if (TextUtils.isEmpty(user)) {
            mView.showToastMsg("请输入密码！");
        } else {
            mView.showLoadDialog();
            Map<String, String> parameters = new HashMap<>();
            parameters.put("username", user);
            parameters.put("password", pass);
            parameters.put("enews", "login");
            parameters.put("lifetime", "315360000");

            loginApi.login(parameters)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<UserInfo>() {
                        @Override
                        public void onCompleted() {
                           mView.hideDialog();
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.hideDialog();
                            mView.showErrorMsg("请求网络失败！");
                            Log.d("wyz", "e::" + e.getMessage());
                        }

                        @Override
                        public void onNext(UserInfo info) {
                            Log.d("wyz", "请求数据：" + info);
                            mView.hideDialog();
                            mView.loginSuccess(info);
                        }
                    });
        }

    }
}
