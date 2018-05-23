package com.sequoia.mvpdemo;

import android.support.annotation.Nullable;

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

    public void requestLoginApi(final OnRequestListen loginListen) {
        final Call<String> loginCall = buildApi(buildClient()).getData();
        loginCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (loginListen != null) {
                    loginListen.onRequestSuccess(call, response);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
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
        return new Retrofit.Builder().baseUrl("https://www.baidu.com/").client(client)
                .addConverterFactory(new Converter.Factory() {
                    @Nullable
                    @Override
                    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
                        return new Converter<ResponseBody, String>() {
                            @Override
                            public String convert(ResponseBody value) throws IOException {
                                return value.string();
                            }
                        };
                    }
                })
                .build().create(Api.class);

    }



}
