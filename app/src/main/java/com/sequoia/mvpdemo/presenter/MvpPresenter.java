package com.sequoia.mvpdemo.presenter;

import android.util.Log;

import com.sequoia.mvpdemo.OnRequestListen;
import com.sequoia.mvpdemo.Service;
import com.sequoia.mvpdemo.bean.Data;
import com.sequoia.mvpdemo.model.MvpModel;
import com.sequoia.mvpdemo.view.BaseView;

import java.util.ArrayList;
import java.util.List;

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
    private void upView(List<Data.Subjects.Casts> s){
        mBaseView.initUpData(s);
    }
    private void saveToModel(List<Data.Subjects.Casts> s){
        mModel.setinitData(s);
    }
    private void getInternetCallBack() {
        final Service service = Service.getInstanceLoginService();
        showDialog();
        OnRequestListen<Data> onRequestListen = new OnRequestListen<Data>() {
            @Override
            public void onRequestSuccess(Call<Data> call, Response<Data> response) {
                if (response.code() == 200){
                    Data data = response.body();
                    List<Data.Subjects> subjects = data.subjects;
                    List<Data.Subjects.Casts> casts = new ArrayList<>();
                    for (int i=0;i<subjects.size();i++){
                        casts.addAll(subjects.get(i).casts);
                    }
                    upView(casts);
                    saveToModel(casts);
                    hideDialog();
                }

            }

            @Override
            public void onRequestFails(Call<Data> call, Throwable throwable) {

            }
        };
        service.requestLoginApi(onRequestListen,0,20);

    }

}
