package com.uestc.myapplication.model;

import com.uestc.myapplication.contract.Home.HomeContract;

public class HomeModel implements HomeContract.IHomeModel {

    private static HomeModel sHomeModel = null;

    public static HomeModel getInstance(){
        if(sHomeModel == null){
            sHomeModel = new HomeModel();
        }
        return sHomeModel;
    }

}
