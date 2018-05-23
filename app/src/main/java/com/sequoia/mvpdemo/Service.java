package com.sequoia.mvpdemo;

import android.support.annotation.Nullable;

import com.sequoia.mvpdemo.bean.Data;
import com.sequoia.mvpdemo.utils.HttpUrls;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public class Service {
    private Call mCall;

    public static Service getInstanceLoginService() {
        return new Service();
    }

    public void requestLoginApi(final OnRequestListen loginListen,int start,int count) {
        final Call<Data> loginCall = buildApi(buildClient()).getData(start,count);
        loginCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (loginListen != null) {
                    loginListen.onRequestSuccess(call, response);
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                if (loginListen != null) {
                    loginListen.onRequestFails(call, t);
                }
            }
        });
        mCall = loginCall;

    }

    public void cancle() {
        if (mCall != null) {
            mCall.cancel();
        }
    }

    private OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new CoustomInterceptor()).build();
    }

    private Api buildApi(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(HttpUrls.DOU_BAN).client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Api.class);

    }



}
