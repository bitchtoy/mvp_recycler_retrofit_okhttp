package com.sequoia.mvpdemo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public interface OnRequestListen<T> {
    void onRequestSuccess(Call<T> call, Response<T> response);
    void onRequestFails(Call<T> call,Throwable throwable);
}
