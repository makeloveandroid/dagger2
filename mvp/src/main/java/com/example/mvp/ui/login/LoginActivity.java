package com.example.mvp.ui.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.app.App;
import com.example.mvp.base.BaseMvpActivity;
import com.example.mvp.base.BaseMvpPresenter;
import com.example.mvp.contract.LoginContract;
import com.example.mvp.entity.UserInfo;
import com.example.mvp.util.ToastUtil;

public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.LoginView{

    private EditText etPass;
    private EditText etUser;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        progressDialog.setTitle("请稍后");
        progressDialog.setMessage("正在加载。。。");
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void findView() {
        Button btLogin = findViewById(R.id.bt_login);
        etPass = findViewById(R.id.et_pass);
        etUser = findViewById(R.id.et_user);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.login();
            }
        });
    }


    @Override
    public void showLoadDialog() {
        progressDialog.show();
    }

    @Override
    public void showErrorMsg(String msg) {
        Log.d("wyz", "数据错误`消息：" + msg+" ");
        ToastUtil.showToast(msg);
    }

    @Override
    public void showToastMsg(String msg) {
        Log.d("wyz", "数据消息：" + msg+" ");
        ToastUtil.showToast(msg);
    }

    @Override
    public void hideDialog() {
        progressDialog.hide();
    }



    @Override
    public String getUser() {
        return etUser.getText().toString();
    }

    @Override
    public String getPass() {
        return etPass.getText().toString();
    }

    @Override
    public void loginSucccess(UserInfo userInfo) {
        ToastUtil.showToast("UserInfo：" +userInfo);
    }

    @Override
    public void loginError(String msg) {

    }
}
