package com.example.mvp.helper;



import android.content.Context;
import android.text.TextUtils;

import com.example.mvp.app.App;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Horrarndoo on 2017/9/7.
 * <p>
 */

public class RetrofitCreateHelper {

    public static final String BASE_URL = "https://www.iqshw.com/";
    private Retrofit retrofit;

    //郁闷还要写单利 dagger2 1个注解就oK
    private RetrofitCreateHelper(){
        createRetrofit();
    }

    public static RetrofitCreateHelper getHelper() {
        return Holder.holder;
    }

    public static class Holder{
        public static RetrofitCreateHelper holder=new RetrofitCreateHelper();
    }



    private  Interceptor getIntercepter() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                String chainControl = request.cacheControl().toString();
                if (TextUtils.isEmpty(chainControl)) {
                    chainControl = "public, max-age=60, max-stale=240000";
                }

                return response.newBuilder()
                        .addHeader("Chain-Control", chainControl)
                        .removeHeader("Pragma")
                        .build();
            }
        };
    }

    private  Cache getCache(Context context) {
        File httpCacheFile = context.getExternalCacheDir().getAbsoluteFile();
        return new Cache(httpCacheFile, 1024 * 10 * 1024);
    }


    public  OkHttpClient getHttpClient(Interceptor interceptor, Cache cache) {

        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .build();

        return client;
    }

    private void createRetrofit(){
        //这里我感受到了Dagger2的好处了
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getHttpClient(getIntercepter(),getCache(App.getAppContext())))//这里我感受到了Dagger2的好处了
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public  <T> T createApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}

