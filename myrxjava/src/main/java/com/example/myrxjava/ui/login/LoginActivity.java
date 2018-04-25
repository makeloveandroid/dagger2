package com.example.myrxjava.ui.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myrxjava.R;
import com.example.myrxjava.app.App;
import com.example.myrxjava.base.BaseActivity;


import com.example.myrxjava.constract.LoginContract;
import com.example.myrxjava.entity.UserInfo;
import com.example.myrxjava.inject.component.DaggerLoginActivityComponent;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginContract.LoginMvpView{
    @Inject
    public LoginPresenter loginPresenter;
    @Inject
    public Toast toast;

    private EditText etPass;
    private EditText etUser;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        progressDialog.setTitle("请稍后");
        progressDialog.setMessage("正在加载。。。");
    }

    @Override
    protected void initData() {
        //注入
        DaggerLoginActivityComponent.builder().appComponent(App.appComponent).build().inject(this);
        //设置view
        loginPresenter.setMvpView(this);
    }


    @Override
    protected void findView() {
        Button btLogin = findViewById(R.id.bt_login);
        etPass = findViewById(R.id.et_pass);
        etUser = findViewById(R.id.et_user);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login();
            }
        });
    }


    @Override
    public void showLoadDialog() {
        progressDialog.show();
    }

    @Override
    public void showErrorMsg(String msg) {
        Log.d("wyz", "数据错误`消息：" + msg+" "+toast);
        toast.setText(msg);
        toast.show();
    }

    @Override
    public void showToastMsg(String msg) {
        Log.d("wyz", "数据消息：" + msg+" "+toast);
        toast.setText(msg);
        toast.show();
    }

    @Override
    public void hideDialog() {
        progressDialog.hide();
    }

    @Override
    public void loginSuccess(UserInfo userInfo) {
        toast.setText("UserInfo：" +userInfo);
        toast.show();
    }

    @Override
    public String getUser() {
        return etUser.getText().toString();
    }

    @Override
    public String getPass() {
        return etPass.getText().toString();
    }
}
