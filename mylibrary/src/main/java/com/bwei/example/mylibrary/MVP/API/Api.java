package com.bwei.example.mylibrary.MVP.API;

import com.bwei.example.mylibrary.MVP.Model.Bean.LoginBean;
import com.bwei.example.mylibrary.MVP.Model.Bean.RegisterBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * 接口
 **/
public interface Api {

    //登录
    @POST("user/v1/login")
    Observable<LoginBean> LOGIN(@Query("phone") String phone, @Query("pwd") String pwd);

    //注册
    @POST("user/v1/register")
    Observable<RegisterBean> REGISTER(@Query("phone") String phone, @Query("pwd") String pwd);
}
