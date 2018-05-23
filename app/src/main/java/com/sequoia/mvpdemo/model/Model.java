package com.sequoia.mvpdemo.model;

import com.sequoia.mvpdemo.bean.Data;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/23.
 * @funtion
 */
public interface Model {
    void setinitData(List<Data.Subjects.Casts> datas);
    List<Data.Subjects.Casts> getData();
}
