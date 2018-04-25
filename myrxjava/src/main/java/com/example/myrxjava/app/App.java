package com.example.myrxjava.app;

import android.app.Application;
import android.content.Context;

import com.example.myrxjava.inject.component.AppComponent;
import com.example.myrxjava.inject.component.DaggerAppComponent;

import javax.inject.Inject;

/**
 * Created by wenyingzhi on 2018/4/23.
 */

public class App extends Application {
    private static Application app;
    public static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        //初始化全局AppComponent,主要对module里面单利和app处于一个生命周期
        appComponent = DaggerAppComponent.create();
    }

    public static Application getApplication(){
        return app;
    }

    public static Context getAppContext(){
        return app.getApplicationContext();
    }
}
