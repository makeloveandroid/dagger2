package com.example.mvp.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseMvpPresenter<V> {
    public CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public V mView;

    public void setView(V view){
        mView=view;
    }

    public void unSubscription(){
        mCompositeDisposable.clear();
    }
}

