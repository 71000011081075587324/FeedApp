package com.uestc.myapplication.presenter;

import com.uestc.myapplication.base.presenter.BasePresenter;
import com.uestc.myapplication.contract.Home.HomeContract;
import com.uestc.myapplication.model.HomeModel;
import com.uestc.myapplication.ui.fragment.HomeFragment;

public class HomePresenter extends BasePresenter<HomeContract.IHomeView> implements HomeContract.IHomePresenter {
    private HomeContract.IHomeModel mHomeModel;
//    private HomeContract.IHomeView mHomeView;

    public HomePresenter(HomeModel homeModel, HomeContract.IHomeView homeView){
        super();
        mHomeModel = homeModel;
        attach(homeView);
    }


}
