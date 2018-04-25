package com.example.mvp.ui.login;

import android.text.TextUtils;
import android.util.Log;

import com.example.mvp.R;
import com.example.mvp.api.LoginApi;
import com.example.mvp.contract.LoginContract;
import com.example.mvp.entity.UserInfo;
import com.example.mvp.helper.RetrofitCreateHelper;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenter extends LoginContract.LoginPresenter {
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
            RetrofitCreateHelper.getHelper()
                    .createApi(LoginApi.class)
                    .login(parameters)
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
                            mView.loginError("登陆失败");
                            Log.d("wyz", "e::" + e.getMessage());
                        }

                        @Override
                        public void onNext(UserInfo info) {
                            Log.d("wyz", "请求数据：" + info);
                            mView.hideDialog();
                            mView.loginSucccess(info);
                        }
                    });
        }
    }
}
