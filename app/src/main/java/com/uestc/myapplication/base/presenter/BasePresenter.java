package com.uestc.myapplication.base.presenter;

import com.uestc.myapplication.base.ui.BaseView;
import com.uestc.myapplication.contract.Home.HomeContract;

public abstract class BasePresenter<T extends BaseView> {
    T mView;

    public void attach(T view){
        mView = view;
    }

    public void detachVP(){
        mView = null;
    }




}
