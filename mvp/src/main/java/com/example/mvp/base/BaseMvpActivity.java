package com.example.mvp.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mvp.util.TUtil;

public abstract class BaseMvpActivity<P extends BaseMvpPresenter> extends AppCompatActivity{
    public  P presenter;
    public ProgressDialog progressDialog;

    public abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
        initData();
        findView();
        initView();
    }

    protected  void init(){
        progressDialog = new ProgressDialog(this);
        presenter=TUtil.getT(this,0);
        presenter.setView(this);
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void findView();
}
