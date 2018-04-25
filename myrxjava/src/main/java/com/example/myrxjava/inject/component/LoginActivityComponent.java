package com.example.myrxjava.inject.component;

import com.example.myrxjava.scope.LoginSingleton;
import com.example.myrxjava.ui.login.LoginActivity;
import com.example.myrxjava.ui.login.LoginModule;

import dagger.Component;

/**
 * Created by wenyingzhi on 2018/4/23.
 */
@LoginSingleton
@Component(modules = {LoginModule.class},dependencies = {AppComponent.class})
public interface LoginActivityComponent {
    void inject(LoginActivity activity);
}
