package com.uestc.myapplication.contract.Home;

import com.uestc.myapplication.base.presenter.BasePresenter;
import com.uestc.myapplication.base.ui.BaseView;
import com.uestc.myapplication.ui.fragment.HomeFragment;

public interface HomeContract {
    interface IHomePresenter {
    }

    interface IHomeView extends BaseView {
        void showLoading();
        void hideLoading();
        void showError();
    }

    interface IHomeModel{

    }

}
