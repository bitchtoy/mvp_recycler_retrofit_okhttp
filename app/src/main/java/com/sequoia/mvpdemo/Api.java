package com.sequoia.mvpdemo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public interface Api {
    @GET("/")
    Call<String> getData();


}
