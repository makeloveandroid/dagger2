package com.example.mvp.api;


import com.example.mvp.entity.UserInfo;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wenyingzhi on 2018/4/23.
 */

//登陆请求的API
public interface LoginApi {
    @FormUrlEncoded
    @POST("/e/member/ajaxlogin/")
    Observable<UserInfo> login(@FieldMap Map<String, String> parameters);
}
