package com.example.mvp.base;

public abstract class BaseMvpPresenter<V> {
    public V mView;

    public void setView(V view){
        mView=view;
    }

}
