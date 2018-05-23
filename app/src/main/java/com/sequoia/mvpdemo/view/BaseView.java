package com.sequoia.mvpdemo.view;

import com.sequoia.mvpdemo.bean.Data;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/23.
 * @funtion
 */
public interface BaseView {
    void initUpData(List<Data.Subjects.Casts> data);
    void showDialog();
    void hideDialog();
    void toast(String s);



}
