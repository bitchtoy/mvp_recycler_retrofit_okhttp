package com.sequoia.mvpdemo.presenter;

import android.util.Log;

import com.sequoia.mvpdemo.OnRequestListen;
import com.sequoia.mvpdemo.Service;
import com.sequoia.mvpdemo.model.MvpModel;
import com.sequoia.mvpdemo.view.BaseView;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public class MvpPresenter {
    //presenter 绑定modle 和 view
    MvpModel mModel;
    BaseView mBaseView;
    public MvpPresenter(BaseView baseView){
        mBaseView = baseView;
        mModel = new MvpModel();
    }
    private void showDialog(){
        if (mBaseView != null){
            mBaseView.showDialog();
        }
    }
    private void hideDialog(){
        if (mBaseView != null){
            mBaseView.hideDialog();
        }
    }
    public void internetRequest(){
        getInternetCallBack();
    }
    private void upView(String s){
        mBaseView.initUpData(s);
    }
    private void saveToModel(String s){
        mModel.setinitData(s);
    }
    private void getInternetCallBack() {
        Service service = Service.getInstanceLoginService();
        showDialog();
        service.requestLoginApi(new OnRequestListen() {
            @Override
            public void onRequestSuccess(Call call, Response response) {
                saveToModel(response.body().toString());
                upView(response.body().toString());
                Log.d("---->",response.body().toString());
                hideDialog();
            }

            @Override
            public void onRequestFails(Call call, Throwable throwable) {
                saveToModel(throwable.toString());
                upView(throwable.toString());
                Log.d("---->",throwable.toString());
                hideDialog();
            }
        });

    }

}
