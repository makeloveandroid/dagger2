package com.example.mvp.api;


import com.example.mvp.entity.UserInfo;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by wenyingzhi on 2018/4/23.
 */

//登陆请求的API
public interface LoginApi {
    @FormUrlEncoded
    @POST("/e/member/ajaxlogin/")
    Observable<UserInfo> login(@FieldMap Map<String, String> parameters);
}
