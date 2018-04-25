package com.example.myrxjava.base;

/**
 * 一个MVP的Presenter的抽取
 */

public class BasePresenter<T> {
    public T mView;

    public void setMvpView(T view) {
        mView = view;
    }
}
