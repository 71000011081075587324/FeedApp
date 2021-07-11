package com.uestc.myapplication.base.presenter;

import com.uestc.myapplication.base.ui.BaseView;

public abstract class BasePresenter<T extends BaseView> {
    protected T mView;

    public void attach(T view){
        mView = view;
    }

    public void detachVP(){
        mView = null;
    }




}
