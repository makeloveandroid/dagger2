package com.example.mvp.base;

public interface BaseMvpView {
    void showLoadDialog();
    void showErrorMsg(String msg);
    void showToastMsg(String msg);
    void hideDialog();
}
