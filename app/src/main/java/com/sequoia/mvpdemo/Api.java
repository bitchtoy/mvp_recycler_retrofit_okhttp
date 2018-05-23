package com.sequoia.mvpdemo;

import com.sequoia.mvpdemo.bean.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public interface Api {
    @GET("top250")
    Call<Data> getData(@Query("start")int start, @Query("count") int count);
}
