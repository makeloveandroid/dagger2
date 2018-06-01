package com.example.mvp.base;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public abstract class BaseObserver<T> extends DisposableObserver<T> {

    public BaseObserver(CompositeDisposable compositeDisposable) {
        compositeDisposable.add(this);
    }
}
