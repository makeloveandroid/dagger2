package com.example.myrxjava.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.myrxjava.util.TUtil;

/**
 * 一个简单的BaseActivity封装
 */
public abstract class  BaseActivity extends AppCompatActivity{
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
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void findView();
}
