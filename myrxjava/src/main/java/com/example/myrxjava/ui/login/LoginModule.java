package com.example.myrxjava.ui.login;

import com.example.myrxjava.api.LoginApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class LoginModule {
    /**
     * 提供登陆的api的请求对象
     * @param retrofit
     * @return
     */
    @Provides
    public LoginApi providesLoginApi(Retrofit retrofit){
        return retrofit.create(LoginApi.class);
    }

}
