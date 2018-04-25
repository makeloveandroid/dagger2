package com.example.mvp.contract;

import com.example.mvp.base.BaseMvpPresenter;
import com.example.mvp.base.BaseMvpView;
import com.example.mvp.entity.UserInfo;

public interface LoginContract {
     interface LoginView extends BaseMvpView{
         String getUser();
         String getPass();
         void loginSucccess(UserInfo userInfo);
         void loginError(String msg);
     }

    abstract class  LoginPresenter extends BaseMvpPresenter<LoginView>{
         public abstract void login();
    }
}
