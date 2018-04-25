package com.example.myrxjava.base;

/**
 * Mvp中的view接口的，公用方法抽取
 */

public interface BaseMvpView {
    void showLoadDialog();
    void showErrorMsg(String msg);
    void showToastMsg(String msg);
    void hideDialog();
}
