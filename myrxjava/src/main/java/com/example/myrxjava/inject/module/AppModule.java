package com.example.myrxjava.inject.module;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

import com.example.myrxjava.app.App;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 全局APP
 */
@Module
public class AppModule {
    @Provides
    public Context procideContext(){
        return App.getAppContext();
    }

    @Provides
    public Application provideApplication(){
        return App.getApplication();
    }

    @Singleton
    @Provides
    public Toast providesToast(Context context){
        return Toast.makeText(context,"",Toast.LENGTH_SHORT);
    }

}
