package com.uestc.myapplication.presenter;

import com.uestc.myapplication.base.presenter.BasePresenter;
import com.uestc.myapplication.bean.FeedStreamBean;
import com.uestc.myapplication.contract.Home.HomeFriendContract;
import com.uestc.myapplication.model.HomeFriendModel;

import java.util.List;

public class HomeFriendPresenter extends BasePresenter<HomeFriendContract.IHomeView> implements HomeFriendContract.IHomePresenter {
    private HomeFriendContract.IHomeModel mHomeModel;
//    private HomeContract.IHomeView mHomeView;

    public HomeFriendPresenter(HomeFriendModel homeFriendModel, HomeFriendContract.IHomeView homeView){
        super();
        mHomeModel = homeFriendModel;
        attach(homeView);
    }


    @Override
    public void loadArticle() {
        if(mView != null && mHomeModel != null){
            mHomeModel.loadArticle(new HomeFriendContract.IHomeModel.OnLoadArticleListener() {
                @Override
                public void onSuccess(List<FeedStreamBean.ArticleData> articleList) {
                    mView.loadArticle(articleList);
                }

                @Override
                public void onError(String msg) {

                }
            });
        }
    }

    @Override
    public void refreshTopArticle() {
        if(mView != null && mHomeModel != null){
            mHomeModel.refreshArticle(new HomeFriendContract.IHomeModel.OnLoadArticleListener() {
                @Override
                public void onSuccess(List<FeedStreamBean.ArticleData> articleList) {
                    mView.refreshTopArticle(articleList);
                }

                @Override
                public void onError(String msg) {

                }
            });
        }
    }

    @Override
    public void refreshButtomArticle() {
        if(mView != null && mHomeModel != null){
            mHomeModel.refreshArticle(new HomeFriendContract.IHomeModel.OnLoadArticleListener() {
                @Override
                public void onSuccess(List<FeedStreamBean.ArticleData> articleList) {
                    mView.refreshButtomArticle(articleList);
                }

                @Override
                public void onError(String msg) {

                }
            });
        }
    }

}
