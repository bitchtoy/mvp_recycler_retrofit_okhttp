package com.sequoia.mvpdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.sequoia.mvpdemo.bean.Data;
import com.sequoia.mvpdemo.presenter.MvpPresenter;
import com.sequoia.mvpdemo.view.BaseView;

import java.util.List;

public class MainActivity extends BaseActivity  {
    RecyclerView rv;
    MvpPresenter mPresenter;
    @Override
    public void init(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        mPresenter = new MvpPresenter(this);
        mPresenter.internetRequest();
    }

    @Override
    public void initUpData(List<Data.Subjects.Casts> data) {
        super.initUpData(data);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        Adapter adapter = new Adapter(data,this);
        rv.setAdapter(adapter);

    }

}
