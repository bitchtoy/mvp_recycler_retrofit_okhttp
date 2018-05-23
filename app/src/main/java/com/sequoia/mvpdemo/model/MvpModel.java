package com.sequoia.mvpdemo.model;

import com.sequoia.mvpdemo.bean.Data;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public class MvpModel implements Model {
    private List<Data.Subjects.Casts> s;

    @Override
    public void setinitData(List<Data.Subjects.Casts> datas) {
        s = datas;
    }

    @Override
    public List<Data.Subjects.Casts> getData() {
        return s;
    }
}
