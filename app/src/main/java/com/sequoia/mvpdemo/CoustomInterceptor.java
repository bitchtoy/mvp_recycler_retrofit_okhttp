package com.sequoia.mvpdemo;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Administrator.
 * @date 2018/4/24.
 * @funtion
 */
//网络请求拦截器
public class CoustomInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request;
        request = chain.request();
        Response response = chain.proceed(request);
        return response;
    }
}
