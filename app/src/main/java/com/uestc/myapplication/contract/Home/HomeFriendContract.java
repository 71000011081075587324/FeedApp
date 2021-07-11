package com.uestc.myapplication.contract.Home;

import com.uestc.myapplication.base.presenter.BasePresenter;
import com.uestc.myapplication.base.ui.BaseView;
import com.uestc.myapplication.bean.FeedStreamBean;
import com.uestc.myapplication.ui.fragment.HomeFragment;

import java.util.List;

public class HomeFriendContract {
    public interface IHomePresenter {
        /**
         * 首页文章
         */
        void loadArticle();

        /**
         * 下拉刷新获取ArticleList数据
         */
        void refreshTopArticle();

        /**
         * 上拉刷新获取ArticleList数据
         */
        void refreshButtomArticle();
    }

    public interface IHomeView extends BaseView {
        /**
         * 获取ArticleList数据进行显示
         * @param articleList
         */
        void loadArticle(List<FeedStreamBean.ArticleData> articleList);

        /**
         * 下拉刷新获取ArticleList数据
         * @param articleList
         */
        void refreshTopArticle(List<FeedStreamBean.ArticleData> articleList);

        /**
         * 上拉刷新获取ArticleList数据
         * @param articleList
         */
        void refreshButtomArticle(List<FeedStreamBean.ArticleData> articleList);

//        void showLoading();
//        void hideLoading();
//        void showError();
    }

    public interface IHomeModel{

        /**
         * 获取文章数据
         */
        void loadArticle(OnLoadArticleListener onLoadArticleListener);

        interface OnLoadArticleListener{
            void onSuccess(List<FeedStreamBean.ArticleData> articleList);
            void onError(String msg);
        }

        /**
         * 刷新获取ArticleList数据
         */
        void refreshArticle(OnLoadArticleListener onLoadArticleListener);

    }

}
