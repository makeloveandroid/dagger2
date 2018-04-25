package com.example.myrxjava.inject.component;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.example.myrxjava.inject.module.ApiModule;
import com.example.myrxjava.inject.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by wenyingzhi on 2018/4/23.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    Context getContext();
    Application getApplication();
    Retrofit getRetrofit();
    Toast getToast();
}
