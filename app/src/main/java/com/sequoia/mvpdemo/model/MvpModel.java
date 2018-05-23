package com.sequoia.mvpdemo.model;

import javax.inject.Inject;

/**
 * @author Administrator.
 * @date 2018/5/16.
 * @funtion
 */
public class MvpModel implements Model {
    private String s;

    @Override
    public void setinitData(String datas) {
        s = datas;
    }

    @Override
    public String getData() {
        return s;
    }
}
