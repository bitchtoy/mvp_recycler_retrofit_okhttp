package com.sequoia.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.sequoia.mvpdemo.presenter.MvpPresenter;
import com.sequoia.mvpdemo.view.BaseView;

public class MainActivity extends BaseActivity  {
    TextView tv;
    MvpPresenter mPresenter;
    @Override
    public void init(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        mPresenter = new MvpPresenter(this);
        mPresenter.internetRequest();
    }

    @Override
    public void initUpData(String data) {
        super.initUpData(data);
        tv.setText(data);
    }

}
