package com.example.myrxjava.constract;

import com.example.myrxjava.base.BaseMvpView;
import com.example.myrxjava.base.BasePresenter;
import com.example.myrxjava.entity.LoginInfo;
import com.example.myrxjava.entity.UserInfo;


/**
 * Created by wenyingzhi on 2018/4/23.
 */

public interface LoginContract {
    interface LoginMvpView extends BaseMvpView{
        void loginSuccess(UserInfo userInfo);
        String getUser();
        String getPass();
    }

    abstract class LoginBasePresenter extends BasePresenter<LoginMvpView>{
        public abstract void login();
    }

}
