package com.example.mvp.app;

import android.app.Application;
import android.content.Context;


/**
 * Created by wenyingzhi on 2018/4/23.
 */

public class App extends Application {
    private static Application app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }

    public static Application getApplication(){
        return app;
    }

    public static Context getAppContext(){
        return app.getApplicationContext();
    }
}
