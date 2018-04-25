package com.example.myrxjava.inject.module;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;


import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 访问网络的Module
 */
@Module
@Singleton
public class ApiModule {
    public static final String BASE_URL = "https://www.iqshw.com/";

    @Provides
    public Interceptor providesIntercepter() {
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

    @Provides
    public Cache providesCache(Context context) {
        File httpCacheFile = context.getExternalCacheDir().getAbsoluteFile();
        return new Cache(httpCacheFile, 1024 * 10 * 1024);
    }


    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient(Interceptor interceptor, Cache cache) {

        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .build();

        return client;
    }



    @Provides
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

}
