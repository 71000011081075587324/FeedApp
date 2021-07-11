package com.uestc.myapplication.base.ui;

import com.uestc.myapplication.base.presenter.BasePresenter;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
