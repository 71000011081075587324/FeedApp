package com.uestc.myapplication.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.uestc.myapplication.Adapter.HomeFriendRecyclerAdapter;
import com.uestc.myapplication.R;
import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.base.presenter.BasePresenter;
import com.uestc.myapplication.bean.FeedStreamBean;
import com.uestc.myapplication.contract.Home.HomeFriendContract;

import java.util.ArrayList;
import java.util.List;

public class HomeFriendFragment extends BaseFragment implements HomeFriendContract.IHomeView{
    private RecyclerView mRecyclerView;
    private List<FeedStreamBean.ArticleData> mDatas;
    private HomeFriendRecyclerAdapter mFriendHomeRecyclerAdapter;
    private SmartRefreshLayout mSmartRefreshLayout;

    private HomeFriendContract.IHomePresenter mIHomePresenter;

//    public HomeFriendFragment(Context context, List<FeedStreamBean.ArticleData> ArticleList){
//        mContext = context;
//        mFriendHomeRecyclerAdapter = new HomeFriendRecyclerAdapter(mContext,ArticleList);
//    }

    public HomeFriendFragment(Context context){
        mContext = context;
    }

    /**
     * 每次创建、绘制该Fragment的View组件时回调该方法，Fragment将会显示该方法返回的View组件
     * 控件、页面的初始化
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return  返回初始化的view
     */
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        mIHomePresenter.loadArticle();
        return initView();
    }

    /**
     * 当Fragment所在的Activity被启动完成后回调该方法
     * 设置控件的点击事件放在其中
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View initView() {
        mView = View.inflate(mContext, R.layout.fragment_home_friend,null);
//        mDatas = new ArrayList<FeedStreamBean.ArticleData>();

        mFriendHomeRecyclerAdapter = new HomeFriendRecyclerAdapter(mContext,mDatas);
        mRecyclerView = mView.findViewById(R.id.recycler_view_home_friend);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mFriendHomeRecyclerAdapter);

        initRefresh();

//        //测试用数据
//        for(int i = 0; i < 15; i++){
////            mDatas.add(new FeedStreamBean.ArticleData());
//            mDatas.add(null);
//        }
////
//        if(!isDataInit()){
//            dataInit();
//        }

        return mView;
    }

    private void initRefresh(){
        mSmartRefreshLayout = mView.findViewById(R.id.smartreference_layout_home_friend);

        //设置 Header 样式
//        mSmartRefreshLayout.setRefreshHeader();

        //设置 Footer 样式
//        mSmartRefreshLayout.setRefreshFooter();

        //下拉刷新
        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            refreshLayout.autoRefresh();

//            for(int i = 0; i < 15; i++){
////                mDatas.add(i ,new FeedStreamBean.ArticleData("refresh" + i + "--" + i));
//                mDatas.add(null);
//            }

//            dataInit();


            //测试网路延迟
            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    mIHomePresenter.refreshTopArticle();
                    refreshLayout.finishRefresh();
                    mFriendHomeRecyclerAdapter.notifyDataSetChanged();
                }
            };
            handler.postDelayed(runnable,1500);


        });

        //上拉加载更多
        mSmartRefreshLayout.setOnLoadMoreListener(refreshLayout -> {
            refreshLayout.autoLoadMore();

//            for(int i = 0; i < 15; i++){
////                mDatas.add(new FeedStreamBean.ArticleData("refresh" + i + "--" + i));
//                mDatas.add(null);
//            }

//            dataInit();


            //测试网路延迟
            Handler handler = new Handler();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    mIHomePresenter.refreshButtomArticle();
                    refreshLayout.finishLoadMore();
                    mFriendHomeRecyclerAdapter.notifyDataSetChanged();
                }
            };
            handler.postDelayed(runnable,1500);

        });

    }

    @Override
    public void loadArticle(List<FeedStreamBean.ArticleData> articleList) {
        mDatas = articleList;
    }

    @Override
    public void refreshTopArticle(List<FeedStreamBean.ArticleData> articleList) {
        for(int i = 0; i < articleList.size(); i++){
            mDatas.add(0,articleList.get(articleList.size() - 1 - i));
        }
    }

    @Override
    public void refreshButtomArticle(List<FeedStreamBean.ArticleData> articleList) {
        mDatas.addAll(articleList);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        mIHomePresenter = (HomeFriendContract.IHomePresenter) presenter;
    }


//    @Override
//    public void dataInit() {
//
//        mFriendHomeRecyclerAdapter.notifyDataSetChanged();
//    }
//
//    @Override
//    public boolean isDataInit() {
//        return false;
//    }
//
//    @Override
//    public void setPresenter(Object presenter) {
//
//    }
}
