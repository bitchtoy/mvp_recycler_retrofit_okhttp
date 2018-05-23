package com.sequoia.mvpdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.sequoia.mvpdemo.view.BaseView;

/**
 * @author Administrator.
 * @date 2018/5/23.
 * @funtion
 */
public abstract class  BaseActivity extends Activity implements BaseView {
    private ProgressDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

    }
    public abstract void init(Bundle savedInstanceState);

    @Override
    public void initUpData(String data) {

    }

    @Override
    public void showDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && dialog.isShowing()){
                    dialog.dismiss();
                }
                dialog = ProgressDialog.show(BaseActivity.this,"","请稍等...");
            }
        });
    }

    @Override
    public void hideDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && dialog.isShowing()){
                    dialog.dismiss();
                }

            }
        });

    }

    @Override
    public void toast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
